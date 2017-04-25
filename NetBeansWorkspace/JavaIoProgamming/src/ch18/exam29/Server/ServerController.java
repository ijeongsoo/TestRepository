/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam29.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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

	  public static ServerController instance;
	  @FXML
	  private Button btnStartSop;
	  @FXML
	  private TextArea txtDisplay;

	  private ExecutorService executorService;
	  private ServerSocket serverSocket;
	  private List<Client> connections = new Vector<Client>();

	  /**
	   * Initializes the controller class.
	   */
	  @Override
	  public void initialize(URL url, ResourceBundle rb) {
			ServerController.instance = this;
			btnStartSop.setOnAction((event) -> {
				  handleBtnStartStop(event);
			});

	  }

	  private void handleBtnStartStop(ActionEvent event) {
			if (btnStartSop.getText().equals("시작")) {
				  startServer();
			} else if (btnStartSop.getText().equals("멈춤")) {
				  stopServer();
			}
	  }

	  private void startServer() {
			//스레드풀 생성 
			executorService = Executors.newFixedThreadPool(100);
			try {
				  //서버소켓 생성
				  serverSocket = new ServerSocket();
				  serverSocket.bind(new InetSocketAddress("192.168.3.51", 50001));

			} catch (IOException ex) {
				  stopServer();
				  return;
			}

			//연결 수락작업 정의
			Runnable acceptTask = () -> {
				  //UI변경 내용
				  Platform.runLater(() -> {
						btnStartSop.setText("멈춤");
						disPlay("System : 서버시작");
				  });

				  while (true) {
						//수락코드 
						try {
							  Socket socket = serverSocket.accept();
							  //연결 클라이언트 정보 획득
							  String clientInfo = "[연결수락 :" + socket.getRemoteSocketAddress() + "]";
							  Platform.runLater(() -> {
									disPlay(clientInfo);
							  });
							  //통신용 클라이언트 객체 생성 
							  Client client = new Client(socket);
							  //벡터에 클라이언트 저장
							  connections.add(client);
							  //총 클라이언트 수 출력
							  Platform.runLater(() -> {
									disPlay("[연결 개수:" + connections.size() + "]");
							  });

						} catch (IOException ex) {
							  stopServer();
							  break;
						}
				  }
			};

			//스레드풀의 작업 큐에 넣기 
			executorService.submit(acceptTask);

	  }

	  public void stopServer() {
			try {
//				  for(Client client : connections){
//						client.socket.close();
//				  }
//				  connections.clear();
				  Iterator<Client> iterator = connections.iterator();
				  while(iterator.hasNext()){
						Client client = iterator.next();
						client.socket.close();
						iterator.remove();
				  }
				  
				  executorService.shutdownNow();
				  serverSocket.close();
				  
			} catch (IOException ex) {
				  Platform.runLater(() -> {
						btnStartSop.setText("시작");
						disPlay("System : 서버멈춤");
				  });
			}

	  }

	  private void disPlay(String text) {
			txtDisplay.appendText(text + "\n");
	  }

	  class Client {

			Socket socket;

			public Client(Socket socket) {
				  this.socket = socket;
				  recieve();

			}

			void recieve() {
				  //받기 작업 정의 
				  Runnable receiveTask = () -> {
						try {
							  while (true) {
									InputStream is = socket.getInputStream();
									byte[] byteArr = new byte[100];
									int readBytes = is.read(byteArr);

									if (readBytes == -1) {
										  throw new Exception();
									}
									String strData = new String(byteArr, 0, readBytes);
									for(Client client : connections){
										  client.send(strData);
									}
							  }
						} catch (Exception ex) {
							  try {
									String clientInfo = "[연결끊김 :" + socket.getRemoteSocketAddress() + "]";
									Platform.runLater(() -> {
										  disPlay(clientInfo);
									});
									this.socket.close();
									connections.remove(Client.this);
									Platform.runLater(() -> {
										  disPlay("[연결 개수:" + connections.size() + "]");
									});

							  } catch (IOException e) {
							  }

						}

				  };
				  //스레드풀의 작업큐에 작업 넣기 
				  executorService.submit(receiveTask);
			}

			void send(String message) {
				  try {
						OutputStream os = socket.getOutputStream();
						byte[] byteArr = message.getBytes();
						os.write(byteArr);
						os.flush();
						
				  } catch (IOException ex) {
						connections.remove(Client.this);
						try {
							  socket.close();
						} catch (IOException ex1) {
						}
				  }
				  

			}

	  }

}
