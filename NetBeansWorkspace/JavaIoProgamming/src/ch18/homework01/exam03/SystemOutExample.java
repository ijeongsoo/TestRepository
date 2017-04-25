/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam03;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author ijeongsu
 */
public class SystemOutExample {
    public static void main(String[] args) throws IOException {
        //System.out 필드에 있는 OutputStream 객체를 받아옴
        OutputStream os = System.out;
        
        //48~58바이트 값을 콘솔에 출력
        for(byte b=48; b<58; b++){
            os.write(b);
        }
        //10바이트 값을 콘솔에 출력
        os.write(10);
        
        //97~123바이트 값을 콘솔에 출력
        for(byte b=97; b<123; b++){
            os.write(b);
        }
        
        //10바이트 값을 콘솔에 출력
        os.write(10);
        
        String hangul="가나다라마바사";
        
        //스트링을 바이트 배열형으로 반환
        byte[] hangulByte = hangul.getBytes();
        
        //바이트 배열값을 콘솔에 출력
        os.write(hangulByte);
        
        //버퍼를 비우고 OutputStream 닫음
        os.flush();
        os.close();
    }
}
