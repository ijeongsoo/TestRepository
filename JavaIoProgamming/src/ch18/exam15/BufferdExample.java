/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam15;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author ijeongsu
 */
public class BufferdExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam15/test.txt");
        byte[] data = "가나다".getBytes();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        
        long start = System.nanoTime();
        for(int i=0;i<1000; i++)
            os.write(data);
        long end =System.nanoTime();
        System.out.println(end-start);
        
        
        start = System.nanoTime();
        for(int i=0; i<1000; i++)
            bos.write(data);
        end =System.nanoTime();
        System.out.println(end-start);
        
        bos.flush();
        os.flush();
        os.close();
        bos.close();
        
    }
}
