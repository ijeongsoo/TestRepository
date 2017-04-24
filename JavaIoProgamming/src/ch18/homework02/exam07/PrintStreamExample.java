/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author ijeongsu
 */
public class PrintStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //파일 아웃풋 스트림, 프린터보조 스트림 객체 생성
        FileOutputStream fos = new FileOutputStream("src/ch18/homework02/exam07/test.txt");
        PrintStream ps = new PrintStream(fos);
        
        //출력
        ps.println("[프린터 보조 스트림]");
        ps.print("마치 ");
        ps.println("프린터가 출력하는 것처럼 ");
        ps.println("데이터를 출력합니다");
        
        ps.flush();
        ps.close();
        fos.close();
    }
}
