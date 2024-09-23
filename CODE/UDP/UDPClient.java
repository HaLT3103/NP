package org.example.upd;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket client = new DatagramSocket();
        // send packet
        byte[] data = new byte[1024];
        data = "Hello from UDP client".getBytes();
        DatagramPacket dpSend = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 1107);
        client.send(dpSend);
        System.out.println("Client send success!");

        // receive packet
        byte[] buf = new byte[1024];
        DatagramPacket dbResponse = new DatagramPacket(buf, buf.length);
        client.receive(dbResponse);
        String strReverse = new String(dbResponse.getData()).trim();
        System.out.println(strReverse);

    }
}
