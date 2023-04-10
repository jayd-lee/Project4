import java.util.Scanner;

/**
 * Tools.java
 *
 * This class is created to implement some of the other messages since it would clutter the Project4.java
 *
 * @author Dhanush Manjunath, Aadi Gupta, Jayden Lee, Kylie Houston, LE2
 *
 * @version 4/10/23
 *
 */
public class Tools {
    static Scanner scan = new Scanner(System.in);

    public static String username() {
        System.out.println("Enter your username: ");
        String username = scan.nextLine();
        return username;
    }

    public static String password() {
        System.out.println("Enter your password: ");
        String password = scan.nextLine();
        return password;
    }

    public static String email() {
        System.out.println("Enter your email: ");
        String email = scan.nextLine();
        return email;
    }


}
