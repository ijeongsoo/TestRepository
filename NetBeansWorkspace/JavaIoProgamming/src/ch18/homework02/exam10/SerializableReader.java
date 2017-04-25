/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author ijeongsu
 */
public class SerializableReader {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //파일 인풋 스트림 객체, 오브젝트 인풋 보조 스트림 객체 생성
        FileInputStream fis = new FileInputStream("src/ch18/homework02/exam10/test.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        //읽어온 객체를 형변환
        ClassA v = (ClassA)ois.readObject();
        System.out.println("field1:"+v.field1);
        System.out.println("field2.field1:"+v.field2.field1);
        System.out.println("field3:"+v.field3);
        System.out.println("field4:"+v.field4);
        
        ois.close();
        fis.close();
    }
}
