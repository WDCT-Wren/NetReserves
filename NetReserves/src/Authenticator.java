/**
     * This method will handle the matching of the entered number an existing account number. If the entered account number matches with an existing account, 
     * the account will be called where it will then proceed to check the password if it mathces.
     * 
     *  @param enteredNumber 
     *  @return either true or false depending if the userID matches the password of an account.
     * 
     */
public class Authenticator {    
    private String accountNumber; 
    //made to initialize the accountenumber string to be returned and compared to the entered one in main.

    /**
     * This will be handling user data the ATM system. This class will already contain pre-existing user data, which will be called when a user logs in an existing account.
     * We don't aim on making a more dynamic system that allows users to register accounts, so we will be using 2d arrays as a way to store the user data, where rows are accounts,
     * while columns are the following: 
     * 
     * column [0] = Account Number;
     * column [1] = Account Password; and
     * column [2] = Account Balance.
     * 
     * This System will store and return the following data:
     * @category accountNumber - The user's account number.
     * @category accountPassword - The user's set password.
     * @category userBalance - The user's current balance.
     */
    private Object[][] userData =   {
        //accNum    //accPass   //balance
        {"04771", "XiaoJie1234!",   0},
        {"04354", "BaoBaoLong234!", 0},
        {"04233", "DoeJohn123!",    0},
        {"04533", "JohnPork234!",      0},
    };

    //Getter method for the userData dataset - returns the 2D array for transaction processing
    public Object[][] getUserData() {
        return userData;
    }

    /**
     * This Method is a pivotal part of the authentication phase where it is the first stage of the authentication program.
     * This method will be traversing the 2d array through all the rows(accounts with their corresponding user datas), and specifically through the index[0], or the account number, aiming to find if the account number entered by the user is existant. 
     * 
     * @param enteredNumber
     * @return The user's account number as a string
     */
    public String findAccountNumber(String enteredNumber) {
        for (int i = 0; i < userData.length; i++) {
            if (enteredNumber.equals(userData[i][0])) {
                return accountNumber = (String) userData[i][0];
            }
        }
        accountNumber = null;
        return null;
    }
    /**
     * This method has the same purpose as the findAccountNumber(), although instead of returning the account number, it returns the row index of the found account. 
     * @return the row index of the found userdata from the account number
     */
    public int getCurrentAccountIndex() {
        for (int i = 0; i < userData.length; i++) {
            if (accountNumber.equals(userData[i][0])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method will handle the matching of the corresponding password of the matched account.
     * 
     * @param enteredPassword
     * @return either true or false depending if the password matches the password of the chosen account.
     */
    public boolean validateAccountPassword(String enteredPassword) {
        if (accountNumber == null) return false; 

        for (int i = 0; i < userData.length; i++) {
            if (accountNumber.equals(userData[i][0])) {
                return enteredPassword.equals(userData[i][1]);
            }
        }
        return false;
    }
}
