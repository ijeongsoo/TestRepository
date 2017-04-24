/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.homework04;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class RootController implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Slider slider;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnStop;
    
    private boolean endOfMedia;
    @FXML
    private Label lbTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Media media = new Media(getClass().getResource("media/video.m4v").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        
        mediaPlayer.setOnReady(() -> {
            btnPlay.setDisable(false);
            lbTime.setText(0*100d/100d+"/"+Math.round(mediaPlayer.getTotalDuration().toSeconds()*100d)/100d+"sec");

        });
        
        mediaPlayer.setOnPaused(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(false);
        });
        
        mediaPlayer.setOnStopped(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
        });
        
        mediaPlayer.setOnPlaying(() -> {
            btnPlay.setDisable(true);
            btnPause.setDisable(false);
            btnStop.setDisable(false);
        });
        
        mediaPlayer.setOnEndOfMedia(() -> {
            btnPlay.setDisable(false);
            btnPause.setDisable(true);
            btnStop.setDisable(true);
            endOfMedia =true;
        });
        
        btnPlay.setOnAction((event) -> {
           if(endOfMedia){
                mediaPlayer.stop();
                mediaPlayer.seek(mediaPlayer.getStartTime());
            }
            mediaPlayer.play();
            endOfMedia=false;

        });
        
        btnPause.setOnAction((event) -> {
            mediaPlayer.pause();
        });
        
        btnStop.setOnAction((event) -> {
            mediaPlayer.stop();
        });
        
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                /*if(slider.isPressed()){
                    double value = (newValue.doubleValue()/100.0)*mediaPlayer.getTotalDuration().toMillis();
                    mediaPlayer.seek(Duration.millis(value));
                    
                }*/
                
                double value = (newValue.doubleValue()/100.0)*mediaPlayer.getTotalDuration().toMillis();
                if(slider.isValueChanging()){
                    mediaPlayer.seek(Duration.millis(value));
                }else{
                    if(Math.abs(newValue.doubleValue()-oldValue.doubleValue())>0.5){
                        mediaPlayer.seek(Duration.millis(value));
                    }
                }
                //mediaPlayer.seek(Duration.millis(value));
            }
        });
        
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                double progress = (newValue.toMillis()/mediaPlayer.getTotalDuration().toMillis())*100.0;
                slider.setValue(progress);
                lbTime.setText(Math.round(newValue.toSeconds()*100d)/100d+"/"+Math.round(mediaPlayer.getTotalDuration().toSeconds()*100d)/100d+"sec");

            }
        });
        
        
        
        

            
        
        
        
    }    
    
}
