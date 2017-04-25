/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam26;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ijeongsu
 */
public class ExecuteExample {
    public static void main(String[] args) throws IOException {
        //스레드풀 생성
        ExecutorService es = Executors.newFixedThreadPool(2);
        
        
        for(int i=0; i<1000; i++){
        //작업생성코드 
            Runnable task=()->{
                System.out.println(Thread.currentThread().getName()+"작업처리");
            };

            //작업처리지시(작업큐에 넣기)
            es.submit(task);
        }
        
        
        //스레드풀 종료
        System.in.read();
        es.shutdown();
    }
    
    
}
