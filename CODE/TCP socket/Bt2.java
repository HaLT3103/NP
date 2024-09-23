
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Bt2 {
    public static void main(String[] args) throws IOException {
        String ip = "172.188.19.218";
        int port = 1605;
        int timeout = 5000;

        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress(ip, port), timeout);
            // Socket socket = new Socket("localhost", 1605);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = "B21DCCN310;ABCDEF";
            dos.writeUTF(message);
            dos.flush();

            int a = dis.readInt();
            int b = dis.readInt();

            dos.write(a + b);
            dos.write(a * b);

            socket.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
