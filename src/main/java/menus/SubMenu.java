package menus;

import model.Handler;
import net.bytebuddy.jar.asm.Handle;
import persistence.HandlerRepository;
import util.DBUtil;

import java.util.Scanner;

public class SubMenu {
    private HandlerRepository hr;


    public SubMenu() {
    this.hr = new HandlerRepository();
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
                    menuAddHandler(input);
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

    public void menuAddHandler(Scanner input){
        Handler handler = new Handler();

        System.out.println("You are adding a new handler!");
        System.out.println("Please enter first name:");
        handler.setFirstName(input.next());
        System.out.println("Please enter last name:");
        handler.setLastName(input.next());
        System.out.println("Please enter phone number;");
        handler.setPhoneNumber(input.next());
        System.out.println("Please enter email");
        handler.setEmail(input.next());
        hr.addHandler(handler);
        System.out.println("Handler added!");

        menuChoice(input);
    }

    

}
