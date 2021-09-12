/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Click
 */
public class DBGetAdvices {
     private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "covid_plateforme";
    
    public static Connection con;
    
    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("connection failed !");
        }
    }
    
    public static String getNews(String id) {
        Connection con = DBGetAdvices.con;
        if(con == null)
            
            return "-1";
        
        String sql = "SELECT * FROM advices WHERE ID =?";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, id);
            ResultSet rs = prest.executeQuery();
            
            while(rs.next()) {
                return rs.getString(2);
            }
            
        } catch(SQLException se) {
            //se.printStackTrace();
            System.out.println("SQL Error !");
        }
        
        return "1";
    }
      public static int checkConnection(){
          Connection connection = DBGetAdvices.con;
          if(connection == null){
              return -1; 
          }   
          else {
              return 0 ; 
          }
      }
}
