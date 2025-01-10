import java.util.Scanner; //imports Scanner
//Main class. In this class the PasswordVerify objects are going to be created and exceptions are going to
//be demonstrated.
public class Main {
    public static void main(String[] args) {

        //Part 1: Throwing and catching a basic exception
        //creates a new Scanner object
        Scanner scanner = new Scanner(System.in);

        try { //try block starts

            //Collecting the input from the user and storing the data on variables
            System.out.println("Please enter the first integer: ");
            int num1 = scanner.nextInt();
            System.out.println("Please enter the second integer: ");
            int num2 = scanner.nextInt();

            //divides and casts the integer to double
            double result = (double) num1 / num2;

            /*formats the result and prints it out so that it can appear
             as a double with two decimal places */
            System.out.printf("%d / %d = %.2f%n", num1, num2, result);
        } //try block ends

        catch (ArithmeticException e) { //catch block starts
            System.out.println("Can't divide by 0");
        } //catch block ends

        //Clears the buffer
        scanner.nextLine();

        //Part 2: Creating custom exceptions
        //Number of times to ask the user for input
        int dataCount = 4;

        //temporary variables
        String pass = null;
        String user = null;

        //Array to store each object information
        PasswordVerify[] accounts = new PasswordVerify[dataCount];

        //Display the rules for entering the username and the password
        System.out.println("Creating account Rules:");
        System.out.println("1. Username must be at least 6 characters long and contain at least 2 vowels");
        System.out.println("2. Password must be exactly 8 characters long, and the 4th character must be a '%'");
        System.out.println();

        /*for loop that instantiates the PasswordVerify objects using input from the user,
         checks for exceptions, and stores objects in array */
        for (int i = 0; i < dataCount; i++) {
            try { //try block starts

                //asking from input
                System.out.println("Enter the username for account " + i);
                user = scanner.nextLine();

                System.out.println("Enter the password for the account " + i);
                pass = scanner.nextLine();

                //add the new account to the array
                accounts[i] = new PasswordVerify(user, pass);

                System.out.println("New Account created successfully");

            } //try block ends
            catch (PasswordVerifyException e) { //catch block starts

                //prints message if an exception is caught
                System.out.println(e.getMessage());
                //clear the buffer
                scanner.nextLine();
                //decrements the index so the user can try again
                i--;

            } //catch block ends

        }
        //prints all the usernames with their corresponding passwords
        System.out.println("All accounts created:");
        for (int o=0; o <accounts.length; o++){
            System.out.println(accounts[o]);
        }

        //closes the scanner
        scanner.close();

    }


}