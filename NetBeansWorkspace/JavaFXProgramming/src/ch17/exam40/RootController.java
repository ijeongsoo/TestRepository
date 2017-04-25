/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam40;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Service;
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
  private Label lblWorkDone;
  @FXML
  private Label lblResult;
  @FXML
  private Button btnStart;
  @FXML
  private Button btnStop;
  
  private TimeService timeService;
  
  

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

  private void handleBtnStop(ActionEvent event) {
    timeService.cancel();
  }

  private void handleBtnStart(ActionEvent event) {
    if(timeService==null){
	timeService = new TimeService();
	timeService.start();
    }else{
	timeService.restart();
    }
  }

 
  class TimeService extends Service<Integer>{

    @Override
    protected Task<Integer> createTask() {
	Task<Integer> task = new Task(){
	  @Override
	  protected Object call() throws Exception {
	   int sum =0;
	   for(int i=1; i<=100; i++){
	     if(isCancelled()) break;
	     try{Thread.sleep(100);}catch(Exception e){}
	     double value =i;
	     Platform.runLater(() -> {
		 progressBar.setProgress(value/100);
		 lblWorkDone.setText(String.valueOf(value));
	     });
	     sum+=i;
	   }
	   return sum;
	  }	  
	};
	return task;
    }

    
    @Override
    protected void succeeded() {
	lblResult.setText(getValue().toString());
    }
    
    
    
  }
  
  
}
