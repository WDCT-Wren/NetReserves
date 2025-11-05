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
     * This method focuses on what transaction the user wishes to proceed to after logging in. 
     * <br><br>
     * This gives the user 6 choices:
     * <ul>
     *  <li><b>Balance Inquiry</b> - Where the user wishes to view their current balance.</li>
     *  <li><b>Withdrawal</b> - Where the user wishes to withdraw an amount of money from their account.</li>
     *  <li><b>Deposit</b> - Where the user wishes to deposit a sum amount of money to their account.</li>
     *  <li><b>Fund Transfer</b> - Where the user wishes to send a sum amount of money from their account to another account which will be prompted unto them.</li>
     *  <li><b>Log Out</b> - Where the user simply wishes to log out of their account.</li>
     *  <li><b>Exit the Program</b> - Where the user simply wishes to exit the program and close the ATM system.</li>
     * </ul>
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
                        System.out.println("INVALID INPUT! CHOOSE BETWEEN 1 AND 6!");
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
    
    /**
     * This method focuses on what the user wish to do after their transaction. 
     * <br><br>
     * This gives the user 3 choices:
     * <ul>
     *  <li><b>Do Another Transaction</b> - Where the user wishes to do another transaction with the same account.</li>
     *  <li><b>Log Out of Current Account</b> - Where the user wishes to log out of their account and possibly do antoher transaction on another account.</li>
     *  <li><b>Exit the Program</b> - Where the user simply wishes to exit the program and close the ATM system.</li>
     * </ul>
     * 
     * @param isLoggedIn
     * @return isLoggedIn or isRunning to either be false or true depending on what the user wants to do after the transaction
     */
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