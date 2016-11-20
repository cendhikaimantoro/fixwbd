
package MarketplaceWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="seller_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="seller_username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="product_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="add_time" type="{http://Services/}dateTime" minOccurs="0"/>
 *         &lt;element name="photo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amount_purchased" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nlike" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="liked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="valid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
    "id",
    "sellerId",
    "sellerUsername",
    "productName",
    "price",
    "addTime",
    "photo",
    "description",
    "amountPurchased",
    "nlike",
    "liked",
    "valid"
})
public class Product {

    protected int id;
    @XmlElement(name = "seller_id")
    protected int sellerId;
    @XmlElement(name = "seller_username")
    protected String sellerUsername;
    @XmlElement(name = "product_name")
    protected String productName;
    protected int price;
    @XmlElement(name = "add_time")
    protected DateTime addTime;
    protected String photo;
    protected String description;
    @XmlElement(name = "amount_purchased")
    protected int amountPurchased;
    protected int nlike;
    protected Boolean liked;
    protected boolean valid;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the sellerId property.
     * 
     */
    public int getSellerId() {
        return sellerId;
    }

    /**
     * Sets the value of the sellerId property.
     * 
     */
    public void setSellerId(int value) {
        this.sellerId = value;
    }

    /**
     * Gets the value of the sellerUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerUsername() {
        return sellerUsername;
    }

    /**
     * Sets the value of the sellerUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerUsername(String value) {
        this.sellerUsername = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the addTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getAddTime() {
        return addTime;
    }

    /**
     * Sets the value of the addTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setAddTime(DateTime value) {
        this.addTime = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the amountPurchased property.
     * 
     */
    public int getAmountPurchased() {
        return amountPurchased;
    }

    /**
     * Sets the value of the amountPurchased property.
     * 
     */
    public void setAmountPurchased(int value) {
        this.amountPurchased = value;
    }

    /**
     * Gets the value of the nlike property.
     * 
     */
    public int getNlike() {
        return nlike;
    }

    /**
     * Sets the value of the nlike property.
     * 
     */
    public void setNlike(int value) {
        this.nlike = value;
    }

    /**
     * Gets the value of the liked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLiked() {
        return liked;
    }

    /**
     * Sets the value of the liked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLiked(Boolean value) {
        this.liked = value;
    }

    /**
     * Gets the value of the valid property.
     * 
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Sets the value of the valid property.
     * 
     */
    public void setValid(boolean value) {
        this.valid = value;
    }

}
