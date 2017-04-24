/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam41;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnMain.setOnAction((event) -> {
	handleBtnMain(event);
    });
  }  

  
  
  private void handleBtnMain(ActionEvent event) {
    try {
	Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
	Scene scene = new Scene(parent);
	
	Stage primaryStage = (Stage)btnMain.getScene().getWindow();
	primaryStage.setScene(scene);
    
    } catch (IOException ex) {
	ex.printStackTrace();
    }
    
    
  }
}
