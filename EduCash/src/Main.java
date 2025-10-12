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
        int userChoice;
        ui.appBanner();
        ui.startingMenu();
        
        while (isRunning) {
            System.out.print("CREATE OR CHOOSE AN EXISTING ACCOUNT>> ");
            userChoice = getValidUserChoice();

            switch (userChoice) {
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
     * Prompts the user to enter a valid menu userChoice between 1 and 3.
     * Handles invalid input and ensures the returned value is within the valid range.
     * Additionally, this uses exception handling if the input is not an integer.
     *
     * @return a valid integer userChoice between 1 and 3
     */
    private static int getValidUserChoice() {
        int userChoice;
        while (true) {
            try {
                userChoice = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline character after reading integer input
                if (userChoice >= 1 && userChoice <= 3) {
                    return userChoice;
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