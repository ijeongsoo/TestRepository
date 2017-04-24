/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam14;

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
public class RootControllar implements Initializable{

    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        //how1
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("버튼1이 클릭 됨");
            }
        });
        
        
        //how2
        btn2.setOnAction((event) -> {
            System.out.println("버튼2가 클릭 됨"); 
        });
        
        
        
        
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("버튼4가 클릭 됨");
            }
        });
        
        btn5.setOnAction((event) -> {
            System.out.println("버튼5가 클릭 됨");
        });
        
        
    }
    
    //how3
        public void btn3Handle(ActionEvent event){
            System.out.println("버튼3이 클릭 됨");
        }
        
        public void btn6Handle(ActionEvent event){
            System.out.println("버튼6가 클릭 됨");
        }
    
    
}
