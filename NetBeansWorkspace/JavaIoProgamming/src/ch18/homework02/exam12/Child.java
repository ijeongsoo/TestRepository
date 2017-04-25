/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author ijeongsu
 */
//부모 객체 상속 , Serializable 구현
public class Child extends Parent implements Serializable{
    public String field2;
    
    //writeObject() 구현
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.writeUTF(field1);
        out.defaultWriteObject();
    }
    
    //writeObject() 구현 
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        field1=in.readUTF();
        in.defaultReadObject();
    }
    
    
           
}
