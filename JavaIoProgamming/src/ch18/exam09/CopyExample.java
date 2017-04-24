/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


/**
 *
 * @author ijeongsu
 */
public class CopyExample {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        Reader reader = new FileReader("src/ch18/exam09/test.txt");
        Writer writer = new FileWriter("src/ch18/exam09/test2.txt");
        
        
        char[] data= new char[3];
        int readnum=-1;
        
        while(true){
            readnum=reader.read(data);
            if(readnum==-1) break;
            writer.write(data, 0, readnum);
            writer.flush();
        }
        
        reader.close();
        writer.close();
    
    }
}
