package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import MarketplaceWS.*;
import java.util.List;
import java.util.ArrayList;

public final class catalog_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
  
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
      }

      out.write("\r\n");
      out.write("                \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>Catalog</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style.css\">\r\n");
      out.write("                ");
      out.print(redirect);
      out.write("\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body class=\"catalog\">\r\n");
      out.write("\t\t\r\n");
      out.write("            \r\n");
      out.write("                <center><div class=\"title\">Sale<span class=\"bluetext\">Project</span></div></center><br><br>';\r\n");
      out.write("                <div class=\"right\">Hi, ");
      out.print(request.getParameter("username"));
      out.write("!</div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <form action=\"http://localhost:8082/WBD_IdentityService/logout_servlet\" method=\"POST\" class=\\\"logout\\\">;\r\n");
      out.write("                    <input type=\"hidden\" name=\"URLvalid\" value=\"http://localhost:8080/WBD_WebApp/login.jsp\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"token\" value=");
      out.print("\""+request.getParameter("token")+"\"");
      out.write(">\r\n");
      out.write("                    <input type=\"submit\" value=\"logout\">\r\n");
      out.write("                </form>\r\n");
      out.write("                <br><br>\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"navibar\">\r\n");
      out.write("                    <li class=\"catalog\"><a href=");
      out.print("\"catalog.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Catalog</a></li>\r\n");
      out.write("                    <li class=\"your_products\"><a href=");
      out.print("\"your_products.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Your Products</a></li>\r\n");
      out.write("                    <li class=\"add_products\"><a href=");
      out.print("\"add_product.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Add Product</a></li>\r\n");
      out.write("                    <li class=\"sales\"><a href=");
      out.print("\"sales.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Sales</a></li>\r\n");
      out.write("                    <li class=\"purchases\"><a href=");
      out.print("\"purchases.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Purchases</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("                <br><br><br>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("\t\t<div class=\"subtitle\">What are you going to buy today?</div><hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"catalog.jsp\" method=\"get\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"username\" value=");
      out.print(request.getParameter("username"));
      out.write(">\r\n");
      out.write("                    <input type=\"hidden\" name=\"token\" value=");
      out.print(request.getParameter("token"));
      out.write(">\r\n");
      out.write("                    <input type=\"text\" placeholder=\"Search catalog...\" name=\"searchkey\" class=\"search_bar\">\r\n");
      out.write("                    <input type=\"submit\" value=\"GO\" class=\"searchbutton\"><br>\r\n");
      out.write("                    Search by :\r\n");
      out.write("                    <input type=\"radio\" name=\"searchopt\" value=\"product\" checked=\"\">Product\r\n");
      out.write("                    <input type=\"radio\" name=\"searchopt\" value=\"store\">Store<br>\r\n");
      out.write("\t\t</form><br><br>\r\n");
      out.write("                  \r\n");
      out.write("                \r\n");
      out.write("\t\t");

                        String searchopt = request.getParameter("searchopt");
                        String searchkey = request.getParameter("searchkey");
                        MarketplaceWS service = new MarketplaceWS_Service().getMarketplaceWSPort();
                        List<Product> list;
			if(searchopt!=null) {
                                list = service.getCatalogSearch(searchopt, searchkey, 100, Integer.parseInt(request.getParameter("token")));
			} else {
				list = service.getCatalogList(100, Integer.parseInt(request.getParameter("token")));
			}
                        String output = "";
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
                            output += "<button type='button' id='like"+p.getId()+"' onclick='updateLike("+request.getParameter("token")+", "+p.getId()+")' class='"+isLiked+"'>"+strLiked+"</button>";
                            output += "<button type='button' onclick='window.location.href=\"confirmation_purchase.php?id_active="+request.getParameter("token")+"&productid="+p.getId()+"\"' class='buybutton'>BUY</button><br>";
                            output += "</div>";
                            output += "<hr><br>";
                            
                            
                          output += "==========================================================\n";
                          output += list.get(i).getProductName() + " " + list.get(i).getId();
                          output += "==========================================================\n";
                          
                        }
		
      out.write("\r\n");
      out.write("                ");
      out.print(output);
      out.write("\r\n");
      out.write("                \r\n");
      out.write("\t\t<script src=\"../js/like.js\"></script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
