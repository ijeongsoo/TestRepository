/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam07;

import java.io.FileInputStream;

/**
 *
 * @author ijeongsu
 */
public class FileInputStreamExample {
    public static void main(String[] args) {
        try{
            //경로를 매개변수로 한 인풋 스트림 객체 생성
            FileInputStream fis = new FileInputStream("src/ch18/homework01/exam07/FileInputStreamExample.java");
            //읽은 바이트 값을 저장할 int 변수 선언
            int data;
            /*while((data=fis.read())!=-1){
                System.out.write(data);
            }*/
            
            while(true){
                //한바이트씩 읽어옴
                data=fis.read();
                //읽은값이 없다면 반복문 종료
                if(data==-1) break;
                //바이트 값을 콘솔에 출력
                System.out.write(data);
            }
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
