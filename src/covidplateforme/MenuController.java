/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidplateforme;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Click
 */
public class MenuController implements Initializable {
    
      @FXML
    private JFXButton News;

    @FXML
    private JFXButton Statistics;

    @FXML
    private JFXButton Advices;

    @FXML
    private JFXButton Admin;

    @FXML
    private JFXButton Vaccin;

    @FXML
    private JFXButton About;
    @FXML
    private void adminClicked(ActionEvent ae) throws IOException{
        Stage stage = (Stage) Admin.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/adminpanel/AdminPanel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    private void statisticsClicked(ActionEvent ae) throws IOException{
        Stage stage = (Stage) Admin.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/statistics/StatisticsHome.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML 
    private void newsClicked(ActionEvent e) throws IOException{
       Stage stage = (Stage) Admin.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/news/MenuUser.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show(); 
    }
    @FXML 
    private void adviceClicked(ActionEvent e) throws IOException{
       Stage stage = (Stage) Admin.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/advice/Advice.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show(); 
    }
    @FXML 
    private void vaccinClicked(ActionEvent e) throws IOException{
       Stage stage = (Stage) Admin.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/vaccination/vaccin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show(); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
