package ch18.exam22;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author ijeongsu
 */
public class ObjectInputExample {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/ijeongsu/Desktop/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        Member member = (Member)ois.readObject();
        
        System.out.println(member.getMname());
        System.out.println(member.getAge());
        
        ois.close();
        fis.close();
                
        
    }
}
