/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam29.chatReview.client;

import ch18.exam29.Client.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ijeongsu
 */
public class ChatClient extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Parent parent = FXMLLoader.load(getClass().getResource("client.fxml"));
   
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("client");   
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
