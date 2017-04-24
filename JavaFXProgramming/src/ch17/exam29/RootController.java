/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam29;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class RootController implements Initializable {

    private Stage primaryStage;
    @FXML
    private Button handleCustom;

    /**
     * Initializes the controller class.
     */
    
    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // TODO
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleOpenFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(primaryStage);
        if(file!=null)
            System.out.println(file.getPath());
        else{}
    }

    @FXML
    private void handleSaveFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(((Button) event.getSource()).getScene().getWindow());
        if(file!=null)
            System.out.println(file.getPath());
        else{}
    }

    @FXML
    private void handleDirectoryChooser(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(((Button) event.getSource()).getScene().getWindow());
        if(file!=null)
            System.out.println(file.getPath());
        else{}
    }

    @FXML
    private void hendlePopUp(ActionEvent event) throws IOException {
        //showNotification("알림", "메시지가 도착했습니다");
        showNotification("경고", "도둑이 침입했습니다");
        
    }
    
    private void showNotification(String type, String message) throws IOException{
        Popup popup = new Popup();
        HBox hbox = FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imgMessage = (ImageView)hbox.lookup("#imgMessage");
        Label lblMessage = (Label)hbox.lookup("#lblMessage");
        
        if(type.equals("알림")){
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        }else if(type.equals("경고")){
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));
        }
        lblMessage.setText(message);
        popup.getContent().add(hbox);
        //popup.setAutoHide(true);
        popup.show(primaryStage);
    }

    @FXML
    private void handleCustom(ActionEvent event) throws IOException {
        showCustom("error", "확인 ㄲ?");
        showCustom("help", "확인 ㄲ?");

    }
    
    
    private void showCustom(String type, String message) throws IOException{
        Stage dialog = new Stage(StageStyle.TRANSPARENT);
        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));
        
        ImageView icon = (ImageView) parent.lookup("#icon");
        Label lblMessage = (Label) parent.lookup("#message");
        Button btnOk = (Button) parent.lookup("#btnOK");
        
        if(type.equals("error")){
             icon.setImage(new Image(getClass().getResource("images/dialog-error.png").toString()));

        }else if(type.equals("help")){
                         icon.setImage(new Image(getClass().getResource("images/dialog-help.png").toString()));

        }else if(type.equals("info")){
                         icon.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));

        }else if(type.equals("warning")){
                         icon.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));

        }
        lblMessage.setText(message);
        btnOk.setOnAction((event) -> {
            dialog.hide();
        });
               
        
        
        Scene scene =new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.initOwner(primaryStage);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setScene(scene);

        dialog.show();
    }
    
}
