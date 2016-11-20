package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>login</title>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<center><div class=\"title\">Sale<span class=\"bluetext\">Project</span></div></center><br><br>\r\n");
      out.write("\t\t<div class=\"subtitle\">Please Login</div>\r\n");
      out.write("\t\t<hr><br>\r\n");
      out.write("\t\t<form action=\"http://localhost:8082/WBD_IdentityService/login_servlet\" method=\"post\" name=\"login_form\"\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"URLvalid\" value=\"http://localhost:8080/WBD_WebApp/catalog.jsp\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"URLinvalid\" value=\"http://localhost:8080/WBD_WebApp/login.jsp\">\r\n");
      out.write("\t\t\tEmail or Username<br>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"user_id\" class=\"text_input\">\r\n");
      out.write("\t\t\t<p id=\"id_warning\" class=\"warning\"></p><br>\r\n");
      out.write("\t\t\tPassword<br>\r\n");
      out.write("\t\t\t<input type=\"password\" name=\"user_password\" class=\"text_input\">\r\n");
      out.write("\t\t\t<p id=\"pass_warning\" class=\"warning\"></p><br>\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"LOGIN\" class=\"button\">\r\n");
      out.write("                        \r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<div class=\"redtext\">\r\n");
      out.write("\t\t\t<p class=\"warning\"></p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br><br><br>\r\n");
      out.write("\t\t<div>Don't have an account yet? Register <a href=\"register.jsp\" class=\"bluetext\">here</a></div>\r\n");
      out.write("\t\t");
      out.write("\r\n");
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
