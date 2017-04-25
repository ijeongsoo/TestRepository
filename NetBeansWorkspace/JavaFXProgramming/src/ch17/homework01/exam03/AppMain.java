/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.homework01.exam03;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author ijeongsu
 */
public class AppMain extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setPrefWidth(350);
        root.setPrefHeight(150);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        
        Label label = new Label();
        label.setText("Hello, JavaFX");
        label.setFont(new Font(50));
        
        
        Button button = new Button();
        button.setText("확인");
        button.setOnAction(event->Platform.exit());
        
        root.getChildren().add(label);
        root.getChildren().add(button);
        
        Scene scne = new Scene(root);
        primaryStage.setTitle("AppMain");
        primaryStage.setScene(scne);
        primaryStage.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
