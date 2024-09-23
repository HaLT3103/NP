import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 1108);
        System.out.println(socket);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        dos.writeInt(a);
        dos.writeInt(b);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int sum = dis.readInt();
        System.out.println(sum);

        dis.close();
        dos.close();
        socket.close();
    }
}

