/**
 * User.java
 *
 * Stores the name, password, and email of the person logging into the system
 *
 * @author Dhanush Manjunath, Aadi Gupta, Jayden Lee, Kylie Houston, LE2
 *
 * @version 4/10/23
 *
 */
public class User {
    private String name;
    private String password;
    private String email;
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
