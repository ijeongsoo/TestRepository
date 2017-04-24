/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.homework01.exam06;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ijeongsu
 */
public class FileExample {
    public static void main(String[] args) throws URISyntaxException, IOException {
        //경로를 지정하여 File객체 생성
        File dir = new File("/Users/ijeongsu/Desktop/Dir");
        File file1 = new File("/Users/ijeongsu/Desktop/file1.txt");
        File file2 = new File("/Users/ijeongsu/Desktop/file2.txt");
        //파일경로를 URI객체로 생성해서 매개값으로 제공
        File file3 = new File(new URI("file:///Users/ijeongsu/Desktop/file3.txt"));
        
        //존재하지 않으면 생성
        if(dir.exists()==false){
            dir.mkdirs();
        }
        
        if(file1.exists()==false){
            file1.createNewFile();
        }
        
        if(file2.exists()==false){
            file2.createNewFile();
        }
        
        if(file3.exists()==false){
            file3.createNewFile();
        }
        
        //디렉토리 를 경로로 하는 파일객체 생성
        File temp =new File("/Users/ijeongsu/Desktop");
        //데이터 포멧 객체 생성
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd  a  HH:mm");
        
        //하위 파일 및 디렉토리를 File객체 형태로 얻음
        File[] contents = temp.listFiles();
        
        System.out.println("날짜        시간      형태     크기    이름");
        System.out.println("--------------------------------------");
        for(File file:contents){
            //마지막 수정일 날짜를 포멧형식에 맞춰 출력
            System.out.println(sdf.format(new Date(file.lastModified())));
            //디렉토리면 디렉토리 이름 앞에 <DIR> 붙힘
            if(file.isDirectory()){
                System.out.println("\t<DIR>\t\t\t"+file.getName());
            //디렉토리 아니면 파일 크기와 이름 출력
            }else{
                System.out.println("\t\t\t"+file.length()+"\t"+file.getName());
                
            }
            System.out.println();
        }
        
    }
}
