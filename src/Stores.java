import java.io.*;
import java.util.ArrayList;
/**
 * Stores.java
 *
 * Creates an ArrayList of all of the stores that are on the database
 *
 * @author Dhanush Manjunath, Aadi Gupta, Jayden Lee, Kylie Houston, LE2
 *
 * @version 4/10/23
 *
 */
public class Stores {
    private ArrayList<String> stores = new ArrayList<String>();
    public Stores() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("src/stores.txt")));
            String line = br.readLine();
            while (line != null) {
                stores.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getStores() {
        return stores;
    }
    public void writeStores(ArrayList<String> storesNew) {
        try {
            FileWriter fw = new FileWriter("src/stores.txt");
            PrintWriter pw = new PrintWriter(fw);
            int size = (storesNew != null) ? storesNew.size() : 0;

            for (String store : storesNew) {
                pw.println(store);
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
