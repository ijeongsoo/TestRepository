/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class FileOutputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //복사할 사진 경로와 복사될 경로를 지정
        String file="src/ch18/homework01/exam08/Picture.jpg";
        String target="src/ch18/homework01/exam08/Picture2.jpg";
        
        //Input, Output스트림 객체 생성
        FileOutputStream fos = new FileOutputStream(target);
        FileInputStream fis = new FileInputStream(file);
        
        //읽어온 바이트 수를 저장할 int 변수 선언 및 초기화
        int byteNum=-1;
        //바이트를 읽어 넣을 바이트 배열 선언
        byte[] byteArr=new byte[1024];
        
        while(true){
            //바이트 배열 크기만큼 읽어서 배열에 넣고 넣은 갯수 리턴
            byteNum=fis.read(byteArr);
            //더이상 읽을것이 없으면 반복 종료
            if(byteNum==-1) break;
            //읽어온 바이트 갯수만큼 배열에 있는 값을 복사
            fos.write(byteArr, 0, byteNum);
            
        }
        
        fos.flush();
        fos.close();
        fis.close();
        
        System.out.println("복사가 완료 되었습니다.");
      
        
        
    }
}
