package menu;

import service.BrandService;
import service.UserService;
import utility.ApplicationContex;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = ApplicationContex.getUserService();
    private static final BrandService brandService = ApplicationContex.getBrandService();

    public Menu() {
    }

    public void publicMenu() throws SQLException {
        System.out.println("*** welcom ***\nMENU");
        System.out.println("1-SIGN UP");
        System.out.println("2-Brand Menu");
        System.out.println("3-EXIT");
        System.out.println("Choose your number");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> signUp();
            case 2 -> brandMenu();
            case 3 -> System.out.println("EXIT\nGOODLUCK");
            default -> System.out.println("Invalid option!");
        }
    }

    public static void brandMenu() throws SQLException {
        boolean back = false;

        while (!back) {
            System.out.println("Brand menu\n Please log in to your user account and then create a brand :)");
            System.out.println("1-login and Create a new brand");
            System.out.println("2-Add brand");
            System.out.println("3-Brand editing");
            System.out.println("4-ِDelete brand");
            System.out.println("0-Back to the previous menu");

            System.out.print(" please enter your number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> back = true;
                case 1 -> signIn();
                case 2 -> addbrand();
                case 3 -> editbrand();
                case 4 -> deletebrand();


                default -> System.out.println("Invalid option!");
            }
        }
    }


    public static void categoryMenu() throws SQLException {
        boolean back = false;

        while (!back) {
            System.out.println("Category menu\n Please log in to your user account and then create a Category :)");
            System.out.println("1-login and Create a new Category");
            System.out.println("2-Add Category");
            System.out.println("3-Category editing");
            System.out.println("4-ِDelete Category");
            System.out.println("0-Back to  previous menu");

            System.out.print(" please enter your number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> back = true;
                case 1 -> signIn();
                case 2 -> addbrand();
                case 3 -> editbrand();
                case 4 -> deletebrand();


                default -> System.out.println("Invalid option!");
            }
        }
    }






    public void signUp() throws SQLException {
        userService.signup();
    }

    public static void signIn() throws SQLException {
        userService.signIn();
        brandService.CreateBrand();
    }
    public static void signin() throws SQLException {
        userService.signIn();
        brandService.CreateBrand();
    }


    public static void addbrand() throws SQLException {
        brandService.addBrand();

    }

    public static void editbrand() throws SQLException {
        brandService.editBrand();

    }
  public static void deletebrand() throws SQLException {
        brandService.deleteBrand();
  }


}
