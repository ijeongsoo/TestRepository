/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author ijeongsu
 */
public class SerialVersionUIDExample1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //파일 아웃풋 스트림 , 오브젝트 아웃풋 보조 스트림 생성
        FileOutputStream fos = new FileOutputStream("src/ch18/homework02/exam11/test.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        //클래스 생성 및 필드값 입력
        ClassC classC = new ClassC();
        classC.field1=1;
        
        //객체 출력
        oos.writeObject(classC);
        oos.flush();
        oos.close();
        fos.close();
    }
}
