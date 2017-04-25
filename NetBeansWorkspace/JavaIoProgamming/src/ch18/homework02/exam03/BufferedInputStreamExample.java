/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam03;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class BufferedInputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //시간 측정 변수
        long start =0;
        long end =0;
        //파일 인풋 스트림 객체 생성
        FileInputStream fis = new FileInputStream("src/ch18/homework02/exam03/Picture.jpg");
        //시간 측정
        start=System.nanoTime();
        while(fis.read()!=-1){}
        end=System.nanoTime();
        System.out.println("사용하지 않았을때 :"+(end-start)+"ms");
        
        //보조 스트림 객체 생성
        BufferedInputStream bis= new BufferedInputStream(fis);
        //시간 측정
        start=System.nanoTime();
        //보조스트림으로 read
        while(bis.read()!=-1){}
        end=System.nanoTime();
        System.out.println("사용했을 때 :"+(end-start)+"ms");
        
        bis.close();
        fis.close();
    }
}
