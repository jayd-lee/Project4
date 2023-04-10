import java.util.Scanner;
import java.io.*;
import java.util.TreeMap;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class project4 {
    static Scanner scan = new Scanner(System.in);
    private Messages message;
    private ArrayList<String> messages;
    private ArrayList<String> stores;
    private ArrayList<String> sellers;
    private ArrayList<String> customers;
    public project4() {
        message = new Messages();
        messages = message.getMessages();
    }
    public void setStores() {

    }
    public void setSellers() {

    }
    public void setCustomers() {
        
    }
    public void createMessage(String sender, String receiver, String message) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String line = sender + "," + receiver + "," + sdf.format(ts) + "," + message + "," + "false";
        messages.add(line);
    }
    public void updateMessage(String sender, String receiver, String message, String newMessage) {
        String[] line;
        int index = -1;
        for(int x = 0; x < messages.size(); x++) {
            line = messages.get(x).split(",");
            if (line[0].equalsIgnoreCase(sender) && line[1].equalsIgnoreCase(receiver) && line[3].equalsIgnoreCase(message)) {
                index = x;
            }
        }
        messages.remove(index);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String data = sender + "," + receiver + "," + sdf.format(ts) + "," + newMessage + "," + "false";
        messages.add(data);
    }
    public void deleteMessage(String sender, String receiver, String message, String newMessage) {
        String[] line;
        int index = -1;
        String send = "";
        String receive = "";
        String time = "";
        String mess = "";
        for(int x = 0; x < messages.size(); x++) {
            line = messages.get(x).split(",");
            if (line[0].equalsIgnoreCase(sender) && line[1].equalsIgnoreCase(receiver) && line[3].equalsIgnoreCase(message)) {
                index = x;
                send = line[0];
                receive = line[1];
                time = line[2];
                mess = line[3];
            }
        }
        messages.remove(index);
        String data = send + "," + receive + "," + time + "," + mess + "," + "true";
        messages.add(data);
    }
    public void write() {
        message.writeMessages(messages);
    }
    public static void main(String[] args) throws IOException {
        Messages message = new Messages();
        boolean custom;
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
                custom = false;
                break;
            case "2":
                System.out.println("1. Seller SignUp");
                System.out.println("2. Customer Signup");
                System.out.println("3. Exit");
                do {
                    choice = scan.nextLine();
                } while (!choice.equals("3") && !choice.equals("2") && !choice.equals("1"));

                signup(choice);
                custom = true;
                break;

            case "3":
                System.out.println("Thanks for using the chat app!");
                return;
            default:
                System.out.println("Invalid choice");
                main(args);
                break;
        
        }
        if (custom) {
            System.out.println("1. Browse clothing stores.");
            System.out.println("2. Enter the seller's name who you want to contact.");
            int input = scan.nextInt();
            scan.nextLine();
            if (input == 1) {
                
            }
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
                while(!usernameExists) {
                    br = new BufferedReader(new FileReader("seller.txt"));
                    String line;
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
                    username = Tools.username();
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