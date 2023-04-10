import java.io.*;
import java.net.*;

public class chatClient {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket("127.0.0.1",1201);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msgin="", msgout="";
        while(!msgin.equals("end")){
            msgout = "Client: " + br.readLine();
            dout.writeUTF(msgout);
            msgin = din.readUTF();
            System.out.println(msgin);
        }

    }
}