/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.*;

/**
 *
 * @author njruntuwene
 */
public class DB {
    private static Connection myConnection;
    static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";
    static final String USER = "username";
    static final String PASS = "password";
    
    /** Creates a new instance of MyDBConnection */
    public DB() {

    }

    public static void init(){
    
       try{
        
        Class.forName("com.mysql.jdbc.Driver");
        myConnection=DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }
    
    
    public static Connection connect(){
        init();
        return myConnection;
    }
    
    
    public void close(ResultSet rs){
        if(rs !=null){
            try{
               rs.close();
            }
            catch(Exception e){}
        }
    }
    
     public void close(java.sql.Statement stmt){
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(Exception e){}
        }
    }
     
  public void destroy(){
    if(myConnection !=null){
         try{
               myConnection.close();
            }
            catch(Exception e){}
    }
  }
}
