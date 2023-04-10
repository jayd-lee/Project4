import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.*;
import java.util.SimpleTimeZone;
import java.util.TreeMap;
import java.util.ArrayList;


public class project4 {

    static Scanner scan = new Scanner(System.in);
    private Messages message;
    private ArrayList<String> messages;
    private ArrayList<String> stores;
    private ArrayList<String> sellers;
    private ArrayList<String> customers;

    public static User user;
    private static boolean isSeller;


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

        if (isSeller) {


        } else {

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
            user = new User(loginUsername, loginPassword, loginEmail);
            isSeller = true;


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

            user = new User(loginUsername, loginPassword, loginEmail);
            isSeller = false;

        } else {
            System.out.println("Thanks for using the chat app!");
        }
    }

    public static void signup(String choice) {
        String loginUsername = null;
        String loginPassword = null;
        String loginEmail = null;

        if (choice.equals("1")) {

            BufferedReader br = null;
            ArrayList<String> usernameList = new ArrayList<>();
            ArrayList<String> passwordList = new ArrayList<>();
            ArrayList<String> emailList = new ArrayList<>();

            try {
                br = new BufferedReader(new FileReader("src/seller.txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] details = line.split(",");
                    loginUsername = details[0].trim();
                    loginPassword = details[1].trim();
                    loginEmail = details[2].trim();

                    usernameList.add(loginUsername);
                    passwordList.add(loginPassword);
                    emailList.add(loginEmail);
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


            while (true) {
                loginEmail = Tools.email();
                if (emailList.contains(loginEmail)) {
                    System.out.println("Email already exists. Please try again.");
                } else {
                    break;
                }
            }

            while (true) {
                loginUsername = Tools.username();
                if (usernameList.contains(loginUsername)) {
                    System.out.println("Username already exists. Please try again.");
                } else {
                    break;
                }
            }

            loginPassword = Tools.password();

            try {
                FileWriter fileWriter = new FileWriter("src/seller.txt", true);
                PrintWriter pw = new PrintWriter(fileWriter);
                pw.write("\n" + loginUsername + ", " + loginPassword + ", " + loginEmail);
                pw.close();

                System.out.println("Data written t successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            user = new User(loginUsername, loginPassword, loginEmail);
            isSeller = true;

        } else if (choice.equals("2")) {
            BufferedReader br = null;
            ArrayList<String> usernameList = new ArrayList<>();
            ArrayList<String> passwordList = new ArrayList<>();
            ArrayList<String> emailList = new ArrayList<>();

            try {
                br = new BufferedReader(new FileReader("src/customer.txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] details = line.split(",");
                    loginUsername = details[0].trim();
                    loginPassword = details[1].trim();
                    loginEmail = details[2].trim();

                    usernameList.add(loginUsername);
                    passwordList.add(loginPassword);
                    emailList.add(loginEmail);
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

            while (true) {
                loginEmail = Tools.email();
                if (emailList.contains(loginEmail)) {
                    System.out.println("Email already exists. Please try again.");
                } else {
                    break;
                }
            }

            while (true) {
                loginUsername = Tools.username();
                if (usernameList.contains(loginUsername)) {
                    System.out.println("Username already exists. Please try again.");
                } else {
                    break;
                }
            }

            loginPassword = Tools.password();

            try {
                FileWriter fileWriter = new FileWriter("src/customer.txt", true);
                PrintWriter pw = new PrintWriter(fileWriter);
                pw.write("\n" + loginUsername + ", " + loginPassword + ", " + loginEmail);
                pw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            user = new User(loginUsername, loginPassword, loginEmail);
            isSeller = true;

        } else {
            System.out.println("Thanks for using the chat app!");
        }
    }



    public project4() {
        message = new Messages();
        messages = message.getMessages();
    }
    public void readStores() {

    }
    public void readSellers() {

    }
    public void readCustomers() {

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
    public void writeMessages() {
        message.writeMessages(messages);
    }
}


