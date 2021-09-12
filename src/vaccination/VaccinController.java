/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccination;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Click
 */
public class VaccinController implements Initializable {


    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField adress;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField profession;

    @FXML
    private JFXTextField nin;

    @FXML
    private RadioButton firstQ;

    @FXML
    private ToggleGroup yesno;

    @FXML
    private RadioButton firstQ1;

    @FXML
    private RadioButton secondQ;

    @FXML
    private ToggleGroup ok;

    @FXML
    private RadioButton secondQ1;

    @FXML
    private RadioButton thirdQ;

    @FXML
    private ToggleGroup yesno2;

    @FXML
    private RadioButton thirdQ1;

    @FXML
    private RadioButton fourthQ;

    @FXML
    private ToggleGroup yesno3;

    @FXML
    private RadioButton fourthQ1;

    @FXML
    private JFXComboBox combo;

    @FXML
    private JFXDatePicker date;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female;

    @FXML
    private JFXButton cancel;

    @FXML
    private JFXButton submit;
    
    @FXML
    private void cancel(ActionEvent e) throws IOException{
        Stage stage = (Stage) cancel.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/covidplateforme/Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    private void submit(ActionEvent e) throws SQLException, IOException{
        String gender; 
        String positives; 
        String fevers; 
        String 	allergys; 
        String pregnants;
        String vaccinname; 
        LocalDate dates; 
        String fullName = firstName.getText() +" " + lastName.getText();
        String ages = age.getText(); 
        if (male.isSelected()){
            gender = "male";
        }
        else {
            gender = "female"; 
        }
        String address = adress.getText(); 
        String emails = email.getText(); 
        String 	phones = phone.getText(); 
        String professions = profession.getText(); 
        String nins = nin.getText(); 
        if (firstQ.isSelected()){
            positives = "yes";
        }
        else {
            positives = "no"; 
        }
        if (secondQ.isSelected()){
            fevers = "yes";
        }
        else {
            fevers = "no"; 
        }
        if (thirdQ.isSelected()){
            allergys = "yes";
        }
        else {
            allergys = "no"; 
        }
        if (fourthQ.isSelected()){
            pregnants = "yes";
        }
        else {
            pregnants = "no"; 
        }
        vaccinname = combo.getSelectionModel().getSelectedItem().toString();
        dates = date.getValue(); 
        String datess = dates.toString();
        int state = DB_vaccin.insertion(fullName,ages,gender,address,emails,phones,professions,nins,positives,fevers,allergys,pregnants,vaccinname,datess);
        if (state == 1 ){
        Stage stage = (Stage) submit.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/vaccination/success.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ObservableList<String> list = FXCollections.observableArrayList("Moderna","Pfizer","Astrazeneca","Spoutnik ");
     combo.setItems(list);
    }   
    
}
