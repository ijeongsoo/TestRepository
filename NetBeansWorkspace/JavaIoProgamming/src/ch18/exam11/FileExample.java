/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam11;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class FileExample {
    public static void main(String[] args) throws IOException {
        //파일 및 디렉토리 정보 얻기 
        File file=new File("src/ch18/exam11/FileExample.java");
        System.out.println(file.exists());
        System.out.println(file.length());
        System.out.println(file.isDirectory());
        
        File dir =new File("/");
        System.out.println(dir.exists());
        System.out.println(dir.length());
        System.out.println(dir.isDirectory());
        
        //String[] contents1 = dir.list();
        File[] fileArr = dir.listFiles();
        
        for(File filea : fileArr){
            String info="";
            info+=filea.getName();
            info += "\t";
            info+=(filea.isDirectory()?"<dir>":"");
            info+="\t";
            info+=filea.length();
            System.out.println(info);
        }
        
        //파일 및 디렉토리의 생성 및 삭제
        File file2 = new File("/Users/ijeongsu/Desktop/test.txt");
        file2.createNewFile();
        file2.delete();
        
        File dir2 = new File("/Users/ijeongsu/Desktop/dir2");
        dir2.mkdir();
        
        File dir3 = new File("/Users/ijeongsu/Desktop/dir3/dir4/dir5");
        dir3.mkdirs();
        
             
    }
}
