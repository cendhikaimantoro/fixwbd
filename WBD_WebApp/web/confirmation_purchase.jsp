<%-- 
    Document   : confirmation_purchase
    Created on : Nov 13, 2016, 1:53:14 AM
    Author     : ASUS-A451LB
--%>

<%@page import="MarketplaceWS.*"%>
<%  
    String token = request.getParameter("token");
    String username = request.getParameter("username");
    String productid = request.getParameter("productid");
    String redirect = "";
      if (token == null || username == null || productid == null) {
            redirect = "<meta http-equiv=\"refresh\" content=\"0; url=login.jsp?error=loginfirst\" />";
      } else {
        MarketplaceWS service = new MarketplaceWS_Service().getMarketplaceWSPort();
        int err = service.validateToken(""+token);
        if (err == -1) {
          redirect = "<meta http-equiv=\"refresh\" content=\"0; url=login.jsp?error=expired\" />";
        } else if (err == -2) {
          redirect = "<meta http-equiv=\"refresh\" content=\"0; url=login.jsp?error=invalid\" />";
        } else if (err == -3) {
          redirect = "<meta http-equiv=\"refresh\" content=\"0; url=login.jsp?error=notloggedin\" />";
        }
      }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Confirmation Purchase</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <%=redirect%>
    </head>
    <body class="confirmation_purchase">
        <center><div class="title">Sale<span class="bluetext">Project</span></div></center><br><br>';
        <div class="right">Hi, <%=request.getParameter("username")%>!</div>
        <br>
        <form action="http://localhost:8082/WBD_IdentityService/logout_servlet" method="POST" class=\"logout\">;
            <input type="hidden" name="URLvalid" value="http://localhost:8080/WBD_WebApp/login.jsp">
            <input type="hidden" name="token" value=<%="\""+request.getParameter("token")+"\""%>>
            <input type="submit" value="logout">
        </form>
        <br><br>

        <ul class="navibar">
            <li class="catalog"><a href=<%="\"catalog.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\""%>>Catalog</a></li>
            <li class="your_products"><a href=<%="\"your_products.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\""%>>Your Products</a></li>
            <li class="add_products"><a href=<%="\"add_product.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\""%>>Add Product</a></li>
            <li class="sales"><a href=<%="\"sales.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\""%>>Sales</a></li>
            <li class="purchases"><a href=<%="\"purchases.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\""%>>Purchases</a></li>
        </ul>

        <br><br><br>
        
        <div class="subtitle">Please confirm your purchase</div><hr>
            <form action='purchases.jsp<%="?username="+request.getParameter("username")+"&token="+request.getParameter("token")%>' method="post" name="purchase_form">
                <%
                    String output = "";
                    if (request.getParameter("token") != null) {
                        MarketplaceWS service = new MarketplaceWS_Service().getMarketplaceWSPort();
                        Product p = service.getProduct(Integer.parseInt(request.getParameter("productid")), Integer.parseInt(request.getParameter("token")));

                        output += "<input type=\"hidden\" name=\"product_id\" value="+p.getId()+">";
                        output += "Product     : "+p.getProductName()+"<br>";
                        output += "Price       : IDR "+p.getPrice()+"<br>";
                        output += "Quantity    : <input type=text name=\"qty\" value=1 id=\"qty\" onkeyup=\"updateTotal()\" class=\"qty\"> pcs";
                        output += "<p id=\"qty_warning\" class=\"warning\"></p>";
                        //output += "Total Price : IDR <span id=\"total\">".$str."</span><br><br><br><br>";

                        output += "Delivery to :<br><br>";
                        output += "Consignee<br><input type=\"text\" name=\"consignee\" class=\"text_input\">";
                        output += "<p id=\"consignee_warning\" class=\"warning\"></p><br>";
                        output += "Full Address<br><textarea rows=\"4\" cols=\"50\" name=\"addr\" class=\"text_input\"></textarea>";
                        output += "<p id=\"addr_warning\" class=\"warning\"></p><br>";
                        output += "Postal Code<br><input type=\"text\" name=\"postalcode\" class=\"text_input\">";
                        output += "<p id=\"postal_warning\" class=\"warning\"></p><br>";
                        output += "Phone Number<br><input type=\"text\" name=\"phone\" class=\"text_input\">";
                        output += "<p id=\"phone_warning\" class=\"warning\"></p><br>";
                        output += "12 Digits Credit Card Number<br><input type=\"text\" name=\"creditcard\" class=\"text_input\">";
                        output += "<p id=\"card_warning\" class=\"warning\"></p><br>";
                        output += "3 Digit Card Verification Value<br><input type=\"text\" name=\"creditverification\" class=\"text_input\">";
                        output += "<p id=\"verification_warning\" class=\"warning\"></p>";
                        output += "<br><button type=\"button\" onclick=\"window.location.href='catalog.php?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"'\" class=\"button\">CANCEL</button>";
                        output += "<input type=\"submit\" value=\"CONFIRM\" class=\"button\">";
                    }
                %>
                <%=output%>
                <br><br>
            </form>
    </body>
</html>
