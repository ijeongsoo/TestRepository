/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam04;

import java.io.Console;

/**
 *
 * @author ijeongsu
 */
public class ConsoleExample {
    public static void main(String[] args) {
        //콘솔 객체 생성
        Console console = System.console();
        
        System.out.println("아이디:");
        //콘솔에서 입력 받음
        String id = console.readLine();
        System.out.println("비밀번호 :");
        //콘솔에서 비밀번호 형태로 입력 받고 char배열에 저장
        char[] charPas = console.readPassword();
        //char배열을 문자열로 변환하여 저장
        String strPasswd = new String(charPas);
        
        System.out.println("-------------------");
        System.out.println(id);
        System.out.println(strPasswd);
    }
}
