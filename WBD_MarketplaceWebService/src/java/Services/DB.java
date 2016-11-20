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
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/marketplace?zeroDateTimeBehavior=convertToNull";
    static final String USER = "root";
    static final String PASS = "";
    
    /** Creates a new instance of MyDBConnection */
    public DB() {

    }

    public void init(){
    
       try{
        
        Class.forName(JDBC_DRIVER);
        myConnection=DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }
    
    
    public static Connection connect(){
        try{
        
          Class.forName(JDBC_DRIVER);
          myConnection=DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
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
