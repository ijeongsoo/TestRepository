/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam25.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ijeongsu
 */
public class ClientExample1 {
    public static void main(String[] args) {
        
        Socket socket=null;
        try {
            //how1
             //socket= new Socket("192.168.3.51", 50001);
             
             //how2
             //객체를 새로 생성을 하지 않고 메소드를 이용해서 연결하고 끊고가 가능하다 
             socket= new Socket();
             socket.connect(new InetSocketAddress("192.168.3.35", 50001));
             
             /*String str =null;
             str.length();*/
             
             
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        /*if(!socket.isClosed()){
            try {
                socket.close();
            } catch (IOException ex) {
            
            }
        }*/
    }
}
