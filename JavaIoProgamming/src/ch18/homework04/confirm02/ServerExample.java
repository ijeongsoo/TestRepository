/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework04.confirm02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ijeongsu
 */
public class ServerExample {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket();
        serversocket.bind(new InetSocketAddress("localhost", 50002));
        
        System.out.println("[서버시작]");
        
        while(true){
            try{
                Socket socket = serversocket.accept();

                InputStream is = socket.getInputStream();

                byte [] bytes = new byte[100];
                int readByteCount =-1;

                readByteCount = is.read(bytes);
                String fileName = new String(bytes, 0, readByteCount);
                fileName = fileName.trim();

                System.out.println("[파일 받기 시작]");
                OutputStream os = new FileOutputStream("/Users/ijeongsu/Desktop/"+fileName);
                while(true){
                    readByteCount = is.read();
                    if(readByteCount ==-1)
                        break;
                    os.write(readByteCount);
                }
                System.out.println("[파일 받기 완료]");
                os.close();
                is.close();
                socket.close();
            }catch(Exception e){
                break;
            }  
        }
        serversocket.close();
        System.out.println("[서버 종료]");
    }
}
