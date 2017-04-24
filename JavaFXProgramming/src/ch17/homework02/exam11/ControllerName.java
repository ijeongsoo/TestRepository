/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.homework02.exam11;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author ijeongsu
 */
public class ControllerName implements Initializable{
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleBtn1Action(event);
            }
        });
        
        btn2.setOnAction((event) -> {
            handleBtn2Action(event);
        });
        
        btn3.setOnAction((event) -> {
            handleBtn3Action(event);
        });
        
    }
    
    public void handleBtn1Action(ActionEvent event){
        System.out.println("버튼 1 클릭");
    }
    
    public void handleBtn2Action(ActionEvent event){
        System.out.println("버튼 2 클릭");
    }
    
    public void handleBtn3Action(ActionEvent event){
        System.out.println("버튼 3 클릭");
    }
    
    
}
