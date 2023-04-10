import java.util.ArrayList;
import java.io.*;
/**
 * Customer.java
 *
 * Creates an ArrayList of the customers that are entered into the database
 *
 * @author Dhanush Manjunath, Aadi Gupta, Jayden Lee, Kylie Houston, LE2
 *
 * @version 4/10/23
 *
 */
public class Customer {
    private ArrayList<String> customers = new ArrayList<String>();
    public Customer() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("src/customer.txt")));
            String line = br.readLine();
            while (line != null) {
                String[] details = line.split(",");
                String name = details[0].trim();
                customers.add(name);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getCustomers() {
        return customers;
    }
}
