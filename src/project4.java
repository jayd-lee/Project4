import java.util.Scanner;

public class project4 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the chat app!");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        String choice = scan.nextLine();

        if (choice.equals("1")) {
            login();
        } else if (choice.equals("2")) {
            signup();
        } else if (choice.equals("3")) {
            System.exit(0);
        } else {
            System.out.println("Thanks for using the chat app!");
            return;
        }
    }

    public static void login() {

        System.out.println("1. Seller Login");
        System.out.println("2. Customer Login");
        String choice = scan.nextLine();



        if (choice.equals("1")) {

        } else if (choice.equals("2")) {

        } else {
            System.out.println("Invalid choice");
            login();
        }



        System.out.println("Enter your username: ");
        String username = scan.nextLine();

        System.out.println("Enter your password: ");
        String password = scan.nextLine();

    }

    public static void signup() {

        System.out.println("1. Seller SignUp");
        System.out.println("2. Customer Signup");
        String choice = scan.nextLine();

        if (choice.equals("1")) {

        } else if (choice.equals("2")) {

        } else {
            System.out.println("Invalid choice");
            signup();
        }



        System.out.println("Enter your username: ");
        String username = scan.nextLine();
        System.out.println("Enter your password: ");
        String password = scan.nextLine();

        System.out.println("Enter your email: ");
        String email = scan.nextLine();
    }


}
