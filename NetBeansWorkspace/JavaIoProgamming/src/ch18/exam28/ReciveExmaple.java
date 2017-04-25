/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch18.exam28;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author ijeongsu
 */
public class ReciveExmaple {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket datagamSocket = new DatagramSocket(50002);
        
        byte[] data = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        datagamSocket.receive(datagramPacket);
        
        byte[] dara = datagramPacket.getData();
        int readBtes = datagramPacket.getLength();
        String str = new String(data, 0, readBtes);
        System.out.println("받은 데이터"+str);
        
        datagamSocket.close();
    }
}
