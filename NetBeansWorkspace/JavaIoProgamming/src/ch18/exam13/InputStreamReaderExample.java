/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author ijeongsu
 */
public class InputStreamReaderExample {
    public static void main(String[] args) throws IOException {
        /*InputStream is = System.in;
        
        Reader reader = new InputStreamReader(is);
        
        int data = reader.read();
        System.out.println((char)data);*/
        
        
        InputStream is =new FileInputStream("src/ch18/exam13/test.txt");
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        int data = isr.read();
        System.out.println((char)data);
    }
}
