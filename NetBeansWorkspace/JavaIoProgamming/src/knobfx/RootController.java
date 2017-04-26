/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knobfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class RootController implements Initializable {

	  @FXML
	  private Knob knob;

	  /**
	   * Initializes the controller class.
	   */
	  @Override
	  public void initialize(URL url, ResourceBundle rb) {
			knob.setOnMouseDragged((event) -> {
				  System.out.println(Math.atan2(225-event.getSceneY(),225-event.getSceneX())*180/Math.PI);
			  if((Math.atan2(225-event.getSceneY(),225-event.getSceneX())*180/Math.PI)>0)
				   knob.setValue(Math.atan2(225-event.getSceneY(),225-event.getSceneX())*180/Math.PI);
			  else if((Math.atan2(225-event.getSceneY(),225-event.getSceneX())*180/Math.PI)>-90)
					knob.setValue(0);
			else if((Math.atan2(225-event.getSceneY(),225-event.getSceneX())*180/Math.PI)<-90)
				  knob.setValue(180);
			});
	  }	  
	  
}
