/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework04.confirm02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author ijeongsu
 */
public class ClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 50002);
        OutputStream os = socket.getOutputStream();
        
        String filePath="src/ch18/homework04/confirm02/Picture.jpg";
        File file = new File(filePath);
        
        String fileName = file.getName();
        byte[] data = new byte[100];
        data = fileName.getBytes();
        os.write(data);
        
        System.out.println("[파일 보내기 시작"+fileName);
        InputStream is = new FileInputStream(filePath);
        while(true){
            int contentsData = is.read();
            if(contentsData == -1) break;
            os.write(contentsData);
        }
        
        os.flush();
        System.out.println("[파일 보내기 완료]");
        
        is.close();
        os.close();
        socket.close();
        
    }
}
