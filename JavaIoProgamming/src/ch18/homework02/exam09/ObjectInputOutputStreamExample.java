/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ijeongsu
 */
public class ObjectInputOutputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //파일 아웃풋 스트림 객체, 오브젝트 아웃풋 보조 스트림 객체 생성
        FileOutputStream fos = new FileOutputStream("src/ch18/homework02/exam09/test.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        //객체 저장
        oos.writeObject(new Integer(10));
        oos.writeObject(new Double(3.14));
        oos.writeObject(new int[]{1,2,3});
        oos.writeObject(new String("홍길동"));
        
        oos.flush();
        oos.close();
        fos.close();
        
        //파일 인풋 스트림, 오브젝트 인풋 보조 스트림 객체 생성
        FileInputStream fis = new FileInputStream("src/ch18/homework02/exam09/test.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        //순서에 맞춰 출력
        Integer obj1=(Integer) ois.readObject();
        Double obj2=(Double) ois.readObject();
        int[] obj3=(int[]) ois.readObject();
        String obj4=(String) ois.readObject();
        
        ois.close();
        fis.close();
        
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3[0]+","+obj3[1]+","+obj3[2]);
        System.out.println(obj4);
        
    }
}
