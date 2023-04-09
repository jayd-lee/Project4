import java.util.Scanner;
import java.io.*;
import java.util.TreeMap;

public class project4 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the chat app!");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        String choice = scan.nextLine();

        switch (choice) {
            case "1":
                System.out.println("1. Seller Login");
                System.out.println("2. Customer Login");
                System.out.println("3. Exit");

                do {
                    choice = scan.nextLine();
                } while (!choice.equals("3") && !choice.equals("2") && !choice.equals("1"));

                login(choice);
                break;

            case "2":
                System.out.println("1. Seller SignUp");
                System.out.println("2. Customer Signup");
                System.out.println("3. Exit");
                do {
                    choice = scan.nextLine();
                } while (!choice.equals("3") && !choice.equals("2") && !choice.equals("1"));

                signup(choice);

                break;

            case "3":
                System.out.println("Thanks for using the chat app!");
                return;

            default:
                System.out.println("Invalid choice");
                main(args);
                break;
        }

    }

    public static void login(String choice) throws IOException {
        String loginUsername = null;
        String loginPassword = null;
        String loginEmail = null;

        if (choice.equals("1")) {

            String username = Tools.username();
            boolean usernameExists = false;
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("src/seller.txt"));
                String line;
                while (loginUsername == null) {
                    while ((line = br.readLine()) != null) {
                        if (line.toLowerCase().contains(username.toLowerCase())) {
                            usernameExists = true;
                            String[] details = line.trim().split(",");
                            loginUsername = details[0];
                            loginPassword = details[1];
                            loginEmail = details[2];
                            break;
                        }
                    }
                    System.out.println("Username does not exist");
                }

            } catch (IOException e) {
                System.out.println("Username does not exist");
                e.printStackTrace();

            } finally {
                if (br != null) {
                    br.close();
                }
            }

            while(true) {
                if (Tools.password().equals(loginPassword)) {
                    System.out.println("Login successful");
                    break;
                } else {
                    System.out.println("Invalid password, try again");
                }
            }





            /*
            while (true) {

            if (Tools.username() //exists in the dataframe) {
                * call a function to access that user's data
                break

                //check seleler user name exist

            } else {
                System.out.println("Invalid username");
                continue;
            }






            */


        } else if (choice.equals("2")) {

        } else {
            System.out.println("Thanks for using the chat app!");
        }


    }

    public static void signup(String choice) {



        if (choice.equals("1")) {

        } else if (choice.equals("2")) {

        } else {
            System.out.println("Thanks for using the chat app!");
        }


    }



}