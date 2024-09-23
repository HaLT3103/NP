
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Bt1{
    public static void main(String[] args){
        String ip = "172.188.19.218";
        int port = 1606;
        int timeout = 5000;

        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress(ip, port), timeout);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String message = "B21DCCN310ABCDEF";
            bw.write(message);
            bw.newLine();
            bw.flush();

            String receive = br.readLine();
            if(receive != null){
                System.out.println(receive);
                String fix = receive.replaceAll("[aeiou]", "");
                bw.write(fix);
                bw.newLine();
                bw.flush();
            }

            socket.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}