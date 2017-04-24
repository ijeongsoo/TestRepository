/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam15;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author ijeongsu
 */
public class RootControllar implements Initializable{

    @FXML private Label label;
    @FXML private Slider slider;
    @FXML private TextField txt1;
    @FXML private TextField txt2;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        //how1
        slider.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                label.setFont(new Font(newValue.doubleValue()));
            }
        
        });
        
        /*txt1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                txt2.setText(newValue);
            }
        });*/
        
        txt1.textProperty().addListener((observable, oldValue, newValue)->{
            txt2.setText(newValue);
        });
        
        
    }
    
    
    
}
