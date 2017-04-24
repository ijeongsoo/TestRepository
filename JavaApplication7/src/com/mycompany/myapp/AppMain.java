
package com.mycompany.myapp;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppMain extends Application{

	  @Override
	  public void start(Stage primaryStage) throws Exception {
			Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
			Scene scene = new Scene(parent);
	  }
	  
	  
	  
	  public static void main(String[] args) {
			System.out.println("내용1");
			System.out.println("내용1");
			AppMain.launch();
	  }

}
