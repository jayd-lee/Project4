// Server
import java.io.*;
import java.net.*;

public class chatServer {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(1201);
        Socket s = ss.accept();

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msgin="", msgout = "";

        while(!msgin.equals("end")) {
            msgin = din.readUTF();
            System.out.println(msgin);
            msgout = "Server: " + br.readLine();
            dout.writeUTF(msgout);
            dout.flush();
        }
        s.close();
    }
}