/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam25.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *
 * @author ijeongsu
 */
public class ServerExample1 {
    public static void main(String[] args){
        
        ServerSocket serverSocket=null;
        
        try{
            //서버소켓 생성
            serverSocket= new ServerSocket();
            //포트와 바인딩 
            serverSocket.bind(new InetSocketAddress(50001));
            //연결 기다리기 
            Socket socket =serverSocket.accept();
            //클라이언트 정보 얻기
            InetSocketAddress isa =(InetSocketAddress)socket.getRemoteSocketAddress();
            System.out.println(isa.toString());
            System.out.println(isa.getHostName());
            //통신하기
            
            //연결끊기
            socket.close();
            
        }catch(IOException ex){
            //서버소켓 닫기
            ex.printStackTrace();
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
