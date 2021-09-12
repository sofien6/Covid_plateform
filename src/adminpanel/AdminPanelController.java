/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpanel;

import DAO.DB_connect;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class AdminPanelController implements Initializable {
    
    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private Label check;

    @FXML
    private Label error;

    @FXML
    private JFXButton Home;

    @FXML
    private void HomeClicked(ActionEvent ae) throws IOException{
        Stage stage = (Stage) Home.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/covidplateforme/Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    private void loginClicked(ActionEvent ae){
        if (!username.getText().matches("[a-zA-Z0-9_]{4,}")) {
            return;
        }
        if (password.getText().isEmpty()) {
            return;
        }
        int status = DB_connect.checkLogin(username.getText().trim().toLowerCase(), password.getText());
        switch (status) {
            case 0: {
                Stage stage = (Stage) username.getScene().getWindow();

                Parent root = null;
                try {
                 root = FXMLLoader.load(getClass().getResource("/dashbord/Dashboard.fxml"));
                } catch (IOException ex) {
                    
                }
                stage.setScene(new Scene(root));
            }
            break;
            case -1:
                JOptionPane.showMessageDialog(null, "Connection Failed");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Username or password wrong");
                break;
        }
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               int state = DB_connect.checkConnection(); 
               if(state == 0){
                   check.setText("connection success");
                   error.setText("");
               }
               else{
                   check.setText("");
                   error.setText("connection failed");
               }
    }    
    
}
