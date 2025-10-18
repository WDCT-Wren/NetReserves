import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This Class handles all transaction-related operations after successful user authentication.
 * It follows the separation of concerns principle - Authenticator handles login/validation,
 * while TransactionsHandler manages account operations.
 * 
 * Design Decision: Instead of creating a new Authenticator instance, we receive the account
 * index and userData array as parameters to avoid duplicate searching and maintain clean architecture.
 * 
 * This class handles the following transaction types:
 * <ul>
 *  <li>Balance inquiry - Display current account balance</li>
 *  <li>Account Deposit - Add money to account</li>
 *  <li>Account Withdrawal - Remove money from account</li>
 *  <li>Account-to-account fund transfer - Transfer money between accounts</li>
 * </ul>
 */

public class TransactionsHandler {
    UI display = new UI();
    Scanner sc = new Scanner(System.in);

    /**
     * Handles the displaying of the user's current balance. 
     * 
     * @param accountIndex
     * @param userData
     */
    public void balanceInquiry(int accountIndex, Object[][] userData) {
        // Get the balance from column 2 of the specified account row
        Object balance = userData[accountIndex][2];
        display.balance();
        System.out.println(" $" + balance);
    }

    /**
     * Handles account deposit transactions.
     * 
     * @param accountIndex The row index of the user's account in the userData array
     * @param userData The 2D array containing all account data for balance updates
     */
    public void deposit(int accountIndex, Object[][] userData) {
        double balance = (double) userData[accountIndex][2];
        boolean validAmount = false;
        //Declaration of the variables, especially declaring the balance by getting a copy of it from the 3rd column of the userData data set.

        while (!validAmount) {
            try {
                System.out.print("INPUT THE AMOUNT TO BE WITHDRAWN>> $");
                double depositedAmount = sc.nextDouble();

                if (confirmTransaction()) {
                    //If the user confirms their transaction -> successful deposit and will be doing the following
                    userData[accountIndex][2] = balance + depositedAmount; //increase the balance in the database according to the amoutn deposited

                    //Display successfull deposit UI with the current balance after the transaction
                    display.successfulDeposit();
                    System.out.println(" $" + userData[accountIndex][2]);
                    validAmount = true;
                } 
                else {
                    //If you cancel your transaction, then you will be brought back to the transaction menu.
                    Main.transactionsMenu(true);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("INVALID INPUT! PLEASE INPUT A NUMERICAL VALUE!");
                sc.nextLine();
            }
        }
    }

    /**
     * Handles account withdrawal transactions.
     * 
     * @param accountIndex The row index of the user's account in the userData array
     * @param userData The 2D array containing all account data for balance updates
     */
    public void withdrawal(int accountIndex, Object[][] userData) {
        double balance = (double) userData[accountIndex][2];
        boolean validAmount = false;
        //Declaration of the variables, especially declaring the balance by getting a copy of it from the 3rd column of the userData data set.

        while (!validAmount) {
            try {
                System.out.print("INPUT THE AMOUNT TO BE WITHDRAWN>> $");
                double withdrawnAmount = sc.nextDouble();

                if (withdrawnAmount < balance && confirmTransaction()) {
                    //There is sufficient balance AND the user confirms their transaction -> successful withdrawal, and will be doing the following:
                    userData[accountIndex][2] = balance - withdrawnAmount; //Reduce the balance in the database according to the amount withdrawn by the user.

                    //Display successfull withdrawal UI with the current balance after the transaction
                    display.successfulWithdrawal();
                    System.out.println(" $" + userData[accountIndex][2]);
                    validAmount = true;
                } 
                else if (withdrawnAmount > balance) {
                    //If your balance is insufficient -> unsuccessful withdrawal, and will be prompt to enter a new amount. 
                    System.out.println("INSUFFICIENT BALANCE!");
                    sc.nextLine();
                }
                else {
                    //If you cancel your transaction, then you will be brought back to the transaction menu.
                    Main.transactionsMenu(true);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("INVALID INPUT! PLEASE INPUT A NUMERICAL VALUE!");
                sc.nextLine();
            }
        }
    }

    /**
     * Handles electronic fund transfer between accounts.
     * Future implementation will: find recipient account, validate funds, transfer amount
     * 
     * @param accountIndex The row index of the sender's account in the userData array
     * @param userData The 2D array containing all account data for both sender and recipient updates
     */
    public void fundTransfer(int accountIndex, Object[][] userData) {
        //TODO: input Logic for cash transfer/electronic fund transfer (EFT).
        // Will need to: find recipient account, validate sender balance, update both accounts
        System.out.println("EFT Selected.");
    }

    public boolean confirmTransaction() {
        System.out.print("CONFIRM WITHDRAWAL TRANSACTION (1 -> CONFIRM | 2 -> CANCEL)>> ");
        int confirmation = sc.nextInt();

        boolean validInput = false;

        while (!validInput) {
            try {
                if (confirmation == 1) {
                    validInput = true;
                }
                else if (confirmation == 2) {
                    System.out.println("TRANSACTION CANCELLED");
                    sc.nextLine();
                    return false;
                }
                else {
                    System.out.println("INVALID INPUT! PLEASE ENTER ONLY 1 OR 2!");
                    sc.nextLine();
                    return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT! PLEASE ENTER A NUMERIC VALUE!");
                sc.nextLine();
            }
        }
        return true;
    }
}