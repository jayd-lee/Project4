import java.util.ArrayList;

public class Seller extends User {
    private String messageFileName;
    private ArrayList<String> stores;
    private ArrayList<String> blockedCustomers;
    public Seller(String name, String password, String email, String messageFileName) {
        super(name, password, email);
        this.messageFileName = messageFileName;
        this.stores = new ArrayList<String>();
        this.blockedCustomers = new ArrayList<String>();
    }
    public void addStore(String store) {
        this.stores.add(store);
    }
    public void removeStore(String store) {
        this.stores.remove(store);
    }
}


