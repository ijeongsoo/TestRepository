/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam16;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 *
 * @author ijeongsu
 */
public class RootControllar implements Initializable{

    @FXML private TextArea textArea1;
    @FXML private TextArea textArea2;
    
   
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        //단방향 바인딩
        //textArea2.textProperty().bind(textArea1.textProperty());
        
        //양방향 바인딩
        Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
        
    }
    
    
    
}
