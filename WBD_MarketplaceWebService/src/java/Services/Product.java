/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.sql.Timestamp;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
/**
 *
 * @author ASUS-A451LB
 */
@XmlRootElement(name = "Product")
public class Product {
  @XmlElement(name="id", required=false)
  public int id;
  @XmlElement(name="seller_id", required=false)
  public int seller_id;
  @XmlElement(name="seller_username", required=false)
  public String seller_username;
  @XmlElement(name="product_name", required=false)
  public String product_name;
  @XmlElement(name="price", required=false)
  public int price;
  @XmlElement(name="add_time", required=false)
  public DateTime add_time;
  @XmlElement(name="photo", required=false)
  public String photo;
  @XmlElement(name="description", required=false)
  public String description;
  @XmlElement(name="amount_purchased", required=false)
  public int amount_purchased;
  @XmlElement(name="nlike", required=false)
  public int nlike;
  @XmlElement(name="liked", required=false)
  public Boolean liked;
  @XmlElement(name="valid", required=true)
  public Boolean valid = true;
  
  public Product() {
    this.id = 0;
    this.seller_id = 0;
    this.seller_username = "";
    this.product_name = "";
    this.price = 0;
    this.add_time = new DateTime();
    this.photo = "";
    this.description = "";
    this.amount_purchased = 0;
    this.nlike = 0;
    this.liked = false;
    this.valid = false;
  }

  public Product(int id , int seller_id, String seller_username, String product_name, int price, Timestamp add_time, String photo, String description, int amount_purchased, int nlike, Boolean liked, Boolean valid) {
    this.id = id;
    this.seller_id = seller_id;
    this.seller_username = seller_username;
    this.product_name = product_name;
    this.price = price;
    this.add_time = new DateTime(add_time);
    this.photo = photo;
    this.description = description;
    this.amount_purchased = amount_purchased;
    this.nlike = nlike;
    this.liked = liked;
    this.valid = valid;
  }
}
