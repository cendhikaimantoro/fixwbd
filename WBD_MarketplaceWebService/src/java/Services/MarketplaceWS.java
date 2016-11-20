/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.ArrayList;
import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.jws.WebResult;

import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author ASUS-A451LB
 */
@WebService(serviceName = "MarketplaceWS")
public class MarketplaceWS {

  Connection conn = DB.connect();
  /**
   * This is a sample web service operation
   */
  @WebMethod(operationName = "hello")
  public String hello(@WebParam(name = "name") String txt) {
    return "Hello " + txt + " !";
  }
  
  @WebMethod(operationName = "validateToken")
  public int validateToken(@WebParam(name = "token") String token){
    try {
      String url = "http://localhost:8082/WBD_IdentityService/validation_servlet"; // link servlet for validating token
      String USER_AGENT = "Mozilla/5.0";
      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      //add request header
      con.setRequestMethod("POST");
      con.setRequestProperty("User-Agent", USER_AGENT);
      con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

      String urlParameters = "token="+token; // parameters for the request

      // Send post request
      con.setDoOutput(true);
      DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      wr.writeBytes(urlParameters);
      wr.flush();
      wr.close();

      int responseCode = con.getResponseCode();
      // System.out.println("\nSending 'POST' request to URL : " + url);
      // System.out.println("Post parameters : " + urlParameters);
      // System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(
              new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      //print result
      // System.out.println(response.toString());

      
      if (response.toString().equals("EXPIRED")) { // expired
        return -1;
      } else if (response.toString().equals("INVALID")) { // not valid
        return -2;
      } else if (response.toString().equals("NOT LOGGED IN")) {
        return -3;
      } else { // valid
        return Integer.parseInt(response.toString());
      }
      //return response.toString();
    } catch (Exception e) {
      return -10000;
    }
  }

  /**
   * Web service operation
   * @param n
   * @param token
   */
  @WebMethod(operationName = "getCatalogList")
  @WebResult(name="Product")
  public ArrayList<Product> getCatalogList(@WebParam(name = "n") int n, @WebParam(name = "token") int token) {
    //TODO write your implementation code here:
    ArrayList<Product> products = new ArrayList<>();
    Boolean valid = validateToken(""+token) > 0;
    try{
        
        if (valid) {
          Statement stmt = conn.createStatement();
          String sql = "SELECT * FROM (product LEFT OUTER JOIN ( SELECT product_id AS id, COUNT(user_id) AS nlike FROM liked GROUP BY product_id ) AS countlike ON product.id = countlike.id ) LEFT OUTER JOIN ( SELECT product_id AS id, COUNT(user_id) AS liked FROM liked WHERE user_id = ? GROUP BY product_id ) AS isliked ON product.id = isliked.id ORDER BY add_time DESC";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1,token);
          ResultSet rs = dbStatement.executeQuery();

          int i = 0;
          int tempI;
          Timestamp tempTS;
          Boolean tempB;
          String tempS;
          while (i < n && rs.next()) {
              products.add(new Product(rs.getInt("id") , rs.getInt("seller_id"), rs.getString("seller_username"), rs.getString("product_name"), rs.getInt("price"), rs.getTimestamp("add_time"), rs.getString("photo"), rs.getString("description"), rs.getInt("amount_purchased"), rs.getInt("nlike"), rs.getString("liked") != null, valid));
          }
        } else {
          products.add(new Product(validateToken(""+token) , 0, "", "", 0, new Timestamp(0), "", "", 0, 0, false, false));
        }
    } catch (Exception e) {
      
    }
    return products;
  }
  
  /**
   * Web service operation
   * @param mode
   * @param key
   * @param n
   * @param token
   */
  @WebMethod(operationName = "getCatalogSearch")
  @WebResult(name="Product")
  public ArrayList<Product> getCatalogSearch(@WebParam(name = "mode") String mode, @WebParam(name = "key") String key, @WebParam(name = "n") int n, @WebParam(name = "token") int token) {
    ArrayList<Product> products = new ArrayList<>();
    Boolean valid = validateToken(""+token) > 0;
    try {
        if (valid) {
          Statement stmt = conn.createStatement();
          String sql;
          if (mode.equals("product")) {
            sql = "SELECT * FROM ((SELECT * FROM product WHERE product_name LIKE ?) AS fproduct LEFT OUTER JOIN ( SELECT product_id AS id, COUNT(user_id) AS nlike FROM liked GROUP BY product_id ) AS countlike ON fproduct.id = countlike.id ) LEFT OUTER JOIN ( SELECT product_id AS id, COUNT(user_id) AS liked FROM liked WHERE user_id = ? GROUP BY product_id ) AS isliked ON fproduct.id = isliked.id ORDER BY add_time DESC";
          } else {
            sql = "SELECT * FROM ((SELECT * FROM product WHERE seller_username LIKE ?) AS fproduct LEFT OUTER JOIN ( SELECT product_id AS id, COUNT(user_id) AS nlike FROM liked GROUP BY product_id ) AS countlike ON fproduct.id = countlike.id ) LEFT OUTER JOIN ( SELECT product_id AS id, COUNT(user_id) AS liked FROM liked WHERE user_id = ? GROUP BY product_id ) AS isliked ON fproduct.id = isliked.id ORDER BY add_time DESC";
          }
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setString(1,"%" + key + "%");
          dbStatement.setInt(2,token);
          ResultSet rs = dbStatement.executeQuery();
          int i = 0;
          while (i < n && rs.next()) {
              products.add(new Product(rs.getInt("id") , rs.getInt("seller_id"), rs.getString("seller_username"), rs.getString("product_name"), rs.getInt("price"), rs.getTimestamp("add_time"), rs.getString("photo"), rs.getString("description"), rs.getInt("amount_purchased"), rs.getInt("nlike"), rs.getString("liked") != null, valid));
          }
        } else {
          products.add(new Product(validateToken(""+token) , 0, "", "", 0, new Timestamp(0), "", "", 0, 0, false, false));
        }
    } catch (Exception e) {
        //products.add(new Product(idxErr , 0, "", e.getMessage(), 0, new Timestamp(123), "", "", 0, 0, false, false));
    }
    return products;
  }
  
  /**
   * Web service operation
   * @param n
   * @param token
   */
  @WebMethod(operationName = "getYourProducts")
  @WebResult(name="Product")
  public ArrayList<Product> getYourProducts(@WebParam(name = "n") int n, @WebParam(name = "token") int token) {
    ArrayList<Product> products = new ArrayList<>();
    Boolean valid = validateToken(""+token) > 0;
    try {
        if (valid) {
          Statement stmt = conn.createStatement();
          String sql;
          sql = "SELECT * FROM ((SELECT * FROM product WHERE seller_id = ?) AS fproduct LEFT OUTER JOIN ( SELECT product_id AS id, COUNT(user_id) AS nlike FROM liked GROUP BY product_id ) AS countlike ON fproduct.id = countlike.id ) LEFT OUTER JOIN ( SELECT product_id AS id, COUNT(user_id) AS liked FROM liked WHERE user_id = ? GROUP BY product_id ) AS isliked ON fproduct.id = isliked.id ORDER BY add_time DESC";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1, token);
          dbStatement.setInt(2,token);
          ResultSet rs = dbStatement.executeQuery();
          int i = 0;
          while (i < n && rs.next()) {
              products.add(new Product(rs.getInt("id") , rs.getInt("seller_id"), rs.getString("seller_username"), rs.getString("product_name"), rs.getInt("price"), rs.getTimestamp("add_time"), rs.getString("photo"), rs.getString("description"), rs.getInt("amount_purchased"), rs.getInt("nlike"), rs.getString("liked") != null, valid));
          }
        } else {
          products.add(new Product(validateToken(""+token) , 0, "", "", 0, new Timestamp(0), "", "", 0, 0, false, false));
        }
    } catch (Exception e) {
        //products.add(new Product(idxErr , 0, "", e.getMessage(), 0, new Timestamp(123), "", "", 0, 0, false, false));
    }
    return products;
  }
  
  /**
   * Web service operation
   * @param id
   * @param token
   */
  @WebMethod(operationName = "setLike")
  public int setLike(@WebParam(name = "id") int id, @WebParam(name = "token") int token) {
    //TODO write your implementation code here:
    int valid = validateToken(""+token);
    int idxErr = 0;
    
    try {
      if (valid > 0) {
          Statement stmt = conn.createStatement();
          String sql = "SELECT * FROM liked WHERE user_id = ? AND product_id = ?";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1,token);
          dbStatement.setInt(2,id);
          ResultSet rs = dbStatement.executeQuery();
          int i = -1;
          while (rs.next()) {
              i = rs.getInt("user_id");
          }
          if (i == -1) {
            sql = "INSERT INTO liked (user_id, product_id) VALUES (?, ?)";
          } else {
            sql = "DELETE FROM liked WHERE user_id = ? AND product_id = ?";
          }
          dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1,token);
          dbStatement.setInt(2,id);
          dbStatement.executeUpdate();
        }
    } catch (Exception e) {
        valid = idxErr;
    }
     return valid;
  }

  /**
   * Web service operation
   * @param id
   * @param token
   * @throws java.lang.Exception
   */
  @WebMethod(operationName = "getProduct")
  @WebResult(name="Product")
  public Product getProduct(@WebParam(name = "id") int id, @WebParam(name = "token") int token){
    //TODO write your implementation code here:
    Product product = null;
    Boolean valid = validateToken(""+token) > 0;
    try {
        if (valid) {
          Statement stmt = conn.createStatement();
          String sql = "SELECT * FROM product WHERE id = ?";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1, id);
          ResultSet rs = dbStatement.executeQuery();
          int i = 0;
          while (rs.next()) {
              product = new Product(rs.getInt("id") , rs.getInt("seller_id"), rs.getString("seller_username"), rs.getString("product_name"), rs.getInt("price"), rs.getTimestamp("add_time"), rs.getString("photo"), rs.getString("description"), rs.getInt("amount_purchased"), 0, false, valid);
          }
        } else {
          product = new Product(validateToken(""+token) , 0, "", "", 0, new Timestamp(0), "", "", 0, 0, false, false);
        }
    } catch (Exception e) {
        //product = new Product(idxErr , 0, "", e.getMessage(), 0, new Timestamp(123),"","", 0,0, false, false);
    }
    return product;
  }

  /**
   * Web service operation
   * @param product_id
   * @param buyer_username
   * @param quantity
   * @param consignee
   * @param full_address
   * @param postal_code
   * @param phone_number
   * @param card_number
   * @param card_verification
   * @param token
   */
  @WebMethod(operationName = "addPurchase")
  public int addPurchase(@WebParam(name = "product_id") int product_id, @WebParam(name = "buyer_username") String buyer_username, @WebParam(name = "quantity") int quantity, @WebParam(name = "consignee") String consignee, @WebParam(name = "full_address") String full_address, @WebParam(name = "postal_code") String postal_code, @WebParam(name = "phone_number") String phone_number, @WebParam(name = "card_number") String card_number, @WebParam(name = "card_verification") String card_verification, @WebParam(name = "token") int token) {
    //TODO write your implementation code here:
    int valid = validateToken(""+token);
    try {
      if (valid > 0) {
          Statement stmt = conn.createStatement();
          
          
          String sql = "SELECT * FROM product WHERE id = ?";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1,product_id);
          ResultSet rs1 = dbStatement.executeQuery();
          Boolean b = (rs1.next());
          
          stmt = conn.createStatement();
          sql = "INSERT INTO purchase "
                  + "(id, buyer_id, buyer_username, "
                  + "seller_id, seller_username, "
                  + "product_name, photo, price, "
                  + "quantity, consignee, full_address, "
                  + "postal_code, phone_number, "
                  + "card_number, card_verification, purchase_time) "
                  + "VALUES (NULL, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW()) ";
          dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1, token);
          dbStatement.setString(2, buyer_username);
          dbStatement.setInt(3, rs1.getInt("seller_id"));
          dbStatement.setString(4, rs1.getString("seller_username"));
          dbStatement.setString(5, rs1.getString("product_name"));
          dbStatement.setString(6, rs1.getString("photo"));
          dbStatement.setInt(7, rs1.getInt("price"));
          dbStatement.setInt(8, quantity);
          dbStatement.setString(9, consignee);
          dbStatement.setString(10, full_address);
          dbStatement.setString(11, postal_code);
          dbStatement.setString(12, phone_number);
          dbStatement.setString(13, card_number);
          dbStatement.setString(14, card_verification);
          dbStatement.executeUpdate();
          sql = "UPDATE product SET amount_purchased = ? WHERE id = ?";
          dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1,rs1.getInt("amount_purchased") + quantity);
          dbStatement.setInt(2,product_id);
          dbStatement.executeUpdate();
        }
    } catch (Exception e) {
    }
     return valid;
  }

  /**
   * Web service operation
   * @param product_name
   * @param seller_username
   * @param price
   * @param photo
   * @param description
   * @param token
   */
  @WebMethod(operationName = "addProduct")
  public int addProduct(@WebParam(name = "product_name") String product_name, @WebParam(name = "seller_username") String seller_username, @WebParam(name = "price") int price, @WebParam(name = "photo") String photo, @WebParam(name = "description") String description, @WebParam(name = "token") int token) {
    
    int valid = validateToken(""+token);
    try {
        if (valid > 0) {
          Statement stmt = conn.createStatement();
          String sql = "INSERT INTO product (id, seller_id, seller_username, product_name, price, add_time, photo, description, amount_purchased) VALUES (NULL, ?, ?, ?, ?, NOW(), ?, ?, 0)";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1, token);
          dbStatement.setString(2, seller_username);
          dbStatement.setString(3, product_name);
          dbStatement.setInt(4, price);
          dbStatement.setString(5, photo);
          dbStatement.setString(6, description);
          dbStatement.executeUpdate();
        }
    } catch (Exception e) {
        
    }
    
    return valid;
  }
  
    /**
   * Web service operation
   * @param id
   * @param token
   */
  @WebMethod(operationName = "deleteProduct")
  public int deleteProduct(@WebParam(name = "id") int id, @WebParam(name = "token") int token) {
    //TODO write your implementation code here:
    int valid = validateToken(""+token);
    try {
        if (valid > 0) {
          Statement stmt = conn.createStatement();
          
          String sql = "DELETE FROM liked WHERE product_id = ?";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1, id);
          dbStatement.executeUpdate();
          
          sql = "DELETE FROM product WHERE id = ? AND seller_id = ?";
          dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1, id);
          dbStatement.setInt(2, token);
          dbStatement.executeUpdate();
        }
    } catch (Exception e) {
        
    }
    
    return valid;
  }
  
    /**
   * Web service operation
   * @param id
   * @param product_name
   * @param price
   * @param photo
   * @param description
   * @param token
   */
  @WebMethod(operationName = "editProduct")
  public int editProduct(@WebParam(name = "id") int id, @WebParam(name = "product_name") String product_name, @WebParam(name = "price") int price, @WebParam(name = "description") String description, @WebParam(name = "token") int token) {
    //TODO write your implementation code here:
    int valid = validateToken(""+token);
    try {
        if (valid > 0) {
          Statement stmt = conn.createStatement();
          
          String sql = "UPDATE product SET product_name=? ,description=? ,price=? WHERE id=?;";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setString(1, product_name);
          dbStatement.setString(2, description);
          dbStatement.setInt(3, price);
          dbStatement.setInt(4, id);
          dbStatement.executeUpdate();
        }
    } catch (Exception e) {
      
    }
    
    return valid;
  }
 
  /**
   * Web service operation
   * @param n
   * @param token
   */
  @WebMethod(operationName = "getPurchasesList")
  @WebResult(name="Purchase")
  public ArrayList<Purchase> getPurchasesList(@WebParam(name = "n") int n, @WebParam(name = "token") int token) {
    //TODO write your implementation code here:
    ArrayList<Purchase> purchases = new ArrayList<>();
    Boolean valid = validateToken(""+token) > 0;
    try {
        if (valid) {
          Statement stmt = conn.createStatement();
          String sql = "SELECT * FROM purchase WHERE buyer_id = ? ORDER BY purchase_time DESC";

          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1,token);
          ResultSet rs = dbStatement.executeQuery();

          int i = 0;
          while (i < n && rs.next()) {
              purchases.add(new Purchase(rs.getInt("id"), rs.getInt("buyer_id"), rs.getString("buyer_username"), rs.getInt("seller_id"), rs.getString("seller_username"), rs.getString("product_name"), rs.getString("photo"), rs.getInt("price"), rs.getInt("quantity"), rs.getString("full_address"), rs.getString("postal_code"), rs.getString("phone_number"), rs.getString("card_number"), rs.getString("card_verification"), rs.getTimestamp("purchase_time"), valid));
          }
        } else {
              purchases.add(new Purchase(validateToken(""+token), 0, "", 0, "", "", "", 0, 0, "", "", "", "", "", new Timestamp(0), false));
        }
    } catch (Exception e) {
        
    }
    return purchases;
  }
  
  /**
   * Web service operation
   * @param n
   * @param token
   */
  @WebMethod(operationName = "getSalesList")
  @WebResult(name="Purchase")
  public ArrayList<Purchase> getSalesList(@WebParam(name = "n") int n, @WebParam(name = "token") int token) {
    //TODO write your implementation code here:
    
    ArrayList<Purchase> sales = new ArrayList<>();
    Boolean valid = validateToken(""+token) > 0;
    try {
        if (valid) {
          Statement stmt = conn.createStatement();
          String sql = "SELECT * FROM purchase WHERE seller_id = ? ORDER BY purchase_time DESC";

          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1,token);
          ResultSet rs = dbStatement.executeQuery();

          int i = 0;
          while (i < n && rs.next()) {
              sales.add(new Purchase(rs.getInt("id"), rs.getInt("buyer_id"), rs.getString("buyer_username"), rs.getInt("seller_id"), rs.getString("seller_username"), rs.getString("product_name"), rs.getString("photo"), rs.getInt("price"), rs.getInt("quantity"), rs.getString("full_address"), rs.getString("postal_code"), rs.getString("phone_number"), rs.getString("card_number"), rs.getString("card_verification"), rs.getTimestamp("purchase_time"), valid));
          }
        } else {
              sales.add(new Purchase(validateToken(""+token), 0, "", 0, "", "", "", 0, 0, "", "", "", "", "", new Timestamp(0), false));
        }
    } catch (Exception e) {
        
    }
    return sales;
  }
  
}
