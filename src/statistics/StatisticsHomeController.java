/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import coronaVirus.Coronavirus;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import static javafx.application.Application.launch;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Camera;
import javafx.scene.Cursor;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import latest.Latest;
import source.Sources;

/**
 * FXML Controller class
 *
 * @author Click
 */
public class StatisticsHomeController implements Initializable {
    final Group root = new Group();
    final XformWorld world = new XformWorld();
    final PerspectiveCamera camera = new PerspectiveCamera(true);
    final XformCamera cameraXform = new XformCamera();
    private static final double CAMERA_INITIAL_DISTANCE = -1000;
    private static final double CAMERA_NEAR_CLIP = 0.1;
    private static final double CAMERA_FAR_CLIP = 10000.0;
    double mousePosX, mousePosY, mouseOldX, mouseOldY, mouseDeltaX, mouseDeltaY;

    @FXML
    private JFXButton Home;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label recovered;

    @FXML
    private Label deaths;

    @FXML
    private Label confirmed;
    
    @FXML
    private Label country;
     
    @FXML
    private void HomeClicked(ActionEvent ae) throws IOException{
        Stage stage = (Stage) Home.getScene().getWindow(); 
        Parent home = FXMLLoader.load(getClass().getResource("/covidplateforme/Menu.fxml"));
        Scene scene = new Scene(home);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        recovered.setText("Recovered : 0 ");
        confirmed.setText("Confirmed : 0");
        deaths.setText("Deaths : 0");

        Group group = new Group(); 
        root.getChildren().add(world);
        root.setDepthTest(DepthTest.ENABLE);
        buildCamera();
        buildBodySystem();
        handleMouse();
        group.getChildren().add(root); 
        SubScene sub = new SubScene(group,800,600,true,SceneAntialiasing.BALANCED);           
        sub.setCamera(camera);
        anchor.getChildren().add(sub);
    }    
    
     
   
    public static void main(String[] args) {
        launch(args);
    }

    private void buildCamera() {
        root.getChildren().add(cameraXform);
        cameraXform.getChildren().add(camera);
        camera.setNearClip(CAMERA_NEAR_CLIP);
        camera.setFarClip(CAMERA_FAR_CLIP);
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
    }

    private void buildBodySystem() {
          PhongMaterial earth = new PhongMaterial();
        earth.setDiffuseMap(new Image(getClass().getResourceAsStream("earth.jpg")));
        
        Sphere sphere = new Sphere(220);
        sphere.setMaterial(earth);
        PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);
        Sphere algeria = new Sphere(4);
        algeria.setMaterial(redMaterial);
        algeria.setTranslateZ(-180.0);
        algeria.setTranslateX(-60);
        algeria.setTranslateY(-110);
        algeria.setCursor(Cursor.HAND);
        world.getChildren().addAll(algeria);
        world.getChildren().addAll(sphere);
        
        Sphere france = new Sphere(4);
        france.setMaterial(redMaterial);
        france.setTranslateZ(-150.0);
        france.setTranslateX(-40);
        france.setTranslateY(-160);
        france.setCursor(Cursor.HAND);
        world.getChildren().addAll(france);
        
        france.setOnMouseClicked(new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
                  try {
                      countryClicked("France");
                  } catch (IOException ex) {
                      Logger.getLogger(StatisticsHomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          });
        
        Sphere russia = new Sphere(4);
        russia.setMaterial(redMaterial);
        russia.setMaterial(redMaterial);
        russia.setTranslateZ(-40.0);
        russia.setTranslateX(80);
        russia.setTranslateY(-200);
        russia.setCursor(Cursor.HAND);
        world.getChildren().addAll(russia);
        
        algeria.setOnMouseClicked(new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
                  try {
                      countryClicked("Algeria");
                  } catch (IOException ex) {
                      Logger.getLogger(StatisticsHomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          });
        
        russia.setOnMouseClicked(new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
                  try {
                      countryClicked("Russia");
                  } catch (IOException ex) {
                      Logger.getLogger(StatisticsHomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          });
    }
    public void countryClicked(String countrys) throws IOException{
        Coronavirus corona = new Coronavirus(); 
        Latest latest = corona.getLocationsByCountry(countrys).getLatest(); 
        recovered.setText("Recovered : "+latest.getRecovered());
        confirmed.setText("Confirmed : "+latest.getConfirmed());
        deaths.setText("Deaths : "+latest.getDeaths());
        country.setText(countrys); 

    }
    private void handleMouse() {
        root.setOnMousePressed((MouseEvent me) -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
            // this is done after clicking and the rotations are apearently
            // performed in coordinates that are NOT rotated with the camera.
            // (pls activate the two lines below for clicking)
            //cameraXform.rx.setAngle(-90.0);
            //cameraXform.ry.setAngle(180.0);
        });
       root.setOnMouseDragged((MouseEvent me) -> {
            mouseOldX = mousePosX;
            mouseOldY = mousePosY;
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            mouseDeltaX = (mousePosX - mouseOldX);
            mouseDeltaY = (mousePosY - mouseOldY);
            if (me.isPrimaryButtonDown()) {
                // this is done when the mouse is dragged and each rotation is
                // performed in coordinates, that are rotated with the camera.            
                cameraXform.ry.setAngle(cameraXform.ry.getAngle() + mouseDeltaX * 0.1);
                cameraXform.rx.setAngle(cameraXform.rx.getAngle() - mouseDeltaY * 0.1);                
            }
        });
    }


}

class XformWorld extends Group {

    final Translate t = new Translate(0.0, 0.0, 0.0);
    final Rotate rx = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
    final Rotate ry = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
    final Rotate rz = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);

    public XformWorld() {
        super();
        this.getTransforms().addAll(t, rx, ry, rz);
    }

}

class XformCamera extends Group {

    final Translate t = new Translate(0.0, 0.0, 0.0);
    final Rotate rx = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
    final Rotate ry = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
    final Rotate rz = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);

    public XformCamera() {
        super();
        this.getTransforms().addAll(t, rx, ry, rz);
    }

}


