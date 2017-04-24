/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam23;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author ijeongsu
 */
public class VVIP extends Person implements Serializable{
    private int memberShipNo;
    private String grade;
    
    public VVIP(){
        
    }
    
    public VVIP(int memberShipNo, String grade ,String name, int age) {
        super(name, age);
        this.memberShipNo=memberShipNo;
        this.grade=grade;
        
    }

    public int getMemberShipNo() {
        return memberShipNo;
    }

    public void setMemberShipNo(int memberShipNo) {
        this.memberShipNo = memberShipNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
    
    public void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException{
        
        out.writeUTF(getName());
        out.writeInt(getAge());
        out.defaultWriteObject();
        
    }
    
    
    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        setName(in.readUTF());
        setAge(in.readInt());
        in.defaultReadObject();
    }
    
}
