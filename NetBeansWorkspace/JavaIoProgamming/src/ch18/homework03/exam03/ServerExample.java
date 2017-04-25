/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework03.exam03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
            serverSocket =new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 50001));
            while(true){
                System.out.println("[연결 기다림]");
                Socket socket =serverSocket.accept();
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("[연결 수락함]"+isa.getHostName());
                
                byte[] bytes =null;
                String message = null;
                
                InputStream is = socket.getInputStream();
                bytes=new byte[100];
                int readByteCount=is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("[데이터 받기 성공]"+message);
                
                OutputStream os = socket.getOutputStream();
                message="Hello Client";
                bytes=message.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("[데이터 보내기 성공]");
                
                is.close();
                os.close();
            }
        }catch(Exception e){}
        
        if(!serverSocket.isClosed()){
            try {
                serverSocket.close();
            } catch (IOException ex) {
            }
        }
    }
}
