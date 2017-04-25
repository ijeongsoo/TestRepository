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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ijeongsu
 */ 
public class ClientExample {
    public static void main(String[] args) {
        Socket socket =null;
        try{
            socket = new Socket();
            System.out.println("[연결요쳥]");
            socket.connect(new InetSocketAddress("localhost", 50001));
            System.out.println("[연결 성공]");
            
            byte[] bytes=null;
            String message =null;
            
            OutputStream os = socket.getOutputStream();
            message = "Hello Sever";
            bytes = message.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("[데이터 보내기 성공]");
            
            InputStream is = socket.getInputStream();
            bytes = new byte[100];
            
            int readByteCount=is.read(bytes);
            message= new String(bytes, 0, readByteCount, "UTF-8");
            System.out.println("[데이터 받기 성공]"+ message);
            
            os.close();
            is.close();
        }catch(Exception e){}
        
        if(!socket.isClosed()){
            try {
                socket.close();
            } catch (IOException ex) {
            }
        }
    }
}
