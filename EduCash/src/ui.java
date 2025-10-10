/** 
 * This will be the ui class for project EduCash to provide a clear User interface when using the program
 * 
 * (This was updated as of October 9, 2025)
 * 
 * This class shall contain the following UI sections as of now:
 *  @category An app banner (made from manytools.org),
 *  @category A starting menu, and
 *  @category An account menu for in account transactions (eg. Balance inquiry, withdrawal, deposit, and wire transfer).
 */

public class UI {
    public void appBanner() {
        /**
         * This method will act as the app banner and the logo for the program.
         * (Text Banner was generated from manytools.org)
         */
        System.out.println("""
            ╔════════════════════════════════════════════════════════════════════════════════════════════════════╗
            ║   ██████╗ ██████╗ ███████╗██╗   ██╗    ███████╗██████╗ ██╗   ██╗ ██████╗ █████╗ ███████╗██╗  ██╗   ║
            ║   ██╔══██╗██╔══██╗██╔════╝██║   ██║    ██╔════╝██╔══██╗██║   ██║██╔════╝██╔══██╗██╔════╝██║  ██║   ║
            ║   ██████╔╝██████╔╝███████╗██║   ██║    █████╗  ██║  ██║██║   ██║██║     ███████║███████╗███████║   ║
            ║   ██╔══██╗██╔═══╝ ╚════██║██║   ██║    ██╔══╝  ██║  ██║██║   ██║██║     ██╔══██║╚════██║██╔══██║   ║
            ║   ██████╔╝██║     ███████║╚██████╔╝    ███████╗██████╔╝╚██████╔╝╚██████╗██║  ██║███████║██║  ██║   ║
            ║   ╚═════╝ ╚═╝     ╚══════╝ ╚═════╝     ╚══════╝╚═════╝  ╚═════╝  ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝   ║
            ║                                                                                                    ║
            ║                University ATM for the scholars of Bataan Peninsula State University                ║
            ║                                                                                                    ║
            ╚════════════════════════════════════════════════════════════════════════════════════════════════════╝
                """);    
    }

    public void startingMenu() {
        /**
         * This method will act and showcase the starting menu for the user to choose whether they would like to create a new account, 
         * or log in an already existing account through cardless transaction (By using their log in credentials).
         */
        System.out.println("""
            ╔════════════════════════════════════════════════╗
            ║  [1] CREATE AN ACCOUNT                         ║
            ║  [2] LOG IN AN ACCOUNT (CARDLESS TRANSACTION)  ║ 
            ║  [3] EXIT APPLICATION                          ║
            ╚════════════════════════════════════════════════╝
                    """);
    }

    public void AccountMenu() {
        /**
         * This method will act and showcase the starting menu for the user to choose their desired transaction in their account.
         * This may be in the form of:
         * 
         * Balance inquiry
         * Widthrawal
         * Deposit, or
         * wire transfer to send money to another already existing account in the system
         */
        System.out.println("""
            ╔══════════════════════════════════════════════════════╗
            ║  [1] BALANCE INQUIRY                                 ║
            ║  [2] WITHDRAWAL                                      ║ 
            ║  [3] DEPOSIT                                         ║
            ║  [4] WIRE TRANSFER / ELECTRONIC FUND TRANSFER (EFT)  ║
            ║  [5] EXIT APPLICATION                                ║
            ╚══════════════════════════════════════════════════════╝
                    """);
    }

    public void exitMenu() {
        System.out.println("""
            ╔══════════════════════════════════════════════╗
            ║        THANK YOU FOR BANKING WITH US!        ║
            ╚══════════════════════════════════════════════╝
                    """);
    }
}
