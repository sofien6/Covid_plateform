/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advice;

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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import news.DBGetNews;

/**
 * FXML Controller class
 *
 * @author Click
 */
public class AdviceController implements Initializable {
    public int i = 1; 
    @FXML
    private WebView web;
   

    @FXML
    private JFXButton previous;

    @FXML
    private JFXButton next;
 
    @FXML
    private JFXButton Home;
    
    @FXML
    public void getNews(){
     WebEngine webE = web.getEngine();
      next.setOnMouseClicked((event)->{
      i++;
      previous.setDisable(false);
      System.out.println(i);
      String s  = Integer.toString(i);
      String news =  DBGetAdvices.getNews(s); 
      if(news.equals("1")){
          next.setDisable(true);
          i--;
      }
      else{
          webE.loadContent(news);
      }
      
      });
     
      previous.setOnMouseClicked((event)->{
      i--;
      next.setDisable(false);
      System.out.println(i);
      String s  = Integer.toString(i);
      String news =  DBGetAdvices.getNews(s); 
          if(i == 0 || news.equals("1") ){
              previous.setDisable(true);
              i++;
          }
          else{
          webE.loadContent(news);
          previous.setDisable(false);
          }
      });
    }
      @FXML
    private void HomeClicked(ActionEvent ae) throws IOException{
        Stage stage = (Stage) Home.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("/covidplateforme/Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           WebEngine webE = web.getEngine();
           String s  = Integer.toString(i);
           String news =  DBGetAdvices.getNews(s); 
           webE.loadContent(news);
    }    
    
}
