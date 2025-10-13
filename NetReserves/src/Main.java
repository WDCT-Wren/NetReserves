import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    //Class objects instantations
    static UI display = new UI();
    static LoginHandler loginHandler = new LoginHandler();
    static TransactionsHandler transactionsHandler = new TransactionsHandler();
    static UserData userData = new UserData();
    
    //Declaration of global variable
    private static boolean isRunning;
    public static void main(String[] args) {

        //Variable Declaration and Initialization
        String enteredID;
        String enteredPassword;
        int logInAttempt = 0;
        isRunning = true;
        display.appBanner();
        
        while (isRunning) {
            display.loginHeader();
            System.out.print("ENTER ACCOUNT NUMBER>> ");
            enteredID = sc.nextLine();
            System.out.print("ENTER PASSWORD>> ");
            enteredPassword = sc.nextLine();
            if (loginHandler.validateAccountNumber(enteredID) && loginHandler.validateAccountPassword(enteredPassword)) {
                logInAttempt = 0;
                display.loginSuccessful();
                transactionsMenuHandler(true);
            }
            else {
                failedLoginAttemptCounter(++logInAttempt);
            }
        }
    }

    /**
     * Prompts the user to enter a valid menu userChoice between 1 and 3.
     * Handles invalid input and ensures the returned value is within the valid range.
     * Additionally, this uses exception handling if the input is not an integer.
     *
     * @return a valid integer userChoice between 1 and 6
     */
    private static int getValidUserChoice() {
        int userChoice;
        while (true) {
            try {
                userChoice = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline character after reading integer input
                if (userChoice >= 1 && userChoice <= 6) {
                    return userChoice;
                } else {
                    System.out.print("INVALID INPUT! CHOOSE BETWEEN 1 AND 6>> ");
                }
            } catch (InputMismatchException e) {
                System.out.print("INVALID INPUT! MUST BE A NUMBER BETWEEN 1 AND 6>> ");
                sc.nextLine(); // clear the invalid input
            }
        }
    }

    /**
     * This method will handle the checking if the attempt limit has been reached. 
     * 
     * @param logInAttempt
     * @return isRunning as either true or false depending if the attempt limit was reached before a successfull login
     */
    private static boolean failedLoginAttemptCounter(int logInAttempt) {
        int maxAttempts = 3;

        if (logInAttempt < maxAttempts) {
            System.out.println("INVALID USER CREDENTIALS! PLEASE TRY AGAIN (ATTEMPTS LEFT: " + (maxAttempts - logInAttempt) + ")>> ");
        }
        else {
            System.out.println("TOO MANY FAILED ATTEMPTS! ACCOUNT IS NOW LOCKED.");
            display.exitMenu();
            return isRunning = false;
        }
        return isRunning = true;
    }

    /**
     * Where the main transaction process is being handled 
     * 
     * @param isLoggedIn
     * @return isRunning to either be true or false depending on what the user enters: If the user enters 5, it simply logs the account out returning isRunning to still be true; if the user etners 6, it returns isRunning to false, closing the system. 
     */
    private static boolean transactionsMenuHandler(boolean isLoggedIn) {
        while(isLoggedIn) {
            display.transactionList();
            System.out.print("SELECT YOUR TRANSACTION>> ");
            int userChoice = getValidUserChoice();

            switch (userChoice) {
                case 1 -> transactionsHandler.balanceInquiry();
                case 2 -> transactionsHandler.withdrawal();
                case 3 -> transactionsHandler.deposit();
                case 4 -> transactionsHandler.fundTransfer();
                case 5 -> {
                    System.out.println("LOGGED OUT OF CURRENT ACCOUNT");
                    isLoggedIn = false;
                }
                case 6 -> {
                    display.exitMenu();
                    return isRunning = false;
                }
            }
        }
        return isRunning = true;
    }
}