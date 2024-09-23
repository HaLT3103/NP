
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerBt2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket server = new ServerSocket(1065);
        while(true){
            Socket con = server.accept();
            System.out.println(con);
            DataInputStream dis = new DataInputStream(con.getInputStream());
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            
            dos.writeInt(5);
            dos.writeInt(10);

            String receive = dis.readUTF();
            System.out.println(receive);
        }
    }
}
