/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam23;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author ijeongsu
 */
public class ObjectOutputExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("src/ch18/exam23/object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        
        VVIP vvip = new VVIP(1,"A","감자바", 30);
        oos.writeObject(vvip);
        
        
        
        
        
        oos.flush();
        fos.flush();
        oos.close();
        fos.close();
        
    }
}
