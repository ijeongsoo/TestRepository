/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam16;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author ijeongsu
 */
public class BufferdExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam15/test.txt");
        OutputStreamWriter osw=new OutputStreamWriter(os);
        BufferedWriter bos = new BufferedWriter(osw);
        
        long start = System.nanoTime();
        for(int i=0;i<1000; i++)
            osw.write("가나다");
        long end =System.nanoTime();
        System.out.println(end-start);
        
        
        start = System.nanoTime();
        for(int i=0; i<1000; i++)
            bos.write("가나다");
        end =System.nanoTime();
        System.out.println(end-start);
        
        
        bos.flush();
        osw.flush();
        os.flush();
        
        bos.close();
        osw.close();
        os.close();
        
    }
}
