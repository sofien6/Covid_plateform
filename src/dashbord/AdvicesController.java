/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashbord;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.HTMLEditor;

/**
 * FXML Controller class
 *
 * @author Click
 */
public class AdvicesController implements Initializable {

    @FXML
    private HTMLEditor html;

    @FXML
    private Label succes;

    @FXML
    private JFXButton clear;

    @FXML
    private JFXButton add;

    
    @FXML
    private void clear(ActionEvent e){
          html.setHtmlText("");
    }
    @FXML
    private void add(ActionEvent e) throws SQLException{
      String text = html.getHtmlText(); 
      int state = DBAdvices.inserts(text);
      if (state > 0){
          succes.setText("Advice Added with success");
      }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       succes.setText("You can add more Advices Here"); 
    }    
    
}
