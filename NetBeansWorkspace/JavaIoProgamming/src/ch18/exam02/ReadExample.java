/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam02;

import ch18.exam01.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 * @author ijeongsu
 */
public class ReadExample {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String path=ReadExample.class.getResource("tset.txt").getPath();
        InputStream is= new FileInputStream(path);
        
        byte[] data = new byte[3];
        
        int readBytes =-1;
        String strData="";
        while(true){
            readBytes=is.read(data);
            if(readBytes==-1) break;
            System.out.println("읽은 바이트 수:"+readBytes);
            System.out.println("읽은 바이트 값:"+Arrays.toString(data));
            strData += new String(data, 0, readBytes);    
        }
        System.out.println("---------------------");
        System.out.println(strData);
        
        is.close();
        
    }
}
