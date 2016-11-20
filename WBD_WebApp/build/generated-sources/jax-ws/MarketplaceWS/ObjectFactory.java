
package MarketplaceWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the MarketplaceWS package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Product_QNAME = new QName("http://Services/", "Product");
    private final static QName _AddProductResponse_QNAME = new QName("http://Services/", "addProductResponse");
    private final static QName _DateTime_QNAME = new QName("http://Services/", "DateTime");
    private final static QName _GetYourProducts_QNAME = new QName("http://Services/", "getYourProducts");
    private final static QName _EditProduct_QNAME = new QName("http://Services/", "editProduct");
    private final static QName _ValidateTokenResponse_QNAME = new QName("http://Services/", "validateTokenResponse");
    private final static QName _GetProductResponse_QNAME = new QName("http://Services/", "getProductResponse");
    private final static QName _SetLikeResponse_QNAME = new QName("http://Services/", "setLikeResponse");
    private final static QName _AddProduct_QNAME = new QName("http://Services/", "addProduct");
    private final static QName _GetYourProductsResponse_QNAME = new QName("http://Services/", "getYourProductsResponse");
    private final static QName _GetCatalogSearchResponse_QNAME = new QName("http://Services/", "getCatalogSearchResponse");
    private final static QName _DeleteProduct_QNAME = new QName("http://Services/", "deleteProduct");
    private final static QName _ValidateToken_QNAME = new QName("http://Services/", "validateToken");
    private final static QName _GetPurchasesListResponse_QNAME = new QName("http://Services/", "getPurchasesListResponse");
    private final static QName _AddPurchase_QNAME = new QName("http://Services/", "addPurchase");
    private final static QName _SetLike_QNAME = new QName("http://Services/", "setLike");
    private final static QName _GetCatalogList_QNAME = new QName("http://Services/", "getCatalogList");
    private final static QName _GetProduct_QNAME = new QName("http://Services/", "getProduct");
    private final static QName _GetCatalogListResponse_QNAME = new QName("http://Services/", "getCatalogListResponse");
    private final static QName _GetSalesList_QNAME = new QName("http://Services/", "getSalesList");
    private final static QName _GetSalesListResponse_QNAME = new QName("http://Services/", "getSalesListResponse");
    private final static QName _EditProductResponse_QNAME = new QName("http://Services/", "editProductResponse");
    private final static QName _GetPurchasesList_QNAME = new QName("http://Services/", "getPurchasesList");
    private final static QName _GetCatalogSearch_QNAME = new QName("http://Services/", "getCatalogSearch");
    private final static QName _Hello_QNAME = new QName("http://Services/", "hello");
    private final static QName _DeleteProductResponse_QNAME = new QName("http://Services/", "deleteProductResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://Services/", "helloResponse");
    private final static QName _AddPurchaseResponse_QNAME = new QName("http://Services/", "addPurchaseResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: MarketplaceWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateTokenResponse }
     * 
     */
    public ValidateTokenResponse createValidateTokenResponse() {
        return new ValidateTokenResponse();
    }

    /**
     * Create an instance of {@link GetProductResponse }
     * 
     */
    public GetProductResponse createGetProductResponse() {
        return new GetProductResponse();
    }

    /**
     * Create an instance of {@link SetLikeResponse }
     * 
     */
    public SetLikeResponse createSetLikeResponse() {
        return new SetLikeResponse();
    }

    /**
     * Create an instance of {@link AddProduct }
     * 
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link DateTime }
     * 
     */
    public DateTime createDateTime() {
        return new DateTime();
    }

    /**
     * Create an instance of {@link GetYourProducts }
     * 
     */
    public GetYourProducts createGetYourProducts() {
        return new GetYourProducts();
    }

    /**
     * Create an instance of {@link EditProduct }
     * 
     */
    public EditProduct createEditProduct() {
        return new EditProduct();
    }

    /**
     * Create an instance of {@link GetPurchasesListResponse }
     * 
     */
    public GetPurchasesListResponse createGetPurchasesListResponse() {
        return new GetPurchasesListResponse();
    }

    /**
     * Create an instance of {@link AddPurchase }
     * 
     */
    public AddPurchase createAddPurchase() {
        return new AddPurchase();
    }

    /**
     * Create an instance of {@link SetLike }
     * 
     */
    public SetLike createSetLike() {
        return new SetLike();
    }

    /**
     * Create an instance of {@link GetYourProductsResponse }
     * 
     */
    public GetYourProductsResponse createGetYourProductsResponse() {
        return new GetYourProductsResponse();
    }

    /**
     * Create an instance of {@link GetCatalogSearchResponse }
     * 
     */
    public GetCatalogSearchResponse createGetCatalogSearchResponse() {
        return new GetCatalogSearchResponse();
    }

    /**
     * Create an instance of {@link DeleteProduct }
     * 
     */
    public DeleteProduct createDeleteProduct() {
        return new DeleteProduct();
    }

    /**
     * Create an instance of {@link ValidateToken }
     * 
     */
    public ValidateToken createValidateToken() {
        return new ValidateToken();
    }

    /**
     * Create an instance of {@link GetProduct }
     * 
     */
    public GetProduct createGetProduct() {
        return new GetProduct();
    }

    /**
     * Create an instance of {@link GetCatalogListResponse }
     * 
     */
    public GetCatalogListResponse createGetCatalogListResponse() {
        return new GetCatalogListResponse();
    }

    /**
     * Create an instance of {@link GetSalesList }
     * 
     */
    public GetSalesList createGetSalesList() {
        return new GetSalesList();
    }

    /**
     * Create an instance of {@link GetSalesListResponse }
     * 
     */
    public GetSalesListResponse createGetSalesListResponse() {
        return new GetSalesListResponse();
    }

    /**
     * Create an instance of {@link EditProductResponse }
     * 
     */
    public EditProductResponse createEditProductResponse() {
        return new EditProductResponse();
    }

    /**
     * Create an instance of {@link GetPurchasesList }
     * 
     */
    public GetPurchasesList createGetPurchasesList() {
        return new GetPurchasesList();
    }

    /**
     * Create an instance of {@link GetCatalogList }
     * 
     */
    public GetCatalogList createGetCatalogList() {
        return new GetCatalogList();
    }

    /**
     * Create an instance of {@link DeleteProductResponse }
     * 
     */
    public DeleteProductResponse createDeleteProductResponse() {
        return new DeleteProductResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link AddPurchaseResponse }
     * 
     */
    public AddPurchaseResponse createAddPurchaseResponse() {
        return new AddPurchaseResponse();
    }

    /**
     * Create an instance of {@link GetCatalogSearch }
     * 
     */
    public GetCatalogSearch createGetCatalogSearch() {
        return new GetCatalogSearch();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link Purchase }
     * 
     */
    public Purchase createPurchase() {
        return new Purchase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "Product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "addProductResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "DateTime")
    public JAXBElement<DateTime> createDateTime(DateTime value) {
        return new JAXBElement<DateTime>(_DateTime_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetYourProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getYourProducts")
    public JAXBElement<GetYourProducts> createGetYourProducts(GetYourProducts value) {
        return new JAXBElement<GetYourProducts>(_GetYourProducts_QNAME, GetYourProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "editProduct")
    public JAXBElement<EditProduct> createEditProduct(EditProduct value) {
        return new JAXBElement<EditProduct>(_EditProduct_QNAME, EditProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "validateTokenResponse")
    public JAXBElement<ValidateTokenResponse> createValidateTokenResponse(ValidateTokenResponse value) {
        return new JAXBElement<ValidateTokenResponse>(_ValidateTokenResponse_QNAME, ValidateTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getProductResponse")
    public JAXBElement<GetProductResponse> createGetProductResponse(GetProductResponse value) {
        return new JAXBElement<GetProductResponse>(_GetProductResponse_QNAME, GetProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLikeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "setLikeResponse")
    public JAXBElement<SetLikeResponse> createSetLikeResponse(SetLikeResponse value) {
        return new JAXBElement<SetLikeResponse>(_SetLikeResponse_QNAME, SetLikeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "addProduct")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetYourProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getYourProductsResponse")
    public JAXBElement<GetYourProductsResponse> createGetYourProductsResponse(GetYourProductsResponse value) {
        return new JAXBElement<GetYourProductsResponse>(_GetYourProductsResponse_QNAME, GetYourProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogSearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getCatalogSearchResponse")
    public JAXBElement<GetCatalogSearchResponse> createGetCatalogSearchResponse(GetCatalogSearchResponse value) {
        return new JAXBElement<GetCatalogSearchResponse>(_GetCatalogSearchResponse_QNAME, GetCatalogSearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "deleteProduct")
    public JAXBElement<DeleteProduct> createDeleteProduct(DeleteProduct value) {
        return new JAXBElement<DeleteProduct>(_DeleteProduct_QNAME, DeleteProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "validateToken")
    public JAXBElement<ValidateToken> createValidateToken(ValidateToken value) {
        return new JAXBElement<ValidateToken>(_ValidateToken_QNAME, ValidateToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchasesListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getPurchasesListResponse")
    public JAXBElement<GetPurchasesListResponse> createGetPurchasesListResponse(GetPurchasesListResponse value) {
        return new JAXBElement<GetPurchasesListResponse>(_GetPurchasesListResponse_QNAME, GetPurchasesListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPurchase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "addPurchase")
    public JAXBElement<AddPurchase> createAddPurchase(AddPurchase value) {
        return new JAXBElement<AddPurchase>(_AddPurchase_QNAME, AddPurchase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetLike }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "setLike")
    public JAXBElement<SetLike> createSetLike(SetLike value) {
        return new JAXBElement<SetLike>(_SetLike_QNAME, SetLike.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getCatalogList")
    public JAXBElement<GetCatalogList> createGetCatalogList(GetCatalogList value) {
        return new JAXBElement<GetCatalogList>(_GetCatalogList_QNAME, GetCatalogList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getProduct")
    public JAXBElement<GetProduct> createGetProduct(GetProduct value) {
        return new JAXBElement<GetProduct>(_GetProduct_QNAME, GetProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getCatalogListResponse")
    public JAXBElement<GetCatalogListResponse> createGetCatalogListResponse(GetCatalogListResponse value) {
        return new JAXBElement<GetCatalogListResponse>(_GetCatalogListResponse_QNAME, GetCatalogListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSalesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getSalesList")
    public JAXBElement<GetSalesList> createGetSalesList(GetSalesList value) {
        return new JAXBElement<GetSalesList>(_GetSalesList_QNAME, GetSalesList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSalesListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getSalesListResponse")
    public JAXBElement<GetSalesListResponse> createGetSalesListResponse(GetSalesListResponse value) {
        return new JAXBElement<GetSalesListResponse>(_GetSalesListResponse_QNAME, GetSalesListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "editProductResponse")
    public JAXBElement<EditProductResponse> createEditProductResponse(EditProductResponse value) {
        return new JAXBElement<EditProductResponse>(_EditProductResponse_QNAME, EditProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchasesList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getPurchasesList")
    public JAXBElement<GetPurchasesList> createGetPurchasesList(GetPurchasesList value) {
        return new JAXBElement<GetPurchasesList>(_GetPurchasesList_QNAME, GetPurchasesList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogSearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "getCatalogSearch")
    public JAXBElement<GetCatalogSearch> createGetCatalogSearch(GetCatalogSearch value) {
        return new JAXBElement<GetCatalogSearch>(_GetCatalogSearch_QNAME, GetCatalogSearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "deleteProductResponse")
    public JAXBElement<DeleteProductResponse> createDeleteProductResponse(DeleteProductResponse value) {
        return new JAXBElement<DeleteProductResponse>(_DeleteProductResponse_QNAME, DeleteProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPurchaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Services/", name = "addPurchaseResponse")
    public JAXBElement<AddPurchaseResponse> createAddPurchaseResponse(AddPurchaseResponse value) {
        return new JAXBElement<AddPurchaseResponse>(_AddPurchaseResponse_QNAME, AddPurchaseResponse.class, null, value);
    }

}
