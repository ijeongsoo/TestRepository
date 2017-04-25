/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam01;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author ijeongsu
 */
public class SystemInExample1 {
    public static void main(String[] args) throws IOException {
        System.out.println("== 메뉴 ==");
        System.out.println("1.예금 조회");
        System.out.println("2.예금 출금");
        System.out.println("3.예금 입금");
        System.out.println("4.종료 하기");
        System.out.print("메뉴를 선택하세요:");
        //System.in 필드에 있는 InputStream 객체를 받아옴
        InputStream is = System.in;
        
        //한바이트를 입력받아 char형 변수에 넣음
        char inputChar =(char)is.read();
        
        //입력받은 문자에 따라 조건 실행
        switch(inputChar){
            case '1':
                System.out.println("예금 조회를 선택하셨습니다.");
                break;
            case '2':
                System.out.println("예금 출금을 선택하셨습니다.");
                break;
            case '3':
                System.out.println("예금 입금을 선택하셨습니다.");
                break;
            case '4':
                System.out.println("종료 하기를 선택하셨습니다.");
                break;
        }
    }
}
