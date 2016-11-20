/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASUS-A451LB
 */
@WebServlet(urlPatterns = {"/login_servlet"})
public class login_servlet extends HttpServlet {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/identityservice?zeroDateTimeBehavior=convertToNull";
  static final String USER = "root";
  static final String PASS = "";

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Connection conn = null;
    Statement stmt = null;
    try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      String user = request.getParameter("user_id");
      String pass = request.getParameter("user_password");
      
      String sql = "SELECT id, username  FROM user where (username=? or email=?) and password=?";
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setString(1,user);
      pst.setString(2,user);
      pst.setString(3,pass);
      ResultSet rs = pst.executeQuery();
      String id = null;
      String username = null;
      while(rs.next())
      {
        id=rs.getString("id");
        username=rs.getString("username");
      }
        
      //response.setContentType("application/xml");
      if(id!=null) {
          /* TODO output your page here. You may use following sample code. */
          
          sql = "UPDATE user SET session_exp = DATE_ADD(NOW(), INTERVAL 2 HOUR) WHERE id=?";
          pst = conn.prepareStatement(sql);
          pst.setString(1,id);
          pst.executeUpdate();
          
          response.sendRedirect(request.getParameter("URLvalid")+"?username="+username+"&token="+id);
          
      } else {
          response.sendRedirect(request.getParameter("URLvalid")+"?error=invalid");
      }
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
