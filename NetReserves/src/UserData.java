/**
 * This is a class that will be handling user data the ATM system. This class will already contain pre-existing user data, which will be called when a user logs in an existing account.
 * We don't aim on making a more dynamic system that allows users to register accounts, so we will be using 2d arrays as a way to store the user data, where rows are accounts,
 * while columns are the following: 
 * 
 * column[0] = Account Number
 * column [1] = Account Password
 * column [2] = Account Balance
 * 
 * This System will store and return the following data:
 * @category accountNumber - The user's account number.
 * @category accountPassword - The user's set password.
 * @category userBalance - The user's current balance.
 */

public class UserData {
    private String accountNumber;
    private String accountPassword;
    private double userBalance;

    private String[][] userData =   {
        //accNum    //accPass   //balance
        {"04771", "XiaoJie1234!",   "0"},
        {"04354", "BaoBaoLong234!", "0"},
        {"04233", "DoeJohn123!",    "0"},
        {"04533", "Jpork234!",      "0"},
    };

    public void userData (String accountNumber, String accountPassword, double userBalance) {

        //TODO: for loop to traverse account number column
        accountNumber = userData[i][0];

        //TODO: for loop to traverse account password column
        accountPassword = userData[i][1];

        //TODO: for loop to traverse account balance column
        userBalance = Double.parseDouble(userData[i][2]);
    }
}
