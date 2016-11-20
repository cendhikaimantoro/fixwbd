<%@page import="MarketplaceWS.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : edit_product
    Created on : Nov 13, 2016, 1:56:24 AM
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
        <title>Edit Product</title>
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
        <div class="subtitle">Please update your product here</div><hr>
        <%--update product diganti apa?--%>
        <form action="your_products.jsp<%="?username="+request.getParameter("username")+"&token="+request.getParameter("token")%>" method="post" name="edit_product">
                
                <%
                    MarketplaceWS service = new MarketplaceWS_Service().getMarketplaceWSPort();
                    String web = "";
                    if (request.getParameter("token") != null) { 
                        Product p = service.getProduct(Integer.parseInt(request.getParameter("product_id")), Integer.parseInt(request.getParameter("token")));
                        

                        web += "<input type='hidden' name='action' value='edit'>";
                        web += "<input type='hidden' name='product_id' value="+p.getId()+">";
                        web += "Name<br><input type='text' name='product_name' class='text_input' value='"+p.getProductName()+"'> <br>";
                        web += "Description (max 200 chars) <br><textarea name='product_description' class='text_input'>"+p.getDescription()+"</textarea> <br>";
                        web += "Price<br><input type='text' name='product_price' class='text_input' value='"+p.getPrice()+"'> <br>";
                        web += "Photo<br><input type='file' name='product_photo' class='file_input' disabled> <br>";
                        web += "<div align='right'>";
                        web += "<a href='your_products.jsp"+"?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"' class='button'>CANCEL</a>";
                        web += "<input type='submit' value='UPDATE' class='button'>";
                        web += "</div>";
                    }
                %>
                <%=web%>
        </form>
    </body>
</html>