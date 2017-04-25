/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ijeongsu
 */
public class ServerExample {
    public static void main(String[] args) {
        ServerSocket serverSocket =null;
        try{
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost",5001));
            while(true){
                System.out.println("[연결 기다림]");
                Socket socket =serverSocket.accept();
                InetSocketAddress isa =(InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("[연결 수락함"+ isa.getHostName());
            }
        }catch(Exception e){}
        
        if(!serverSocket.isClosed()){
            try {
                serverSocket.close();
            } catch (IOException ex) {}
        }
    }
}
