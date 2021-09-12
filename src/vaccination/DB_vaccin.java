/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccination;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DB_vaccin {
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
    
    public static int insertion(String fullName,String ages,String gender,String address, String emails,String phones,String professions,String nins,String positives,String fevers,String allergys,String pregnants,String vaccinname,String datess) throws SQLException{
        int update;
        Connection connect = DB_vaccin.con; 
        if(connect == null){
            return -1; 
        }
        String sql = "INSERT INTO vaccin (fullname,age,gender,address,email,phone,profession,nin,positive,fever,allergy,pregnant,vaccinname,date)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement prest = con.prepareStatement(sql); 
        prest.setString(1,fullName);
        prest.setString(2,ages);
        prest.setString(3,gender);
        prest.setString(4,address);
        prest.setString(5,emails);
        prest.setString(6,phones);
        prest.setString(7,professions);
        prest.setString(8,nins);
        prest.setString(9,positives);
        prest.setString(10,fevers);
        prest.setString(11,allergys);
        prest.setString(12,pregnants);
        prest.setString(13,vaccinname);
        prest.setString(14,datess);
        update = prest.executeUpdate();
        return update; 
    }
}
