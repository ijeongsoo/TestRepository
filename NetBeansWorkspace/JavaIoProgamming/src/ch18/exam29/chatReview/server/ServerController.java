/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam29.chatReview.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class ServerController implements Initializable {

	  @FXML
	  private Button btnStartSop;
	  @FXML
	  private TextArea txtDisplay;
	  private ExecutorService excutorService;

	  /**
	   * Initializes the controller class.
	   */
	  @Override
	  public void initialize(URL url, ResourceBundle rb) {
			btnStartSop.setOnAction((event) -> {
				  if(btnStartSop.getText().equals("시작")){
						handleStart(event);
				  }else{
						handleStop(event);
				  }
			});
	  }	  
	  
	  private void handleStart(ActionEvent event) {
			btnStartSop.setText("종료");
			print("시작하였습니다");
			try {
				  //서버소켓 생성 및 연결 대기
				  ServerSocket serverSocket = new ServerSocket();
				  Socket socket = serverSocket.accept();
				  
				  Client client = new Client(socket);
				  
			} catch (IOException ex) {
			}
			
			
	  }
	  

	  private void handleStop(ActionEvent event) {
			btnStartSop.setText("시작");
			print("종료하였습니다");
	  }

	  
	  private void print(String message){
			txtDisplay.appendText(message+"\n");
	  }
	  
	  class Client{
			private Socket socket;
			
			public Client(Socket socket) {
				  this.socket=socket;
			}
			
			public void send(String message){
				  
			}
			
			public void recieve(){
				  
			}
			
	  }
	  
}
