/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam43;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class LoginController implements Initializable {

  @FXML
  private BorderPane login;
  @FXML
  private Button btnMain;
	@FXML
	private Label lblLogin;
	Thread thread ;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
	  System.gc();
    btnMain.setOnAction((event) -> {
	handleBtnMain(event);
    });
      thread = new Thread(() -> {
	    while(true){
		    try{
			    Thread.sleep(1000);
			    Platform.runLater(() -> {
				    lblLogin.setText("aaa");
			    });
			    
		    } catch (InterruptedException ex) {
			    break;
		    }
	    }
    
    });
     thread.start();
     
  }  

  
  
  private void handleBtnMain(ActionEvent event) {
    //RootController.rootPane.getChildren().remove(1);
    
   
    //thread.interrupt();
    StackPane rootPane=(StackPane)btnMain.getScene().getRoot();
    login.setOpacity(1);
	
    KeyValue keyvalue = new KeyValue(login.opacityProperty(), 0);
	
    KeyFrame keyFrame = new KeyFrame(
		Duration.millis(500),
		(e) -> {rootPane.getChildren().remove(login);} ,
		keyvalue
    );
	  
    Timeline timeline = new Timeline();
    timeline.getKeyFrames().add(keyFrame);
    
    timeline.play();
    
	
    
    
  }

	@Override
	protected void finalize() throws Throwable {
		System.out.println("끝");
	}
  
  
}
