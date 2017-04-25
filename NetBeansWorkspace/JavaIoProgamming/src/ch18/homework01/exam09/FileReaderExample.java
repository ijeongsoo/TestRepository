/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class FileReaderExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //경로를 설정하여 파일리더 객체 생성
        FileReader fileReader =new FileReader("src/ch18/homework01/exam09/FileReaderExample.java");
        
        //읽은 문자값 갯수를 저장할 int변수 선언
        int readCharNo;
        //읽은 문자를 저장할 char배열 선언
        char[] cbuf= new char[100];
        //읽은 값이 없을때까지 반복하여 char배열에 저장
        while((readCharNo=fileReader.read(cbuf))!=-1){
            //읽은 만큼만 문자열로 변환
            String str=new String(cbuf, 0, readCharNo);
            System.out.print(str);
        }
        fileReader.close();
    }
}
