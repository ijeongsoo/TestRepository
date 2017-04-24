/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class BufferedOutputStreamExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos=null;
        
        int data = -1;
        long start = 0;
        long end =0;
        
        //인풋스트림, 인풋버퍼 보조 스트림, 아웃풋 스트림 객체 생성
        fis = new FileInputStream("src/ch18/homework02/exam05/Picture.jpg");
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream("src/ch18/homework02/exam05/Picture2.jpg");
        
        //복사 하며 시간 측정
        start=System.nanoTime();
        while(true){
            data=bis.read();
            if(data==-1) break;
            fos.write(data);
        
            fos.flush();
        }
        end=System.nanoTime();
        
        System.out.println("사용하지 않았을때:"+(end-start));
        
        //아웃풋 버퍼 보조 스트림 객체 생성
        bos =new BufferedOutputStream(fos);
        
        //복사 하며 시간 측정(출력 버퍼 사용)
        start=System.nanoTime();
        while(true){
            data=bis.read();
            if(data==-1) break;
            bos.write(data);
        
            bos.flush();
        }
        end=System.nanoTime();
        System.out.println("사용했을 때:"+(end-start));
        
        bos.close();
        fos.close();
        bis.close();
        fis.close();
        
    }
}
