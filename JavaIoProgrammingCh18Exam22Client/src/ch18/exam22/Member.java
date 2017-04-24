/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam22;

import java.io.Serializable;

/**
 *
 * @author ijeongsu
 */
public class Member implements Serializable{
    //Field
    private String Mname;
    private int age;
    private static final long serialVersionUID=1;
    //constructor
    
    //Method

    public Member(String Mname, int age) {
        this.Mname = Mname;
        this.age = age;
    }

    public String getMname() {
        return Mname;
    }

    public int getAge() {
        return age;
    }

    public void setMname(String Mname) {
        this.Mname = Mname;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

}
