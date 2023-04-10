import java.util.ArrayList;
import java.io.*;
/**
 * Seller.java
 *
 * Creates an ArrayList of all the sellers that are on the database
 *
 * @author Dhanush Manjunath, Aadi Gupta, Jayden Lee, Kylie Houston, LE2
 *
 * @version 4/10/23
 *
 */
public class Seller {
    private ArrayList<String> sellers = new ArrayList<String>();
    public Seller() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("src/seller.txt")));
            String line = br.readLine();
            while (line != null) {
                String[] details = line.split(",");
                String name = details[0].trim();
                sellers.add(name);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getSeller() {
        return sellers;
    }
}

