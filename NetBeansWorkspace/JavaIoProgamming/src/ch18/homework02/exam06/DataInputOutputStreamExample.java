/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class DataInputOutputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //파일 아웃풋 스트림, 데이터 아웃풋 보조 스트림 생성
         FileOutputStream fos =new FileOutputStream("src/ch18/homework02/exam06/test.dat");
         DataOutputStream dos =new DataOutputStream(fos);
         
         //값 출력
         dos.writeUTF("홍길동");
         dos.writeDouble(95.5);
         dos.writeInt(1);
         
         dos.writeUTF("김자바");
         dos.writeDouble(90.1);
         dos.writeInt(2);
         
         dos.flush();
         dos.close();
         fos.close();
         
         //파일 인풋 스트림, 데이터 인풋 보조 스트림 생성
         FileInputStream fis = new FileInputStream("src/ch18/homework02/exam06/test.dat");
         DataInputStream dis = new DataInputStream(fis);
         //2번 반복하여 값 읽음
         for(int i=0; i<2; i++){
             String name=dis.readUTF();
             Double score=dis.readDouble();
             int order=dis.readInt();
             System.out.println(name+":"+score+":"+order);
         }
         dis.close();
         fis.close();
    }
   
}
