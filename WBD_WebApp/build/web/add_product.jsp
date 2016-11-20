<%@page import="MarketplaceWS.*"%>
<%-- 
    Document   : add_product
    Created on : Nov 13, 2016, 1:56:35 AM
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
	<title>Add Product</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
        <%=redirect%>
    </head>
    <body class="add_product">
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
        <div class="subtitle">Please add your product here</div><hr>
            <form action='your_products.jsp<%="?username="+request.getParameter("username")+"&token="+request.getParameter("token")%>' method="post" name="add_product" >
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="username" value=<%=request.getParameter("username")%>>
                <input type="hidden" name="token" value=<%=request.getParameter("token")%>>
                Name <br>
                    <input type="text" name="product_name" class="text_input"> <br>
                Description (max 200 chars) <br>
                    <textarea name="product_description" class="text_input__long"></textarea> <br>
                Price <br>
                    <input type="text" name="product_price" class="text_input"> <br>
                Photo <br>
                            <input type="file" name="product_photo" class="file_input"> <br>
                    <input type="submit" value="ADD" class="button">
            </form>
        
    </body>
</html>