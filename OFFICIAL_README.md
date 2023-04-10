# README


## INSTRUCTIONS TO COMPILE AND RUN PROGRAM
- In vocareum: javac project4.java    java project4 
- this command should run our main method, which will handle all the user input and output


## SUBMISSIONS
- Jayden Lee subsubmitted Project 4 in the Vocareum workspace—04/10/23
- Kylie Houston submitted the Report in Brightspace—04/10/23


## CLASSES, INTERFACES, AND FILES

#### *User.java:* 
- Interface for creating user objects using username, password, and email parameters. Has User constructor and standard getters and setters
#### *Customer.java:*
- class that implements User and creates a customer object, using the super keyword to call all the parameters from the User class inside the constructor
#### *Seller.java:* 
- class that implements User and creates a seller object, using the super keyword to call all the parameters from the User class inside the constructor
#### *Tools.java:*
- Contains I/O for the username, password, and email to be used in the login and signup methods of our Project4 class
- Has three methods: username, password, and email
#### *Messages.java:* 
- method which uses the constructor to read and add all current messages to an ArrayList. Then, there is a writeMessages method that takes in another message ArrayList in its constructor and writes it to the messages.txt file. 
#### *Project4.java:*
- Class which houses our main, login, signup, create message, update message, and delete message methods. Our main class handles the vast majority of our File I/O. 
- The login method manages the logins for both sellers and buyers, taking in the username and password and verifying accordingly. 
- The signup method takes in a new username, password, and email and writes it to either the seller or buyer text files. 
#### *Stores.java:*
- method which uses the constructor to read and add all current stores to an ArrayList. Then, there is a writeStores method that takes in a newStores ArrayList in its constructor and writes each tore to the stores.txt file. 
#### *customer.txt:* 
- text file which stores customers in the format: username, password, email
- file is read from to process login/signup details for customer and is written to when a new user is created or an existing user changes their information
#### *seller.txt:* 
- text file which stores sellers in the format: username, password, email
- file is read from to process login/signup details for seller and is written to when a new user is created or an existing user changes their information
#### *messages.txt:* 
- text file which stores messages between customers and sellers 
#### *stores.txt:* 
- text file which holds the names of all the stores
