package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
  
    String token = request.getParameter("token");
    String username = request.getParameter("username");
    String redirect = "";
      if (token == null || username == null) {
            redirect = "<meta http-equiv=\"refresh\" content=\"0; url=login.jsp?error=loginfirst\" />";
      }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("\t<title>Add Product</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"add_product\">\r\n");
      out.write("         <center><div class=\"title\">Sale<span class=\"bluetext\">Project</span></div></center><br><br>';\r\n");
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
      out.write("                <br><br><br>\r\n");
      out.write("        <div class=\"subtitle\">Please add your product here</div><hr>\r\n");
      out.write("            <form action='your_products.jsp");
      out.print("?username="+request.getParameter("username")+"&token="+request.getParameter("token"));
      out.write("' method=\"post\" name=\"add_product\" >\r\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"add\">\r\n");
      out.write("                <input type=\"hidden\" name=\"username\" value=");
      out.print(request.getParameter("username"));
      out.write(">\r\n");
      out.write("                <input type=\"hidden\" name=\"token\" value=");
      out.print(request.getParameter("token"));
      out.write(">\r\n");
      out.write("                Name <br>\r\n");
      out.write("                    <input type=\"text\" name=\"product_name\" class=\"text_input\"> <br>\r\n");
      out.write("                Description (max 200 chars) <br>\r\n");
      out.write("                    <textarea name=\"product_description\" class=\"text_input__long\"></textarea> <br>\r\n");
      out.write("                Price <br>\r\n");
      out.write("                    <input type=\"text\" name=\"product_price\" class=\"text_input\"> <br>\r\n");
      out.write("                Photo <br>\r\n");
      out.write("                            <input type=\"file\" name=\"product_photo\" class=\"file_input\"> <br>\r\n");
      out.write("                    <input type=\"submit\" value=\"ADD\" class=\"button\">\r\n");
      out.write("            </form>\r\n");
      out.write("        \r\n");
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
