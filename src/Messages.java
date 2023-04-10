import java.io.*;
import java.util.ArrayList;
/**
 * Messages.java
 *
 * Creates an ArrayList of all of the messages that are on the database
 *
 * @author Dhanush Manjunath, Aadi Gupta, Jayden Lee, Kylie Houston, LE2
 *
 * @version 4/10/23
 *
 */
public class Messages {
    private ArrayList<String> messages = new ArrayList<String>();
    public Messages() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("src/messages.txt")));
            String line = br.readLine();
            while (line != null) {
                messages.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getMessages() {
        return messages;
    }
    public void writeMessages(ArrayList<String> messagesNew) {
        try {
            FileWriter fw = new FileWriter("src/messages.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (String message : messagesNew) {
                pw.println(message);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
