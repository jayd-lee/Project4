import java.util.Scanner;
import java.io.*;
import java.util.SimpleTimeZone;
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
                System.out.println("1. Seller Signup");
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
            boolean usernameExists = false;
            BufferedReader br = null;
            while (!usernameExists) {
                try {
                    br = new BufferedReader(new FileReader("src/seller.txt"));
                    String line;
                    String username = Tools.username();

                    while ((line = br.readLine()) != null) {
                        if (line.contains(username)) {
                            usernameExists = true;
                            String[] details = line.split(",");
                            loginUsername = details[0].trim();
                            loginPassword = details[1].trim();
                            loginEmail = details[2].trim();
                            break;
                        }
                    }
                    if (!usernameExists) {
                        System.out.println("Username does not exist. Please try again.");
                    }

                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            System.out.println("Error closing file: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
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

            Seller seller = new Seller(loginUsername, loginPassword, loginEmail);


        } else if (choice.equals("2")) {

            boolean usernameExists = false;
            BufferedReader br = null;
            while (!usernameExists) {
                try {
                    br = new BufferedReader(new FileReader("src/customer.txt"));
                    String line;
                    String username = Tools.username();

                    while ((line = br.readLine()) != null) {
                        if (line.contains(username)) {
                            usernameExists = true;
                            String[] details = line.split(",");
                            loginUsername = details[0].trim();
                            loginPassword = details[1].trim();
                            loginEmail = details[2].trim();
                            break;
                        }
                    }
                    if (!usernameExists) {
                        System.out.println("Username does not exist. Please try again.");
                    }

                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            System.out.println("Error closing file: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
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

            Customer customer = new Customer(loginUsername, loginPassword, loginEmail);

        } else {
            System.out.println("Thanks for using the chat app!");
        }
    }

    public static void signup(String choice) {
        String loginUsername = null;
        String loginPassword = null;
        String loginEmail = null;

        if (choice.equals("1")) {
            boolean emailExists = true;
            BufferedReader br = null;

            while (emailExists) {
                try {
                    br = new BufferedReader(new FileReader("src/seller.txt"));
                    String line;
                    String email = Tools.email();

                    while ((line = br.readLine()) != null) {
                        if (line.contains(email)) {
                            String[] details = line.split(",");
                            loginUsername = details[0].trim();
                            loginEmail = details[2].trim();
                            break;
                        }
                    }
                    if (loginUsername == null) {
                        emailExists = false;
                    }

                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            System.out.println("Error closing file: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            }

            while(true) {
                String username = Tools.username();
                if (loginUsername == username) {
                    System.out.println("Username already exists. Please try again.");
                } else {
                    loginUsername = username;
                    break;
                }
            }

            loginPassword = Tools.password();


            Seller seller = new Seller(loginUsername, loginPassword, loginEmail);



        } else if (choice.equals("2")) {
            boolean emailExists = true;
            BufferedReader br = null;

            while (emailExists) {
                try {
                    br = new BufferedReader(new FileReader("src/seller.txt"));
                    String line;
                    String email = Tools.email();

                    while ((line = br.readLine()) != null) {
                        if (line.contains(email)) {
                            String[] details = line.split(",");
                            loginUsername = details[0].trim();
                            loginEmail = details[2].trim();
                            break;
                        }
                    }
                    if (loginUsername == null) {
                        emailExists = false;
                    }

                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            System.out.println("Error closing file: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            }

            while(true) {
                String username = Tools.username();
                if (loginUsername == username) {
                    System.out.println("Username already exists. Please try again.");
                } else {
                    loginUsername = username;
                    break;
                }
            }

            loginPassword = Tools.password();


            Seller seller = new Seller(loginUsername, loginPassword, loginEmail);


        } else {
            System.out.println("Thanks for using the chat app!");
        }


    }



}