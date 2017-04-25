/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        //경로를 지정하여 파일객체 생성
        File file =new File("src/ch18/homework01/exam10/test.txt");
        //파일 객체를 대상으로 하는 writer 객체 생성 하는데 이때 append가 가능하도록 생성
        FileWriter fw = new FileWriter(file, true);
        
        //문자열 전달
        fw.write("FileWriter는 한글로된 "+"\r\n");
        fw.write("문자열을 바로 출력할 수 있다."+"\r\n");
        //버퍼 비우기
        fw.flush();
        fw.close();
        System.out.println("파일에 정장되었습니다");
    }
}
