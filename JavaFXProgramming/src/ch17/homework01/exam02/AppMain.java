/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.homework01.exam02;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author ijeongsu
 */
public class AppMain extends Application{

    public AppMain() {
        System.out.println(Thread.currentThread().getName()+":AppMain() 호출");
    }

    @Override
    public void init() throws Exception {
        System.out.println(Thread.currentThread().getName()+":init() 호출");

    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Thread.currentThread().getName()+":start() 호출");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println(Thread.currentThread().getName()+":stop() 호출");

    }
    
    
    
    
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+":main() 호출");

        launch(args);
    }
}
