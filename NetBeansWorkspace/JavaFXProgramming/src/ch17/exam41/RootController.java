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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
    btnLogin.setOnAction((event) -> {
	handleBtnLogin(event);
    });
  }  

  private void handleBtnLogin(ActionEvent event) {
    try {
	Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
	Scene scene = new Scene(parent);
	
	Stage primaryStage = (Stage)btnLogin.getScene().getWindow();
	primaryStage.setScene(scene);
    
    } catch (IOException ex) {
	ex.printStackTrace();
    }
    
    
  }
  
}
