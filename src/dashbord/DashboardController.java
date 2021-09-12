/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashbord;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

 

public class DashboardController implements Initializable {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Label user;

    @FXML
    private JFXButton news;

    @FXML
    private JFXButton advices;

    @FXML
    private JFXButton vaccin;

    @FXML
    private JFXButton admins;

    @FXML
    private JFXButton logout;


    @FXML 
    private void news(ActionEvent e){
        loader("News"); 
    }
    @FXML 
    private void advices(ActionEvent e){
        loader("Advices"); 
    }
    @FXML
     private void admin(ActionEvent e){
                loader("adminRegister"); 
    }
     @FXML
     private void vaccin(ActionEvent e){
                loader("vaccinform"); 
    }
    @FXML 
    private void loader(String fxml){
        Parent root  = null; 
        try{
            root = FXMLLoader.load(getClass().getResource(fxml+".fxml"));
            borderpane.setCenter(root);
        }catch(IOException e){
        }
    }
    @FXML
    public void logOut(ActionEvent ae) throws IOException{
        Stage stage = (Stage) logout.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/adminpanel/AdminPanel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       user.setText("Hello admin");
    }    
    
}
