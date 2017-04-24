/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.homework02.exam01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author ijeongsu
 */
public class AppMain extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(50,10,10,50));
        Button button = new Button();
        button.setPrefSize(100, 100);
        
        
        /*HBox hbox = new HBox();
        Button button = new Button();
        button.setPrefSize(100,100);
        HBox.setMargin(button, new Insets(10,10,50,50));*/
        
        hbox.getChildren().add(button);
        Scene scene = new Scene(hbox);
        
        primaryStage.setTitle("AppMain");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
    
}
