/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashbord;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Click
 */
public class VaccinformController implements Initializable {

     @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable,String> fullName;

    @FXML
    private TableColumn<ModelTable,String> age;

    @FXML
    private TableColumn<ModelTable,String> gender;

    @FXML
    private TableColumn<ModelTable,String> address;

    @FXML
    private TableColumn<ModelTable,String> email;

    @FXML
    private TableColumn<ModelTable,String> phone;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             Connection con  = DB_vaccination.getConnection();
             ResultSet res  = con.createStatement().executeQuery("SELECT * FROM vaccin");
             while (res.next()){
                 oblist.add(new ModelTable(res.getString("fullname"),res.getString("age"),res.getString("gender"),res.getString("address"),res.getString("email"),res.getString("phone")));
             }
         } catch (SQLException ex) {
             Logger.getLogger(VaccinformController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        table.setItems(oblist);
    }    
    
}
