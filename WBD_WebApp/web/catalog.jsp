<%@page import="MarketplaceWS.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%  
    String token = null;
    try {
      token = request.getParameter("token");
    } catch (Exception e) {
      
    }
    String username = null;//request.getParameter("username");
    try {
      username = request.getParameter("username");
    } catch (Exception e) {
      
    }
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
                
<!DOCTYPE html>
<html>
	<head>
		<title>Catalog</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
                <%=redirect%>
	</head>
	<body class="catalog">
		
            
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
            
            
		<div class="subtitle">What are you going to buy today?</div><hr>
		
		<form action="catalog.jsp" method="get">
                    <input type="hidden" name="username" value=<%=request.getParameter("username")%>>
                    <input type="hidden" name="token" value=<%=request.getParameter("token")%>>
                    <input type="text" placeholder="Search catalog..." name="searchkey" class="search_bar">
                    <input type="submit" value="GO" class="searchbutton"><br>
                    Search by :
                    <input type="radio" name="searchopt" value="product" checked="">Product
                    <input type="radio" name="searchopt" value="store">Store<br>
		</form><br><br>
                  
                
		<%
                        String searchopt = request.getParameter("searchopt");
                        String searchkey = request.getParameter("searchkey");
                        MarketplaceWS service = new MarketplaceWS_Service().getMarketplaceWSPort();
                        List<Product> list;
                        String searchinfo = "";
                        String output = "";
                        int idxErr = 0;
                        if (request.getParameter("token") != null) {
                        if(request.getParameter("like") != null) {
                          idxErr = service.setLike(Integer.parseInt(request.getParameter("like")), Integer.parseInt(request.getParameter("token")));
                        }
			if(searchopt!=null) {
                                list = service.getCatalogSearch(searchopt, searchkey, 100, Integer.parseInt(request.getParameter("token")));
                                searchinfo = "&searchkey="+request.getParameter("searchkey")+"&searchopt="+request.getParameter("searchopt");
			} else {
				list = service.getCatalogList(100, Integer.parseInt(request.getParameter("token")));
			}
                        
                        String isLiked, strLiked;
                        //System.out.println(list.get(0).getProductName());
                        
                            Product p;
                            for (int i = 0; i < list.size(); i++) {
                                p = list.get(i);

                                if (p.isLiked()) {
                                    isLiked = "liked";
                                    strLiked = "UNLIKE";
                                } else {
                                    isLiked = "unliked";
                                    strLiked = "LIKE";
                                }
                                output += "<br>";
                                output += "<span id='seller" + p.getId() + "' class='seller'>" + p.getSellerUsername() + "</span><br>";
                                output += "added this on <span id='datetime" + p.getId() + "' class='datecatalog'>"+ p.getAddTime().getWeekday() +", at "+ p.getAddTime().getHour() +"."+p.getAddTime().getMinute()+"</span>";
                                output += "<hr>";
                                output += "<div class='col1'>";
                                output += "<img src='"+p.getPhoto()+"' height=150px width=150px id='img"+p.getId()+"' class='img'>";
                                output += "</div>";
                                output += "<div class='col2'>";
                                output += "<span id='productname"+p.getId()+"' class='productname'>"+p.getProductName()+"</span><br>";
                                output += "<span id='price"+p.getId()+"' class='price'>IDR "+p.getPrice()+"</span><br>";
                                output += "<span id='desc"+p.getId()+"' class='desc'>"+p.getDescription()+"</span><br>";
                                output += "</div>";
                                output += "<div class='col3'>";
                                output += "<br>";
                                output += "<span id='nlikes"+p.getId()+"' class='nlikes'>"+p.getNlike()+"</span> likes<br><br>";
                                output += "<span id='npurchases"+p.getId()+"' class='npurchases'>"+p.getAmountPurchased()+" purchases</span><br><br>";
                                output += "<form action=catalog.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+searchinfo+" method='POST'>";
                                output += "<input type='hidden' name='like' value="+p.getId()+">";
                                output += "<input type='submit' name='submit' value="+strLiked+">";
                                output += "</form>";
                                output += "<button type='button' onclick='window.location.href=\"confirmation_purchase.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"&productid="+p.getId()+"\"' class='buybutton'>BUY</button><br>";
                                output += "</div>";
                                output += "<hr><br>";
                            }
                        }
		%>
                <%=output%>
		<script src="../js/like.js"></script>
	</body>
</html>