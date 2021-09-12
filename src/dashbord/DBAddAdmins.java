/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashbord;

import static dashbord.DBAdvices.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBAddAdmins {
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
    
    public static int insertion(String email , String username, String password) throws SQLException{
        int update;
        Connection connect = DBAddAdmins.con; 
        if(connect == null){
            return -1; 
        }
        String sql = "INSERT INTO user (email,username,password)VALUES (?,?,?);";
        PreparedStatement prest = con.prepareStatement(sql); 
        prest.setString(1,email);
        prest.setString(2,username);
        prest.setString(3,password);
        update = prest.executeUpdate();
        return update; 
    }
}
