/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class CopyExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream is = new FileInputStream("src/ch18/exam12/Picture.jpg");
        FileOutputStream os= new FileOutputStream("src/ch18/exam12/Picture2.jpg");
    
        byte[] data = new byte[1024];
        int bytenum=-1;
        
        while(true){
            bytenum=is.read(data);
            if(bytenum==-1) break;
            os.write(data, 0, bytenum);
        }
        
        os.flush();
        os.close();
        is.close();
    
    }
}
