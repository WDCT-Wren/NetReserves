import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean validChoice = false;
        int choice;
        ui.appBanner();
        ui.startingMenu();
        
        while (!validChoice) {
            try {
                System.out.print("CREATE OR CHOOSE AN EXISTING ACCOUNT>> ");
                choice = sc.nextInt();
                if (choice > 3 || choice < 1) {
                    System.out.print("INVALID INPUT! CHOOSE THE CHOICES BETWEEN 1 AND 3>> ");
                    choice = sc.nextInt();
                    sc.nextLine();
                }
                else {
                    validChoice = true;
                }
            } catch (InputMismatchException e) {
                System.out.print("INVALID INPUT! MUST BE A NUMBER BETWEEN 1 AND 3>> ");
                sc.nextLine();
            }
        }
    }
}