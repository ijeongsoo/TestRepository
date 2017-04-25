/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author ijeongsu
 */
public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
        //인풋 스트림 객체 생성
        InputStream is = System.in;
        //리더 보조객체 생성
        Reader reader= new InputStreamReader(is);
        //버퍼리더 보조객체 생성
        BufferedReader breader = new BufferedReader(reader);
        
        //라인을 만날때까지 버퍼에 담아 입력
        String str = breader.readLine();
        
        
        System.out.println("출력:"+str);
        
        breader.close();
        reader.close();
        is.close();
        
    }
}
