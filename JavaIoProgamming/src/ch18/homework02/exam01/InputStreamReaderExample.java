/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author ijeongsu
 */
public class InputStreamReaderExample {
    public static void main(String[] args) throws IOException {
        //InputStream 객체 생성
        InputStream is = System.in;
        //바이트를 문자로 읽을수 있는 보조 스트림 생성
        Reader reader = new InputStreamReader(is);
        
        
        int readCharNo;
        char[] cbuf = new char[100];
        
        //-1일때까지(읽을게 없을 때) 버퍼에 입력된 내용 읽음
        while((readCharNo=reader.read(cbuf))!=-1){
            //읽은 만큼만 문자열로 변환
            String data = new String(cbuf, 0, readCharNo);
            System.out.println(data);
        }
        
        reader.close();
    }
}
