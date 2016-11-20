<%@page import="MarketplaceWS.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : your_products
    Created on : Nov 13, 2016, 1:55:02 AM
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
        <title>Your Products</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <%=redirect%>
    </head>
    <body class="your_products">
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
        
        <div class="subtitle">What are you going to sell today?</div><hr>
		
        <%
            String web = "";
            MarketplaceWS service = new MarketplaceWS_Service().getMarketplaceWSPort();
            
            if(request.getParameter("action") != null) {
              if (request.getParameter("action").equals("add")) {
                 service.addProduct(request.getParameter("product_name"), request.getParameter("username"), Integer.parseInt(request.getParameter("product_price")), request.getParameter("product_photo"), request.getParameter("product_description"), Integer.parseInt(request.getParameter("token")));
              } else if (request.getParameter("action").equals("edit")) {
                 service.editProduct(Integer.parseInt(request.getParameter("product_id")), request.getParameter("product_name"), Integer.parseInt(request.getParameter("product_price")), request.getParameter("product_description"), Integer.parseInt(request.getParameter("token")));
              } else if (request.getParameter("action").equals("delete")){
                service.deleteProduct(Integer.parseInt(request.getParameter("product_id")), Integer.parseInt(request.getParameter("token")));
              }
            }
            
            List<Product> list;
            if (request.getParameter("token") != null) {
                list = service.getYourProducts(100, Integer.parseInt(request.getParameter("token")));

                Product yp;

                for(int i = 0;i<list.size();i++){
                    yp = list.get(i);

                    web += "<br>";
                    web += "<span id='date"+yp.getId()+"' class='date'>"+yp.getAddTime().getWeekday()+"</span><br>";
                    web += "<span id='time"+yp.getId()+"'>at "+yp.getAddTime().getHour()+"."+yp.getAddTime().getMinute()+"</span>";
                    web += "<hr>";
                    web += "<span class='col1'>";
                    web += "<img src='"+yp.getPhoto()+"' height=150px width=150px id='img"+yp.getId()+"' class='img'><br>";
                    web += "</span>";
                    web += "<span class='col2'>";
                    web += "<span id='productname"+yp.getId()+"' class='productname'>"+yp.getProductName()+"</span><br>";
                    web += "<span id='price"+yp.getId()+"' class='price'>IDR "+yp.getPrice()+"</span><br>";
                    web += "<span id='desc"+yp.getId()+"' class='desc'>"+yp.getDescription()+"</span><br>";
                    web += "</span>";
                    web += "<span class='col3'>";
                    web += "<br><span id='nlikes"+yp.getId()+"' class='nlikes'>"+yp.getNlike()+"</span> likes<br><br>";
                    web += "<span id='npurchases"+yp.getId()+"' class='npurchases'>"+yp.getAmountPurchased()+" purchases</span><br><br><br>";
                    web += "<form action=edit_product.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+" method='POST'>";
                    web += "<input type='hidden' name='product_id' value="+yp.getId()+">";
                    web += "<input type='submit' name='submit' value=EDIT>";
                    web += "</form>";
                    web += "<form action=your_products.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+" method='POST'>";
                    web += "<input type='hidden' name='action' value='delete'>";
                    web += "<input type='hidden' name='product_id' value="+yp.getId()+">";
                    web += "<input type='submit' name='submit' value=DELETE>";
                    web += "</form>";

                    web += "</span>";
                    web += "<hr><br>";	
                }
            }
        %>
        <%--
        ga ada delete product.jsp
        --%>
        <%=web%>
        <script src="../js/formvalidation.js"></script>
    </body>
</html>