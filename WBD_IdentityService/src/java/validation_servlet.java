/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS-A451LB
 */
@WebServlet(urlPatterns = {"/validation_servlet"})
public class validation_servlet extends HttpServlet {
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
    processRequest(request, response);
    Connection conn = null;
    Statement stmt = null;
    PrintWriter out = response.getWriter();
    response.setContentType("text/html;charset=UTF-8");
    try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      String user = request.getParameter("user_id");
      String pass = request.getParameter("user_password");
      
      String sql = "SELECT *  FROM user where id=?";
      PreparedStatement pst = conn.prepareStatement(sql);
      pst.setInt(1,Integer.parseInt(request.getParameter("token")));
      ResultSet rs = pst.executeQuery();
      String id = null;
      Timestamp ts = null;
      while(rs.next())
      {
        id=rs.getString("id");
        ts=rs.getTimestamp("session_exp");
      }
      
      if(id!=null) {
          /* TODO output your page here. You may use following sample code. */
          if (ts != null) {
            sql = "SELECT *  FROM user where id=? AND session_exp > NOW()";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(id));
            rs = pst.executeQuery();
            id = null;
            while(rs.next()) {
              id=rs.getString("id");
            }
            if (id != null) {
              sql = "UPDATE user SET session_exp = DATE_ADD(NOW(), INTERVAL 2 HOUR) WHERE id=?";
              pst = conn.prepareStatement(sql);
              pst.setInt(1,Integer.parseInt(id));
              pst.executeUpdate();
              out.println(id);
            } else {
              out.println("EXPIRED");
            }
          } else {
            out.println("NOT LOGGED IN");
          }
      } else {
          out.println("INVALID");
      }
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        out.println(e.getMessage());
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        out.println(e.getMessage());
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
