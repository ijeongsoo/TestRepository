/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework04.confirm01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author ijeongsu
 */
public class AddLineNumberExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
         String filePath="src/ch18/homework04/confirm01/AddLineNumberExample.java";
    
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        int i=1;

        while(true){
            String str = br.readLine();
            if(str == null)
                break;
            System.out.println(i+": "+str);
            i++;
        }
       
        
    }
   
    
}
