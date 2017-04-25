/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author ijeongsu
 */
public class PrimitiveDataExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int value =10;
        
        OutputStream os = new FileOutputStream("src/ch18/exam18/test.dat");
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(value);
        
        
        dos.flush();
        os.flush();
        dos.close();
        os.close();
        
        InputStream is = new FileInputStream("src/ch18/exam18/test.dat");
        DataInputStream dis = new DataInputStream(is);
        
        int readValue = dis.readInt();
        System.out.println(readValue);
        
        dis.close();
        is.close();
    }
}
