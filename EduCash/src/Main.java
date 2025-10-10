import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Class instantation
        UI ui = new UI();
        AccountHandler accountHandler = new AccountHandler();

        //Variable Declaration and Initialization
        boolean isRunning = true;
        int choice;
        ui.appBanner();
        ui.startingMenu();
        
        while (isRunning) {
            System.out.print("CREATE OR CHOOSE AN EXISTING ACCOUNT>> ");
            choice = getValidChoice();

            switch (choice) {
                case 1 -> accountHandler.accountCreation();
                case 2 -> accountHandler.accountLogin();
                case 3 -> {
                    ui.exitMenu();
                    isRunning = false;
                }
            }
        }
    }

    /**
     * Prompts the user to enter a valid menu choice between 1 and 3.
     * Handles invalid input and ensures the returned value is within the valid range.
     *
     * @return a valid integer choice between 1 and 3
     */
    private static int getValidChoice() {
        int choice;
        while (true) {
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline character after reading integer input
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.print("INVALID INPUT! CHOOSE THE CHOICES BETWEEN 1 AND 3>> ");
                }
            } catch (InputMismatchException e) {
                System.out.print("INVALID INPUT! MUST BE A NUMBER BETWEEN 1 AND 3>> ");
                sc.nextLine(); // clear the invalid input
            }
        }
    }

}