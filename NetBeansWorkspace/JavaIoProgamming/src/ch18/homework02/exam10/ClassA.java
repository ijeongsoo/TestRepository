/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework02.exam10;

import java.io.Serializable;

/**
 *
 * @author ijeongsu
 */
public class ClassA implements Serializable{
    int field1;
    ClassB field2 = new ClassB();
    static int field3;
    transient int field4;
    
}
