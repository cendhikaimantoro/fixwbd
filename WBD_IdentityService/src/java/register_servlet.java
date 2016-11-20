/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS-A451LB
 */
@WebServlet(urlPatterns = {"/register_servlet"})
public class register_servlet extends HttpServlet {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/identityservice?zeroDateTimeBehavior=convertToNull";
  static final String USER = "root";
  static final String PASS = "";
  
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Connection conn = null;
    Statement stmt = null;
    try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      String username = request.getParameter("Username");
      String password = request.getParameter("Password");
      String confirmpassword = request.getParameter("Confirm_Password");
      String fullname = request.getParameter("Full_Name");
      String fulladdress = request.getParameter("Full_Address");
      String postalcode = request.getParameter("Postal_Code");
      String phonenumber = request.getParameter("Phone_Number");
      String email = request.getParameter("Email");
      
      String sql = null;
      String id = null;
      ResultSet rs;
      PreparedStatement pst;
      
      if (!password.equals(confirmpassword)) {
        response.sendRedirect(request.getParameter("URLinvalid")+"?error=password");
      } else {
        sql = "SELECT * FROM user WHERE email=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,email);
        rs = pst.executeQuery();
        while(rs.next()) {
          id=rs.getString("id");
        }
        if (id!=null) {
          response.sendRedirect(request.getParameter("URLinvalid")+"?error=email");
        } else {
          sql = "SELECT * FROM user WHERE username=?";
          pst = conn.prepareStatement(sql);
          pst.setString(1,username);
          rs = pst.executeQuery();
          while(rs.next()) {
            id=rs.getString("id");
          }
          if (id!=null) {
            response.sendRedirect(request.getParameter("URLinvalid")+"?error=username");
          } else {
            sql = "INSERT INTO user (id, username, password, full_name, full_address, postal_code, phone_number, email, session_exp) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, DATE_ADD(NOW(), INTERVAL 2 HOUR))";
            pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setString(3,fullname);
            pst.setString(4,fulladdress);
            pst.setString(5,postalcode);
            pst.setString(6,phonenumber);
            pst.setString(7,email);
            pst.executeUpdate();
            
            sql = "SELECT * FROM user WHERE username=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            rs = pst.executeQuery();
            while(rs.next()) {
              id=rs.getString("id");
            }
            
            sql = "UPDATE user SET session_exp = DATE_ADD(NOW(), INTERVAL 2 HOUR) WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,id);
            pst.executeUpdate();
            
            response.sendRedirect(request.getParameter("URLvalid")+"?username="+username+"&token="+id);
          }
        }
      } 
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
