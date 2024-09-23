package org.example.upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(1107);
        System.out.println("UDP Server is running...");
        while (true){
            byte[] buf = new byte[1024];
            // receive packet

            DatagramPacket dbReceive = new DatagramPacket(buf, buf.length);
            server.receive(dbReceive);
            String strReceive = new String(dbReceive.getData()).trim();
            System.out.println(strReceive);


            // send packet
            byte[] data = new byte[1024];
            int random =  (int)(Math.random() * 100);
            data = ("alanServer da nhan thong tin ket noi" + random).getBytes() ;
            DatagramPacket dpResponse = new DatagramPacket(data, data.length, dbReceive.getAddress(), dbReceive.getPort());
            server.send(dpResponse);
            System.out.println("Server send packet ..." + random);
        }
    }
}
