/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashbord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Click
 */
public class DB_vaccination {
     private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "covid_plateforme";
    
     public static Connection con;
    
    public static Connection getConnection() throws SQLException{  
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, USERNAME, PASSWORD);
       return con; 
    }
    
}
