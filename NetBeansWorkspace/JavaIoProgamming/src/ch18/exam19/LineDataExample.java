/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam19;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author ijeongsu
 */
public class LineDataExample {
    public static void main(String[] args) throws IOException {
        FileWriter fw= new FileWriter("src/ch18/exam19/test.txt");
        fw.write("abcde\r\n");
        fw.write("12345\r\n");
        fw.write("가나다라마\r\n");
        fw.flush();
        fw.close();
        
        FileOutputStream fos = new FileOutputStream("src/ch18/exam19/test.txt");
        PrintStream out = new PrintStream(fos);
        out.println("abcde");
        out.println("12345");
        out.println("가나다라마");
        out.flush();
        fos.flush();
        out.close();
        fos.close();
        
        FileInputStream fis = new FileInputStream("src/ch18/exam19/test.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        while(true){
            String line=br.readLine();
            if(line==null) break;
            System.out.println(line);
            
        }
        br.close();
        isr.close();
        fis.close();
        
    }
}
