/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam42;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

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
    //RootController.rootPane.getChildren().remove(1);
    StackPane rootPane=(StackPane)btnMain.getScene().getRoot();
    rootPane.getChildren().remove(login);
    
  }
}
