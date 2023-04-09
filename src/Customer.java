import java.util.ArrayList;

public class Customer extends User {
    private String messageFileName;
    private ArrayList<String> blockedSellers;
    public Customer(String name, String password, String email) {
        super(name, password, email);
        this.blockedSellers = new ArrayList<String>();
    }
}
