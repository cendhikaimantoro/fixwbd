package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import MarketplaceWS.*;
import java.util.List;
import java.util.ArrayList;

public final class your_005fproducts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write('\r');
      out.write('\n');
  
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Your Products</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"your_products\">\r\n");
      out.write("        <center><div class=\"title\">Sale<span class=\"bluetext\">Project</span></div></center><br><br>';\r\n");
      out.write("        <div class=\"right\">Hi, ");
      out.print(request.getParameter("username"));
      out.write("!</div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <form action=\"http://localhost:8082/WBD_IdentityService/logout_servlet\" method=\"POST\" class=\\\"logout\\\">;\r\n");
      out.write("            <input type=\"hidden\" name=\"URLvalid\" value=\"http://localhost:8080/WBD_WebApp/login.jsp\">\r\n");
      out.write("            <input type=\"hidden\" name=\"token\" value=");
      out.print("\""+request.getParameter("token")+"\"");
      out.write(">\r\n");
      out.write("            <input type=\"submit\" value=\"logout\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <ul class=\"navibar\">\r\n");
      out.write("            <li class=\"catalog\"><a href=");
      out.print("\"catalog.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Catalog</a></li>\r\n");
      out.write("            <li class=\"your_products\"><a href=");
      out.print("\"your_products.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Your Products</a></li>\r\n");
      out.write("            <li class=\"add_products\"><a href=");
      out.print("\"add_product.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Add Product</a></li>\r\n");
      out.write("            <li class=\"sales\"><a href=");
      out.print("\"sales.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Sales</a></li>\r\n");
      out.write("            <li class=\"purchases\"><a href=");
      out.print("\"purchases.jsp?username="+request.getParameter("username")+"&token="+request.getParameter("token")+"\"");
      out.write(">Purchases</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <br><br><br>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"subtitle\">What are you going to sell today?</div><hr>\r\n");
      out.write("\t\t\r\n");
      out.write("        ");

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
        
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
      out.print(web);
      out.write("\r\n");
      out.write("        <script src=\"../js/formvalidation.js\"></script>\r\n");
      out.write("    </body>\r\n");
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
