/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author ijeongsu
 */
public class SerialVersionUIDExample2 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //파일 인풋 스트림 객체 , 오브젝트 인풋 보조 스트림 객체 생성
        FileInputStream fis = new FileInputStream("src/ch18/homework02/exam11/test.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        //classC 객체 입력
        ClassC classC =(ClassC) ois.readObject();
        System.out.println("field1:"+classC.field1);
        
        ois.close();
        fis.close();
        
    }
}
