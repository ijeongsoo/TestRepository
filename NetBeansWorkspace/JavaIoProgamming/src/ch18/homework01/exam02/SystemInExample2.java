/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 * @author ijeongsu
 */
public class SystemInExample2 {
    public static void main(String[] args) throws IOException {
        //System.in 필드에 있는 InputStream 객체를 받아옴
        InputStream is = System.in;
        
        //입력받은 값들을 저장할 byte배열 생성
        byte[] data = new byte[100];
        
        System.out.print("이름:");
        
        //값을 입력받아 data배열에 저장 하고 갯수를 반환
        int nameBytes=is.read(data);
        
        //라인피드는 문자열로 변경하지 않기 위해 -1
        String name = new String(data, 0, nameBytes-1);
        
        System.out.print("하고싶은 말:");
        
        //값을 입력받아 data배열의 처음부터 다시 저장하고 갯수를 반환
        int commentBytes=is.read(data);
        
        //입력받은 것중 라인피드를 제외한 바이트를 문자열로 변환
        String comment = new String(data, 0, commentBytes-1);
        
        //값 출력
        System.out.println("입력한 이름:"+name);
        System.out.println("입력한 하고 싶은 말:"+comment);
        
    }
}
