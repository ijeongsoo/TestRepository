/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ijeongsu
 */
public class AppMain extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
   
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("창제목");   
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
