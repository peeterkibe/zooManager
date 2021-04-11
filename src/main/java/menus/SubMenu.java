package menus;

import util.DBUtil;

import java.util.Scanner;

public class SubMenu {
    public SubMenu() {

    }

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the option menu: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Add Handler");
        System.out.println("2: Add Veterinarian");
        System.out.println("3: Search Handler by Id");
        System.out.println("4: Search Veterinarian by Name");
        System.out.println("5: List all Animals");
        System.out.println("6: List animals by Animal Type");
        System.out.println("7: ");
        System.out.println("100 - Quit");

        return input.nextInt();
    }
    public void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 100:
                    DBUtil.shutdown();
                    input.close();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
        System.out.println("Closing system...");
        System.out.println("Thank you. Good Bye.");
    }
}
