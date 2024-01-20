package menu;

import service.UserService;
import utility.ApplicationContex;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = ApplicationContex.getUserService();

    public Menu() {
    }

    public void publicMenu() throws SQLException {
        System.out.println("*** welcom ***\nMENU");
        System.out.println("1-SIGN UP");
        System.out.println("2-SIGN IN");
        System.out.println("3-EXIT");
        System.out.println("Choose your number");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> signUp();
            case 2 -> signIn();
            case 3 -> System.out.println("EXIT\nGOODLUCK");
            default -> System.out.println("Invalid option!");
        }
    }

    public void signUp() throws SQLException {
        userService.signup();
    }

    public void signIn() throws SQLException {
        userService.signIn();
    }


}

