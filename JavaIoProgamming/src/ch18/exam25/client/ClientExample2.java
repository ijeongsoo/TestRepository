/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam25.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author ijeongsu
 */
public class ClientExample2 {
    public static void main(String[] args) {
        
        Socket socket=null;
        try {
            //소켓 생성
             socket= new Socket();
             //연결 요청
             
                 socket.connect(new InetSocketAddress("192.168.3.51", 50001));
                 
                 //통신하기 
                
                     OutputStream os = socket.getOutputStream();




                     String strData ="이정수";
                     byte[] data =strData.getBytes();

                     os.write(data);
                     os.flush();
                     System.out.println("데이터 보내기 성공");

        //os.close();

                    /* InputStream is = socket.getInputStream();

                    int readBytes=-1;
                    data = new byte[100];
                    readBytes = is.read(data);
                    strData = new String(data, 0, readBytes);
                    System.out.println("받은 데이터 :"+strData);*/
                     
             
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        if(!socket.isClosed()){
            try {
                socket.close();
            } catch (IOException ex) {
            
            }
        }
    }
}
