/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam43;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class RootController implements Initializable {

  @FXML
  private Button btnLogin;
  @FXML
  private StackPane stackPane;
  
  public static StackPane rootPane;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
    btnLogin.setOnAction((event) -> {
	handleBtnLogin(event);
    });
    rootPane=stackPane;
  }  

  private void handleBtnLogin(ActionEvent event) {
    try {
	    System.gc();
	Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
	stackPane.getChildren().add(parent);
	
	parent.setTranslateX(350);
	
	KeyValue keyvalue = new KeyValue(parent.translateXProperty(), 0);
	
	KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyvalue);
	
	Timeline timeline = new Timeline();
	timeline.getKeyFrames().add(keyFrame);
	
	timeline.play();
	
    
    } catch (IOException ex) {
	ex.printStackTrace();
    }
    
    
  }
  
}
