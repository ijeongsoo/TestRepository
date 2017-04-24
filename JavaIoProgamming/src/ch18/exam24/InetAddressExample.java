/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam24;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author ijeongsu
 */
public class InetAddressExample {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia=InetAddress.getLocalHost();
        
        
        String ipaddr = ia.getHostAddress();
        System.out.println("로컬:"+ipaddr);
        
        InetAddress iaNaver = InetAddress.getByName("naver.com");
        System.out.println(iaNaver.getHostAddress());
        
        InetAddress[] iaAddrArray =InetAddress.getAllByName("naver.com");
        for(InetAddress i:iaAddrArray){
            System.out.println(i.getHostAddress());
        }
    }
}
