public class LoginHandler {    
    /**
     * This method will handle the matching of the entered number an existing account number. If the entered account number matches with an existing account, 
     * the account will be called where it will then proceed to check the password if it mathces.
     * 
     * @param enteredNumber
     * @return either true or false depending if the userID matches the password of an account.
     */
    public boolean validateAccountNumber(String enteredNumber) {
        //TODO: implement logic that will compare the user's entered account number to the stored account numbers in UserData class
        return true;
    }

    /**
     * This method will handle the matching of the corresponding password of the matched account.
     * 
     * @param enteredPassword
     * @return either true or false depending if the password matches the password of the chosen account.
     */
    public boolean validateAccountPassword(String enteredPassword) {
        //TODO: implement logic that will compare the user's entered password to the stored account passwords in UserData class
        return true;
    }
}
