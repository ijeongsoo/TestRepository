/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author ijeongsu
 */
public class OutputStreamWriterExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //아웃풋 스트림 객체 생성 
        FileOutputStream fos = new FileOutputStream("src/ch18/homework02/exam02/test.txt");
        //아웃풋 스트림의 보조객체 생성
        Writer writer = new OutputStreamWriter(fos);
        
        String data = "이것은 테스트 입니다 ㅎㅎ";
        
        //문자열 출력
        writer.write(data);
        
        writer.flush();
        writer.close();
        fos.close();
    }
}
