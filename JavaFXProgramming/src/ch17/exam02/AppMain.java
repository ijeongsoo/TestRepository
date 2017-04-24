/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam02;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ijeongsu
 */
public class AppMain extends Application{

    
   
    
    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox=new VBox();
        Label label = new Label();
        label.setText("Hello, JavaFX");
        vbox.getChildren().add(label);
        vbox.setPrefWidth(400);
        vbox.setPrefHeight(300);
        
        Button button = new Button();
        button.setText("확인");
        vbox.getChildren().add(button);
        
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
        
    }

    
    public static void main(String[] args) {
        launch(args);
        Platform.exit();
    }
    
}
