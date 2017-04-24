/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam39;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class RootController implements Initializable {

  @FXML
  private ProgressBar progressBar;
  @FXML
  private Label label;
  @FXML
  private Label lblWorkDone;
  @FXML
  private Button btnStart;
  @FXML
  private Button btnStop;
  private Task<Integer> task;
  @FXML
  private Label lblResult;
  

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnStart.setOnAction((event) -> {
	handleBtnStart(event);
    });
    btnStop.setOnAction((event) -> {
	handleBtnStop(event);
    });
  }  

  private void handleBtnStart(ActionEvent e) {
    task = new Task<Integer>(){
	@Override
	protected Integer call() throws Exception {
	  int result =0;
	  for(int i=0; i<=100; i++){
	    result+=i;
	    //updateProgress(i, 100);
	    //updateMessage(String.valueOf(i));
	    double value=i;

	    Platform.runLater(() -> {
		progressBar.setProgress(value/100);
		lblWorkDone.setText(String.valueOf(value));
	    });
	    if(isCancelled()) return result;
	    try{Thread.sleep(100);}catch(Exception e){
		break;
	    }
	  }
  	  return result;
	}

	@Override
	protected void succeeded() {
	  lblResult.setText(getValue().toString());
	}

	@Override
	protected void cancelled() {
	  lblResult.setText("작업 취소됨");
	}

	@Override
	protected void failed() {
	}
	
	
	
    };
    
    //progressBar.progressProperty().bind(task.progressProperty());
    //lblWorkDone.textProperty().bind(task.messageProperty());
    
    Thread thread = new Thread(task);
    thread.setDaemon(true);
    
    thread.start();
  }

  private void handleBtnStop(ActionEvent e) {
    task.cancel();

  }
  
}
