/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam18;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class RootController implements Initializable {

    @FXML
    private Button btnClose;
    @FXML
    private CheckBox cb1;
    @FXML
    private CheckBox cb2;
    @FXML
    private ImageView checkImageView;
    @FXML
    private ToggleGroup rbGroup;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private ImageView radioImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnClose.setOnAction((event) -> {
            Platform.exit();
        });
        
        cb1.setOnAction((event) -> {
            handleCheckAction();
        });
        
        cb2.setOnAction((event) -> {
            handleCheckAction();
        });
        
        rbGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                //How1
                /*if(newValue == rb1){
                    radioImageView.setImage(new Image(getClass().getResource("images/BubbleChart.png").toString()));
                }else if(newValue ==rb2){
                    radioImageView.setImage(new Image(getClass().getResource("images/BarChart.png").toString()));
                }else{
                    radioImageView.setImage(new Image(getClass().getResource("images/AreaChart.png").toString()));
                }*/
                
                //How2
                String fileName=newValue.getUserData()+".png";
                radioImageView.setImage(new Image(getClass().getResource("images/"+fileName).toString()));
            }
            
        });
    }

    private void handleCheckAction(){
        if(cb1.isSelected()&&cb2.isSelected()){
                checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses-hair.gif").toString()));
        }else if(cb1.isSelected()){
                checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses.gif").toString()));
        }else if(cb2.isSelected()){
                checkImageView.setImage(new Image(getClass().getResource("images/geek-hair.gif").toString()));
        }else{
                checkImageView.setImage(new Image(getClass().getResource("images/geek.gif").toString()));
        }
    }
    
    
}
