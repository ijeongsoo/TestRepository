/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam12;

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
public class NonSerializableParentExample {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //파일 아웃풋 스트림 객체 , 오브젝트아웃풋 보조 스트림 객체 생성
        FileOutputStream fos = new FileOutputStream("src/ch18/homework02/exam12/test.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        //Child 객체 생성 및 필드값 입력
        Child child = new Child();
        child.field1="홍길동";
        child.field2="홍삼원";
        //객체 출력
        oos.writeObject(child);
        
        oos.flush();
        oos.close();
        fos.close();
        //파일 인풋 스트림 객체, 오브젝트인풋 보조 스트림 객체 생성
        FileInputStream fis = new FileInputStream("src/ch18/homework02/exam12/test.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //객체 입력
        Child v = (Child)ois.readObject();
        System.out.println("field1:"+v.field1);
        System.out.println("field2:"+v.field2);
        ois.close();
        fis.close();
    }
    
    
    
}
