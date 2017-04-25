/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam25.server;

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
public class ServerExample2 {
    public static void main(String[] args){
        
        ServerSocket serverSocket=null;
        
        try{
            //서버소켓 생성
            serverSocket= new ServerSocket();
            //포트와 바인딩 
            serverSocket.bind(new InetSocketAddress(50001));
            //연결 기다리기 
            while(true){
                Socket socket =serverSocket.accept();
                //클라이언트 정보 얻기
                InetSocketAddress isa =(InetSocketAddress)socket.getRemoteSocketAddress();
                System.out.println(isa.toString());
                System.out.println(isa.getHostName());
                //통신하기
               /* InputStream is =socket.getInputStream();

                byte[] data = new byte[100];
                int readBytes = is.read(data);
                System.out.println(readBytes);
                if(readBytes ==-1){
                    throw new IOException("클라이언트가 정상 종료되었습니다");
                }
                String strData = new String(data, 0, readBytes);
                System.out.println("받은 데이터 : "+strData);
            
            
            
            

                OutputStream os =socket.getOutputStream();
                 data =strData.getBytes();

                 os.write(data);
                 os.flush();
                 System.out.println("데이터 보내기 성공");

                */
                //연결끊기
                socket.close();
            }
            
        }catch(IOException ex){
            //서버소켓 닫기
            System.out.println(ex.getMessage());
        }
        
        
        //서버 소켓이 5001번을 현재 사용하고 있느냐 ?
        if(serverSocket!=null && !serverSocket.isClosed()){
            //서버소켓 닫기(포트 50001번을 해제한다 
            try {
              serverSocket.close();
            } catch (IOException ex1) {

            }
        }
    }
}
