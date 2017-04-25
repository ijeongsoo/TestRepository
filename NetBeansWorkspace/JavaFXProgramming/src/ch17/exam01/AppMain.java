/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam01;

import java.util.Map;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 *
 * @author ijeongsu
 */
public class AppMain extends Application{

    
    public AppMain(){
        System.out.println("Constructor");
    }

    @Override
    public void init() throws Exception {
        System.out.println("init"); //To change body of generated methods, choose Tools | Templates.
        Parameters prams =getParameters();
        /*List<String> list = prams.getRaw();
        for (String param : list){
            System.out.println(param);
        }*/
        
        Map<String, String> map = prams.getNamed();
        String ip = map.get("ip");
        String port = map.get("port");
        
        System.out.println(ip+" "+port);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(Thread.currentThread().getName());
        stage.show();
        
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop");//To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        launch(args);
        Platform.exit();
    }
    
}
