
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_connect{
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
    
    public static int checkLogin(String username, String password) {
        Connection con = DB_connect.con;
        if(con == null)
            return -1;
        
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, username);
            prest.setString(2, password);
            
            ResultSet rs = prest.executeQuery();
            
            while(rs.next()) {
                return 0;
            }
            
        } catch(SQLException se) {
            //se.printStackTrace();
            System.out.println("SQL Error !");
        }
        
        return 1;
    }
      public static int checkConnection(){
          Connection connection = DB_connect.con;
          if(connection == null){
              return -1; 
          }   
          else {
              return 0 ; 
          }
      }
}