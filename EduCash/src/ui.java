/* This will be the ui class for project EduCash
 * 
 * This class shall contain the following UI sections as of now:
 * - An app banner (made from manytools.org)
 * - A starting menu
 * - An account menu for in account transactions (eg. Balance inquiry, widthrawal, deposit, and wire transfer).
 * 
 * (This was updated as of October 9, 2025)
 */

public class ui {
    static void appBanner() {
        //Text Banner was generated from manytools.org
        System.out.println("""
            ╔════════════════════════════════════════════════════════════════════════════════════════════════════╗
            ║   ██████╗ ██████╗ ███████╗██╗   ██╗    ███████╗██████╗ ██╗   ██╗ ██████╗ █████╗ ███████╗██╗  ██╗   ║
            ║   ██╔══██╗██╔══██╗██╔════╝██║   ██║    ██╔════╝██╔══██╗██║   ██║██╔════╝██╔══██╗██╔════╝██║  ██║   ║
            ║   ██████╔╝██████╔╝███████╗██║   ██║    █████╗  ██║  ██║██║   ██║██║     ███████║███████╗███████║   ║
            ║   ██╔══██╗██╔═══╝ ╚════██║██║   ██║    ██╔══╝  ██║  ██║██║   ██║██║     ██╔══██║╚════██║██╔══██║   ║
            ║   ██████╔╝██║     ███████║╚██████╔╝    ███████╗██████╔╝╚██████╔╝╚██████╗██║  ██║███████║██║  ██║   ║
            ║   ╚═════╝ ╚═╝     ╚══════╝ ╚═════╝     ╚══════╝╚═════╝  ╚═════╝  ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝   ║
            ╚════════════════════════════════════════════════════════════════════════════════════════════════════╝
                """);    
    }

    static void startingMenu() {
    System.out.println("""
                ╔════════════════════════════════════════════════╗
                ║  [1] CREATE AN ACCOUNT                         ║
                ║  [2] LOG IN AN ACCOUNT (CARDLESS TRANSACTION)  ║ 
                ║  [3] EXIT APPLICATION                          ║
                ╚════════════════════════════════════════════════╝
                """);
    }

    static void AccountMenu() {
    System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║  [1] BALANCE INQUIRY                                 ║
                ║  [2] WITHDRAWAL                                      ║ 
                ║  [3] DEPOSIT                                         ║
                ║  [4] WIRE TRANSFER / ELECTRONIC FUND TRANSFER (EFT)  ║
                ║  [5]EXIT APPLICATION                                 ║
                ╚══════════════════════════════════════════════════════╝
                """);
    }
}
