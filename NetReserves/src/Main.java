import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    //Class objects instantations
    static UI display = new UI();
    static Authenticator authenticator = new Authenticator();
    static TransactionsHandler transactionsHandler = new TransactionsHandler();
    
    //Declaration of global variable
    private static boolean isRunning;
    public static void main(String[] args) {
        //Variable Declaration and Initialization
        String enteredAccountNumber;
        String enteredPassword;
        int logInAttempt = 0;
        isRunning = true;
        display.appBanner();
        
        while (isRunning) {
            display.loginHeader();
            System.out.print("ENTER ACCOUNT NUMBER>> ");
            enteredAccountNumber = sc.nextLine();
            System.out.print("ENTER PASSWORD>> ");
            enteredPassword = sc.nextLine();
            String foundAccount = authenticator.findAccountNumber(enteredAccountNumber);

            if (foundAccount == null) {
                //Account does not exist in the database -> log in failed
                failedLoginAttemptCounter(++logInAttempt);
            }
            else if (foundAccount.equals(enteredAccountNumber) && authenticator.validateAccountPassword(enteredPassword)) {
                //Account exists AND the password entered is correct -> log in successful
                logInAttempt = 0;
                display.loginSuccessful();
                transactionsMenu(true);
            }
            else {
                //Account DOES exist BUT the password is wrong -> log in failed
                failedLoginAttemptCounter(++logInAttempt);
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
            System.out.println("INVALID USER CREDENTIALS! PLEASE TRY AGAIN (ATTEMPTS LEFT: " + (maxAttempts - logInAttempt) + ")");
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
    public static boolean transactionsMenu(boolean isLoggedIn) {
        int accountIndex = authenticator.getCurrentAccountIndex();
        Object[][] userData = (Object[][]) authenticator.getUserData();
        int userChoice = 0;
        while(isLoggedIn) {
            display.transactionList();
            try {
                System.out.print("SELECT YOUR TRANSACTION>> ");
                userChoice = sc.nextInt();
                switch (userChoice) {
                    case 1 -> transactionsHandler.balanceInquiry(accountIndex, userData);
                    case 2 -> transactionsHandler.withdrawal(accountIndex, userData);
                    case 3 -> transactionsHandler.deposit(accountIndex, userData);
                    case 4 ->  {
                        sc.nextLine();
                        transactionsHandler.fundTransfer(accountIndex, userData); 
                    }
                    case 5 -> {
                        System.out.println("LOGGED OUT OF CURRENT ACCOUNT");
                        sc.nextLine();
                        return isLoggedIn = false;
                    }
                    case 6 -> {
                        display.exitMenu();
                        sc.close();
                        return isRunning = false;
                    }
                    default ->  {
                        System.out.print("INVALID INPUT! CHOOSE BETWEEN 1 AND 6>> ");
                        sc.nextLine();
                        continue;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT! MUST BE A NUMBER BETWEEN 1 AND 6!");
                sc.nextLine();
                continue;
            }
            isLoggedIn = postTransaction(true);
        }
    return isRunning;
    }   
    
    public static boolean postTransaction(boolean isLoggedIn) {
        int userChoice;
        display.postTransactionSection();
        while (true) {
            try {
                System.out.print("SELECT YOUR TRANSACTION>> ");
                userChoice = sc.nextInt();
                switch (userChoice) {
            case 1 -> transactionsMenu(true);
            case 2 -> {
                System.out.println("LOGGED OUT OF CURRENT ACCOUNT");
                sc.nextLine();
                return isLoggedIn = false;
            }
            case 3 -> {
                display.exitMenu();
                sc.close();
                return isRunning = false;
            }
            default -> {
                System.out.println("INVALID INPUT! MUST BE A NUMBER BETWEEN 1 AND 3!");
                sc.nextLine();
                continue;
            }
        }
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT! MUST BE A NUMBER BETWEEN 1 AND 3!");
                sc.nextLine();
                continue;
            }
        return isRunning = false;
        }
    }
}