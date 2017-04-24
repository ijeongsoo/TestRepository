/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam29.Client;

import ch18.exam29.Server.ServerController;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class ClientController implements Initializable {

	  @FXML
	  private Button btnConn;
	  @FXML
	  private TextField txtInput;
	  @FXML
	  private Button btnSend;
	  @FXML
	  private TextArea txtDisplay;
	  private Socket socket;

	  /**
	   * Initializes the controller class.
	   */
	  @Override
	  public void initialize(URL url, ResourceBundle rb) {
			btnConn.setOnAction((event) -> {
				  handleBtnConn(event);
			});
			btnSend.setOnAction((event) -> {
				  handleBtnSent(event);
			});
			
			txtInput.setOnKeyPressed((event) -> {
				  if(event.getCode()==KeyCode.ENTER){
						  handleBtnSent(new ActionEvent());
					}						
			});
		
			
	  }

	  private void handleBtnSent(ActionEvent event) {
			send(txtInput.getText());
			txtInput.setText("");
	  }

	  private void handleBtnConn(ActionEvent event) {
			if (btnConn.getText().equals("연결")) {
				  startClient();
			} else if (btnConn.getText().equals("연결끊기")) {
				  stopClient();
			}

	  }

	  private void startClient() {
			Thread thread = new Thread(() -> {
				  try {
						//소켓 생성
						socket = new Socket();
						//서버와 연결하기 
						socket.connect(new InetSocketAddress("192.168.3.51", 50001));
						//연결성공 출력
						Platform.runLater(() -> {
							  btnConn.setText("연결끊기");
							  display("연결성공");
						});
						recieve();
				  } catch (Exception ex) {
						Platform.runLater(() -> {
							  display("연결실패");
							  stopClient();

						});
						return;
				  }
			});
			thread.start();

	  }

	  private void stopClient() {
			try {
				  socket.close();
			} catch (IOException ex) {
			}
			Platform.runLater(() -> {
				  btnConn.setText("연결");
				  display("연결 끊김");
			});
	  }

	  private void display(String text) {
			txtDisplay.appendText(text + "\n");
	  }

	  private void recieve() {
			try {
				  while (true) {
						InputStream is = socket.getInputStream();
						byte[] byteArr = new byte[100];
						int readBytes = is.read(byteArr);

						if (readBytes == -1) {
							  throw new Exception();
						}
						String strData = new String(byteArr, 0, readBytes);
						Platform.runLater(() -> {
							  display(strData);
						});
				  }
			} catch (Exception ex) {

				  stopClient();

			}

	  }

	  private void send(String message) {
			Thread thread = new Thread() {
				  @Override
				  public void run() {
						try {
							  OutputStream os = socket.getOutputStream();
							  byte[] byteArr = message.getBytes();
							  os.write(byteArr);
							  os.flush();
							  

						} catch (IOException ex) {
							  try {
									socket.close();
							  } catch (IOException ex1) {
							  }
							  stopClient();
						}
				  }

			};
			thread.start();
			
	  }
}
