/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashbord;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Click
 */
public class adminRegisterController implements Initializable {
    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField username;
    
    @FXML
    private Label checked;

    @FXML
    public void register(ActionEvent e) throws SQLException{
        if (username.getText().isEmpty() || password.getText().isEmpty()){
            checked.setText(" username or password are empty ");
        }
        else{
            int status = DBAddAdmins.insertion(email.getText(),username.getText(), password.getText()); 
        if(status > 0 ){
            checked.setText("congratulation  "+username.getText());
        }
        else{
            checked.setText("We are sorry "+username.getText());
        }
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
