/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashbord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBAdvices {
    
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
    public static int inserts(String Text) throws SQLException{
        int st; 
        Connection connect = DBAdvices.con; 
        
        if(connect == null){
            return 1; 
        }
        String sql = "INSERT INTO `advices` (`TEXTE`) VALUES (?);"; 
        PreparedStatement prest = con.prepareStatement(sql); 
        prest.setString(1,Text);
        st = prest.executeUpdate();
        System.out.println(st);
        return st;
    }
    
}
