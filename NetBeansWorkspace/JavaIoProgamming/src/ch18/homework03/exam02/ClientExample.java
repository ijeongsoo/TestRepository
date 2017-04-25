/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework03.exam02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ijeongsu
 */
public class ClientExample {
    public static void main(String[] args) {
        Socket socket = null;
        try{
            socket = new Socket();
            System.out.println("[연결요청]");
            socket.connect(new InetSocketAddress("localhost",5001));
            System.out.println("[연결성공]");
        }catch(Exception e){}
        
        if(!socket.isClosed()){
            try {
                socket.close();
            } catch (IOException ex) {
            }
        }
    }
}
