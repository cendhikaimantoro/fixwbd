/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author ASUS-A451LB
 */
public class Purchase {
  @XmlElement(name="id", required=false)
  public int id;
  @XmlElement(name="buyer_id", required=false)
  public int buyer_id;
  @XmlElement(name="buyer_username", required=false)
  public String buyer_username;
  @XmlElement(name="seller_id", required=false)
  public int seller_id;
  @XmlElement(name="seller_username", required=false)
  public String seller_username;
  @XmlElement(name="product_name", required=false)
  public String product_name;
  @XmlElement(name="photo", required=false)
  public String photo;
  @XmlElement(name="price", required=false)
  public int price;
  @XmlElement(name="quantity", required=false)
  public int quantity;
  @XmlElement(name="consignee", required=false)
  public String consignee;
  @XmlElement(name="full_address", required=false)
  public String full_address;
  @XmlElement(name="postal_code", required=false)
  public String postal_code;
  @XmlElement(name="phone_number", required=false)
  public String phone_number;
  @XmlElement(name="card_number", required=false)
  public String card_number;
  @XmlElement(name="card_verification", required=false)
  public String card_verification;
  @XmlElement(name="purchase_time", required=false)
  public DateTime purchase_time;
  @XmlElement(name="valid", required=true)
  public Boolean valid;

    public Purchase() {
        this.id = 0;
        this.buyer_id = 0;
        this.buyer_username = "";
        this.seller_id = 0;
        this.seller_username = "";
        this.product_name = "";
        this.photo = "";
        this.price = 0;
        this.quantity = 0;
        this.consignee = "";
        this.full_address = "";
        this.postal_code = "";
        this.phone_number = "";
        this.card_number = "";
        this.card_verification = "";
        this.purchase_time = null;
        this.valid = false;
    }
  
    public Purchase(int id, int buyer_id, String buyer_username, int seller_id, String seller_username, String product_name, String photo, int price, int quantity, String full_address, String postal_code, String phone_number, String card_number, String card_verification, Timestamp purchase_time, Boolean valid) {
        this.id = id;
        this.buyer_id = buyer_id;
        this.buyer_username = buyer_username;
        this.seller_id = seller_id;
        this.seller_username = seller_username;
        this.product_name = product_name;
        this.photo = photo;
        this.price = price;
        this.quantity = quantity;
        this.consignee = consignee;
        this.full_address = full_address;
        this.postal_code = postal_code;
        this.phone_number = phone_number;
        this.card_number = card_number;
        this.card_verification = card_verification;
        this.purchase_time = new DateTime(purchase_time);
        this.valid = valid;
    }
}
