<%@page import="MarketplaceWS.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : sales
    Created on : Nov 13, 2016, 1:57:40 AM
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
        <title>Your Sales</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <%=redirect%>
    </head>
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
        
        <div class="subtitle">Here are your sales</div><hr>
        <%
            String web = "";
            if (request.getParameter("token") != null) { 
                MarketplaceWS service = new MarketplaceWS_Service().getMarketplaceWSPort();
                List<Purchase> list;
                list = service.getSalesList(100, Integer.parseInt(request.getParameter("token")));
                Purchase s;
                for(int i=0;i<list.size();i++){
                    s = list.get(i);
                    web += "<br>";
                    web += "<span id='date"+s.getId()+"' class='date'>"+s.getPurchaseTime().getWeekday()+"</span><br>";
                    web += "<span id='time"+s.getId()+"'>at "+s.getPurchaseTime().getHour()+"."+s.getPurchaseTime().getMinute()+"</span>";
                    web += "<hr>";
                    web += "<div class='col1'>";
                    web += "<img src='"+s.getPhoto()+"' height=150px width=150px id='img"+s.getId()+"' class='img'><br>";
                    web += "</div>";
                    web += "<div class='col2b'>";
                    web += "<span id='productname"+s.getId()+"' class='productname'>"+s.getProductName()+"</span><br>";
                    web += "<span id='totalprice"+s.getId()+"' class='price'>IDR "+(s.getPrice()*s.getQuantity())+"</span><br>";
                    web += "<span id='qty"+s.getId()+"' class='quantity'>"+s.getQuantity()+" pcs</span><br>";
                    web += "<span id='price"+s.getId()+"' class='price'>@IDR "+s.getPrice()+"</span><br><br><br>";
                    web += "<p>bought by <span id='buyer"+s.getId()+"' class='buyer'>"+s.getBuyerUsername()+"</span></p>";
                    web += "</div>";
                    web += "<div class='col3b'>";
                    web += "Delivery to <span id='consignee"+s.getId()+"' class='consignee'>"+s.getConsignee()+"</span><br>";
                    web += "<span id='addr"+s.getId()+"' class='addr'>"+s.getFullAddress()+"</span><br>";
                    web += "<span id='postal"+s.getId()+"' class='postal'>"+s.getPostalCode()+"</span><br>";
                    web += "<span id='phone"+s.getId()+"' class='phone'>"+s.getPhoneNumber()+"</span><br>";
                    web += "</div>";
                    web += "<br><br><br><br>";
                }
            }
        
        %>
        <%=web%>
        <script src="../js/like.js"></script>
    </body>
</html>