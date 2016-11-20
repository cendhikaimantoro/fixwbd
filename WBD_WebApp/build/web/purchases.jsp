<%@page import="MarketplaceWS.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : purchases
    Created on : Nov 13, 2016, 1:56:47 AM
    Author     : ASUS-A451LB
--%>
<%
    String token = request.getParameter("token");
    String username = request.getParameter("username");
    String redirect = "";
      if (token == null || username == null) {
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
        <title>Purchases</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">    </head>
        <%=redirect%>
    <body>
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
        
        <div class="subtitle">Here are your purchases</div><hr>
	<%
            MarketplaceWS service = new MarketplaceWS_Service().getMarketplaceWSPort();
            if (request.getParameter("product_id") != null) {
              service.addPurchase(Integer.parseInt(request.getParameter("product_id")), request.getParameter("username"), Integer.parseInt(request.getParameter("qty")), request.getParameter("consignee"), request.getParameter("addr"), request.getParameter("postalcode"), request.getParameter("phone"), request.getParameter("creditcard"), request.getParameter("creditverification"), Integer.parseInt(request.getParameter("token")));
            }
            
            String web = "";
            if (request.getParameter("token") != null) { 
                List<Purchase> list;
                list = service.getPurchasesList(100,Integer.parseInt(request.getParameter("token")));
                Purchase p;
                for(int i=0; i< list.size();i++){
                    p = list.get(i);
                    web += "<br>";
                    web += "<span id='date"+p.getId()+"' class='date'>"+p.getPurchaseTime().getWeekday()+"</span><br>";
                    web += "<span id='time"+p.getId()+"'>at "+p.getPurchaseTime().getHour()+"."+p.getPurchaseTime().getMinute()+"</span>";
                    web += "<hr>";
                    web += "<div class='col1'>";
                    web += "<img src='"+p.getPhoto()+"' height=150px width=150px id='img"+p.getId()+"' class='img'><br>";
                    web += "</div>";
                    web += "<div class='col2b'>";
                    web += "<span id='productname"+p.getId()+"' class='productname'>"+p.getProductName()+"</span><br>";
                    web += "<span id='totalprice"+p.getId()+"' class='price'>IDR "+p.getPrice()*p.getQuantity()+"</span><br>";
                    web += "<span id='qty"+p.getId()+"' class='quantity'>"+p.getQuantity()+" pcs</span><br>";
                    web += "<span id='price"+p.getId()+"' class='price'>@IDR "+p.getPrice()+"</span><br><br><br>";
                    web += "<p>bought from <span id='seller"+p.getId()+"' class='seller'>"+p.getSellerUsername()+"</span></p>";
                    web += "</div>";
                    web += "<div class='col3b'>";
                    web += "Delivery to <span id='consignee"+p.getId()+"' class='consignee'>"+p.getConsignee()+"</span><br>";
                    web += "<span id='addr"+p.getId()+"' class='addr'>"+p.getFullAddress()+"</span><br>";
                    web += "<span id='postal"+p.getId()+"' class='postal'>"+p.getPostalCode()+"</span><br>";
                    web += "<span id='phone"+p.getId()+"' class='phone'>"+p.getPhoneNumber()+"</span><br>";
                    web += "</div>";
                    web += "<br><br><br><br>";
                }
            }
        %>
        <%=web%>
    </body>
</html>