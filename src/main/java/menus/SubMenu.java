package menus;

import model.Animal;
import model.AnimalType;
import model.Handler;
import model.Login;
import model.Veterinarian;
import net.bytebuddy.jar.asm.Handle;
import persistence.AnimalRepository;
import persistence.AnimalTypeRepository;
import persistence.HandlerRepository;
import persistence.LoginRepository;
import persistence.VeterinarianRepository;
import util.DBUtil;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubMenu {
    private HandlerRepository hr;
    private VeterinarianRepository vr;
    private LoginRepository lr;
    private AnimalRepository ar;
    private AnimalTypeRepository atr;

    public SubMenu() {
    this.hr = new HandlerRepository();
    this.vr = new VeterinarianRepository();
    this.lr = new LoginRepository();
    this.atr = new AnimalTypeRepository;
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
        System.out.println("6: Add AnimalType");
        System.out.println("7: ");
        System.out.println("100 - Quit");

        return input.nextInt();
    }
    public void login(Scanner input) {
        System.out.println("Please enter the username");
        String name = input.next();
        System.out.println("Please enter the password");
        String password = input.next();

        Login login = new Login();
        login.setUserName(name);

        login.setPassword(password);
        boolean result = lr.validateLogin(login);

        if(result) {
            menuChoice(input);
        } else {
            System.out.println("Username or Password invalid. Access denied.");
            DBUtil.shutdown();
            input.close();
        }

    }

    public boolean isUsernameValid(String user) {

        String regExpn = "^[a-zA-Z0-9]+(?=\\S+$)$";

        Pattern pattern = Pattern.compile(regExpn);
        Matcher matcher = pattern.matcher(user);

        return (matcher.matches());
    }

    public boolean isPasswordValid(String pass) {

        String regExpn = "^{8,}$";

        Pattern pattern = Pattern.compile(regExpn);
        Matcher matcher = pattern.matcher(pass);

        return (matcher.matches());
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
                    menuAddVeterinarian(input);
                    break;
                case 3:
                    menuFindHandlerById(input);
                    break;
                case 4:
                    menuSearchVeterinarianByName(input);
                    break;
                case 5:
                    menuListAnimals();
                    break;
                case 6:
                    menuAnimalType(input);
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

    public void menuAddVeterinarian(Scanner input){
        Veterinarian veterinarian = new Veterinarian();

        System.out.println("You are adding a new veterinarian!");
        System.out.println("Please enter first name:");
        veterinarian.setFirstName(input.next());
        System.out.println("Please enter last name:");
        veterinarian.setLastName(input.next());
        System.out.println("Please enter phone number;");
        veterinarian.setPhoneNumber(input.next());
        System.out.println("Please enter email");
        veterinarian.setEmail(input.next());
        vr.addVeterinarian(veterinarian);
        System.out.println("Veterinarian added!");

        menuChoice(input);
    }


    public void menuSearchVeterinarianByName(Scanner input) {
        System.out.println("Please enter the Veterinarian name");
        String name = input.next();
        List<Veterinarian> VeterinarianList = vr.searchByName(name);
        System.out.println("The following Veterinarians found:");
        for (Veterinarian m : VeterinarianList)
            System.out.println(m);
    }

    public void menuAnimalType(Scanner input){
        System.out.println("Enter handlers' id:");
        int id = input.nextInt();
        System.out.println(hr.findById(id));
    }

    public void menuListAnimals(){
        List<Animal> result = ar.listAnimals();
        System.out.println("Animals:");
        for (Animal animal : result){
            System.out.println(animal);
        }
    public void menuAddAnimalType(Scanner input){
       AnimalType AnimalType = new AnimalType();

        System.out.println("You are adding a new veterinarian!");
        System.out.println("Please enter animal type:");
        AnimalType.setAnimalType(input.next());
        atr.addAnimalType(AnimalType);
        System.out.println("Animal type added!");

        menuChoice(input);
    }
}
