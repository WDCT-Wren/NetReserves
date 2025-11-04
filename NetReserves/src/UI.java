/** 
 * This will be the ui class for project EduCash to provide a clear User interface when using the program
 * <br><br>
 * This class shall contain the following UI sections:
 * <ul>
 *  <li><b>App Banner</b></li>
 *  <li><b>Log in Header</b></li>
 *  <li><b>Log in Successful Banner</b></li>
 *  <li><b>List of available Transactions</b></li>
 *  <li><b>Balance Banner</b></li>
 *  <li><b>Successful Deposit Banner, with the new current balance</b></li>
 *  <li><b>Successful Withdrawal Banner, with the new current balance</b></li>
 *  <li><b>Successful fund transfer, with the new current balance</b></li>
 *  <li><b>List of available actions after transacting</b></li>
 *  <li><b>Exit Banner</b></li>
 * </ul>
 */

public class UI {
    /**
     * This method will act as the app banner and the logo for the program.
     * (Text Banner was generated from patorjk.com)
     */
    public void appBanner() {
        System.out.print("""
            ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════╗
            ║       ███╗   ██╗███████╗████████╗██████╗ ███████╗███████╗███████╗██████╗ ██╗   ██╗███████╗███████╗       ║ 
            ║       ████╗  ██║██╔════╝╚══██╔══╝██╔══██╗██╔════╝██╔════╝██╔════╝██╔══██╗██║   ██║██╔════╝██╔════╝       ║
            ║       ██╔██╗ ██║█████╗     ██║   ██████╔╝█████╗  ███████╗█████╗  ██████╔╝██║   ██║█████╗  ███████╗       ║ 
            ║       ██║╚██╗██║██╔══╝     ██║   ██╔══██╗██╔══╝  ╚════██║██╔══╝  ██╔══██╗╚██╗ ██╔╝██╔══╝  ╚════██║       ║ 
            ║       ██║ ╚████║███████╗   ██║   ██║  ██║███████╗███████║███████╗██║  ██║ ╚████╔╝ ███████╗███████║       ║ 
            ║       ╚═╝  ╚═══╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝╚══════╝       ║ 
            ║                                                                                                          ║ 
            ║                                                                                                          ║
            ║                                      Your All-In-One Banking System                                      ║
            ║                                                                                                          ║
            ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════╝
            """);
            //Ignore the improper look in the code, it's fine on the terminal.
    }
    /**
     * This method will act and showcase the starting menu for the user to choose whether they would like to create a new account, 
     * or log in an already existing account through cardless transaction (By using their log in credentials).
     */
    public void loginHeader() {
        System.out.print("""
            ╔══════════════════════════════════════════════════╗
            ║              LOG IN TO YOUR ACCOUNT              ║
            ╚══════════════════════════════════════════════════╝
                    """);
    }

    public void loginSuccessful() {
        System.out.print("""
            ╔══════════════════════════════════════════════════╗
            ║                LOG IN SUCCESSFUL!                ║    
            ╚══════════════════════════════════════════════════╝
                    """);
    }

    public void transactionList() {
        System.out.print("""
            ╔══════════════════════════════════════════════════════╗
            ║  [1] BALANCE INQUIRY                                 ║
            ║  [2] WITHDRAWAL                                      ║ 
            ║  [3] DEPOSIT                                         ║
            ║  [4] WIRE TRANSFER / ELECTRONIC FUND TRANSFER (EFT)  ║
            ║  [5] LOG OUT OF CURRENT ACCOUNT                      ║
            ║  [6] EXIT APPLICATION                                ║
            ╚══════════════════════════════════════════════════════╝
                    """);
    }

    public void balance() {
        System.out.print("""
            ╔══════════════════════════════════════════════╗
            ║               CURRENT BALANCE:               ║
            ╚══════════════════════════════════════════════╝
            >>""");
    }
    
    public void successfulDeposit() {
        System.out.print("""
            ╔══════════════════════════════════════════════╗
            ║     DEPOSIT SUCCESSFUL! CURRENT BALANCE:     ║   
            ╚══════════════════════════════════════════════╝
            >>""");
    }
    
    public void successfulWithdrawal() {
        System.out.print("""
            ╔═══════════════════════════════════════════════╗
            ║    WITHDRAWAL SUCCESSFUL! CURRENT BALANCE:    ║   
            ╚═══════════════════════════════════════════════╝
            >>""");
    }

    public void successfulTransfer() {
        System.out.printf("""
            ╔═════════════════════════════════════════════╗
            ║    TRANSFER SUCCESSFUL! CURRENT BALANCE:    ║   
            ╚═════════════════════════════════════════════╝
            >>"""
            );
    }

    public void postTransactionSection() {
        System.out.printf("""
            ╔═════════════════════════════════════════════════╗
            ║ WOULD YOU LIKE TO PERFORM ANOTHER TRANSACTION?: ║  
            ║  [1] DO ANOTHER TRANSACTION                     ║
            ║  [2] LOGOUT                                     ║ 
            ║  [3] EXIT                                       ║ 
            ╚═════════════════════════════════════════════════╝
            """
            );
    }
    
    public void exitMenu() {
        System.out.println("""
            ╔══════════════════════════════════════════════╗
            ║        THANK YOU FOR BANKING WITH US!        ║
            ╚══════════════════════════════════════════════╝
                    """);
    }
}
