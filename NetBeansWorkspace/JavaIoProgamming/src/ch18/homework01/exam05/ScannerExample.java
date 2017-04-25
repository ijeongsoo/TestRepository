/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam05;

import java.util.Scanner;

/**
 *
 * @author ijeongsu
 */
public class ScannerExample {
    public static void main(String[] args) {
        //스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("문자열 입력:");
        //엔터 질때까지 문자열 입력
        String inputString =scanner.nextLine();
        System.out.println(inputString);
        System.out.println();
        
        System.out.println("점수 입력 :");
        //숫자 입력
        int inputInt = scanner.nextInt();
        System.out.println(inputInt);
        System.out.println();
        
        System.out.println("실수 입력 :");
        //실수 입력
        double inputDouble = scanner.nextDouble();
        System.out.println(inputDouble);
        System.out.println();
    }
}
