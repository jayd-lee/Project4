import org.junit.Test;
import org.junit.After;

import org.junit.Before;

import java.io.*;

import static org.junit.Assert.*;


public class TestCases {

    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }




        @Test(timeout = 1000)
        public void testExpectedOutputExit() throws IOException {


            // expected result
            String expected =
                    "Welcome to the chat app!" +
                            System.lineSeparator() +
                            "1. Login" +
                            System.lineSeparator() +
                            "2. Sign up" +
                            System.lineSeparator() +
                            "3. Exit" +
                            System.lineSeparator() +
                            "Thanks for using the chat app!" +
                            System.lineSeparator() ;

            // desired input
            String input =
                    "3" + System.lineSeparator();

            // runs program with input
            receiveInput(input);
            project4.main(new String[0]);

            // gets output from the program
            String output = getOutput();

            // trims and verifies output
            assertEquals("Output does not match the expected format",
                    expected.trim(), output.trim());
        }
        @Test(timeout = 1000)
        public void testExpectedOutputCustomerSignup() throws IOException {

            String expected =
                    "Enter your email: " +
                            System.lineSeparator() +
                            "Enter your username: " +
                            System.lineSeparator() +
                            "Username already exists. Please try again." +
                            System.lineSeparator() +
                            "Enter your username: " +
                            System.lineSeparator() +
                            "Enter your password: " +
                            System.lineSeparator() ;

            String input =
                    "kylienichouston8@gmail.com" + System.lineSeparator()  + "houstokn" + System.lineSeparator() + "houstonk8 " +
                            System.lineSeparator() + "12345"+ System.lineSeparator()
                            + System.lineSeparator();

            receiveInput(input);
            project4.signup("2");


            String output = getOutput();

            assertEquals("Output does not match the expected format",
                    expected.trim(), output.trim());
        }
        @Test(timeout = 1000)
        public void testExpectedOutputLoginExit() throws IOException {


            String expected =
                    "Welcome to the chat app!" +
                            System.lineSeparator() +
                            "1. Login" +
                            System.lineSeparator() +
                            "2. Sign up" +
                            System.lineSeparator() +
                            "3. Exit" +
                            System.lineSeparator() +
                            "1. Seller Login" +
                            System.lineSeparator() +
                            "2. Customer Login" +
                            System.lineSeparator() +
                            "3. Exit" +
                            System.lineSeparator() +
                            "Thanks for using the chat app!";


            String input =
                    "1" + System.lineSeparator() + "3" + System.lineSeparator();


            receiveInput(input);
            project4.main(new String[0]);


            String output = getOutput();

            assertEquals("Output does not match the expected format",
                    expected.trim(), output.trim());
        }
        @Test(timeout = 1000)
        public void testExpectedOutputPasswordTool() throws IOException {


            String expected =
                    "Enter your username: " +
                            System.lineSeparator() +
                            "Username does not exist. Please try again." +
                            System.lineSeparator() +
                            "Enter your username: " +
                            System.lineSeparator() +
                            "Enter your password: " +
                            System.lineSeparator() +
                            "Login successful" +
                            System.lineSeparator();



            String input =
                    "housto" + System.lineSeparator() + "houstokn" + System.lineSeparator() + "1234"
                            + System.lineSeparator();


            receiveInput(input);
            project4.login("2");


            String output = getOutput();


            assertEquals("Make sure your output matches the expected format",
                    expected.trim(), output.trim());
        }


        @Test(timeout = 1000)
        public void testExpectedOutputUsernamePasswordTool() throws IOException {


            String expected =
                    "Enter your username: " +
                            System.lineSeparator() +
                            "Username does not exist. Please try again." +
                            System.lineSeparator() +
                            "Enter your username: " +
                            System.lineSeparator() +
                            "Enter your password: " +
                            System.lineSeparator() +
                            "Login successful" +
                            System.lineSeparator();



            String input =
                    "housto" + System.lineSeparator() + "houstokn" + System.lineSeparator() + "1234"
                            + System.lineSeparator();


            receiveInput(input);
            project4.login("2");

            String output = getOutput();


            assertEquals("Make sure your output matches the expected format",
                    expected.trim(), output.trim());
        }


    }
}

