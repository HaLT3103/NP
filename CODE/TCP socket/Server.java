import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1108);
        System.out.println(server);

        while (true) {
            Socket conn = server.accept();
            System.out.println(conn);
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            int a = dis.readInt();
            System.out.println("a = " + a);
            int b = dis.readInt();
            System.out.println("b = " + b);
            System.out.println("a + b = " + (a+b));

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeInt(a + b);

            dos.close();
            dis.close();
            conn.close();
        }
    }
}

