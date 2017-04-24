/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author ijeongsu
 */
public class SerializableWriter {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //파일 아웃풋 스트림, 오브젝트 아웃풋 보조 스트림 생성
        FileOutputStream fos =new FileOutputStream("src/ch18/homework02/exam10/test.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        //객체 생성
        ClassA classA=new ClassA();
        
        //객체 값입력
        classA.field1=1;
        classA.field2.field1=2;
        classA.field3 =3;
        classA.field4=4;
        
        //객체 출력
        oos.writeObject(classA);
        oos.flush();
        fos.flush();
        oos.close();
        fos.close();
    }
}
