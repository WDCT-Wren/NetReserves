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
    // No separate Authenticator instance needed - we receive account data via method parameters
    // This design avoids duplicate array searching and keeps classes focused on their responsibilities

    UI display = new UI();

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
        System.out.println(balance);
    }

    /**
     * Handles account withdrawal transactions.
     * Future implementation will: validate sufficient funds, deduct amount, update balance
     * 
     * @param accountIndex The row index of the user's account in the userData array
     * @param userData The 2D array containing all account data for balance updates
     */
    public void withdrawal(int accountIndex, Object[][] userData) {
        //TODO: input Logic for account withdrawals
        // Will need to: check current balance, validate withdrawal amount, update userData[accountIndex][2]
        System.out.println("Withdrawal Selected.");
    }

    /**
     * Handles account deposit transactions.
     * Future implementation will: validate deposit amount, add to balance, update account
     * 
     * @param accountIndex The row index of the user's account in the userData array
     * @param userData The 2D array containing all account data for balance updates
     */
    public void deposit(int accountIndex, Object[][] userData) {
        //TODO: input Logic for account deposits
        // Will need to: validate deposit amount, update userData[accountIndex][2] with new balance
        System.out.println("Deposit Selected.");
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
}
