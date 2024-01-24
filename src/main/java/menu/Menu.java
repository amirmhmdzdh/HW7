package menu;

import service.*;
import utility.ApplicationContex;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = ApplicationContex.getUserService();
    private static final BrandService brandService = ApplicationContex.getBrandService();
    private static final CategoryService categoryService = ApplicationContex.getCategoryService();
    private static final ProductService productService = ApplicationContex.getProductService();
    private static final ShareholderService shareholderService = ApplicationContex.getShareholderService();
    private static final ShareholderBrandService shareholderBrandService = ApplicationContex.getShareholderBrandService();

    public Menu() {
    }



    public void publicMenu() throws SQLException {
            boolean back = false;
        while (!back) {
        System.out.println("*** welcom ***\nMENU");
            System.out.println("1-SIGN UP");
            System.out.println("2-Brand Menu");
            System.out.println("3-Category Menu");
            System.out.println("4-Product creation");
            System.out.println("5-Shareholder Menu");
            System.out.println("6-EXIT");
            System.out.println("Choose your number");

            int number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 0 -> back = true;
                case 1 -> signUp();
                case 2 -> brandMenu();
                case 3 -> categoryMenu();
                case 4 -> productMenu();
                case 5 -> shareholderMenu();
                case 6 -> System.out.println("EXIT\nGOODLUCK");
                default -> System.out.println("Invalid option!");
            }
        }
    }

    public static void brandMenu() throws SQLException {
        boolean back = false;

        while (!back) {
            System.out.println("Brand menu\n Please log in to your user account and then create a brand :)");
            System.out.println("1-login and Create a new brand");
            System.out.println("2-Brand editing");
            System.out.println("3-ِDelete brand");
            System.out.println("0-Back to the previous menu");

            System.out.print(" please enter your number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> back = true;
                case 1 -> signin();
                case 2 -> editbrand();
                case 3 -> deletebrand();


                default -> System.out.println("Invalid option!");
            }
        }
    }


    public static void categoryMenu() throws SQLException {
        boolean back = false;

        while (!back) {
            System.out.println("Category menu\n Please log in to your user account and then create a Category :)");
            System.out.println("1-login and Create a new Category");
            System.out.println("2-Category editing");
            System.out.println("3-ِDelete Category");
            System.out.println("0-Back to  previous menu");

            System.out.print(" please enter your number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> back = true;
                case 1 -> signIn();
                case 2 -> editcategory();
                case 3 -> deletecategory();


                default -> System.out.println("Invalid option!");
            }
        }
    }

    public static void productMenu() throws SQLException {
        boolean back = false;

        while (!back) {
            System.out.println("Product menu :)");
            System.out.println("1-Show brands and categories\nCreate product");
            System.out.println("2-product editing");
            System.out.println("3-ِDelete product");
            System.out.println("0-Back to  previous menu");

            System.out.print(" please enter your number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> back = true;
                case 1 -> showall();
                case 2 -> editeProduct();
                case 3 -> deleteProduct();


                default -> System.out.println("Invalid option!");
            }
        }
    }

    public static void shareholderMenu() throws SQLException {
        boolean back = false;

        while (!back) {
            System.out.println("Shareholder menu :)");
            System.out.println("1-Sign Up");
            System.out.println("2-Sign IN");
            System.out.println("3-ِedite Shareholder");
            System.out.println("4-delete Shareholder");
            System.out.println("5-edite Shareholder Brand");
            System.out.println("6-delete Shareholder Brand");
            System.out.println("0-Back to  previous menu");

            System.out.print(" please enter your number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> back = true;
                case 1 -> signUP();
                case 2 -> signIN();
                case 3 -> editeShareholder();
                case 4 -> deleteShareholder();
                case 5 -> editeShareholderBrand();
                case 6 -> deleteShareholderBrand();

                default -> System.out.println("Invalid option!");
            }
        }
    }

    public void signUp() throws SQLException {
        userService.signup();
    }

    public static void signIn() throws SQLException {
        userService.signIn();
        categoryService.CreateCategory();
    }

    public static void signin() throws SQLException {
        userService.signIn();
        brandService.CreateBrand();
    }

    public static void editbrand() throws SQLException {
        brandService.editBrand();

    }

    public static void editcategory() throws SQLException {
        categoryService.editeCategory();

    }

    public static void deletebrand() throws SQLException {
        brandService.deleteBrand();
    }

    public static void deletecategory() throws SQLException {
        categoryService.deleteCategory();
    }

    public static void showall() throws SQLException {
        productService.findallbrand();
        productService.findallcategory();
        productService.createProduct();
    }

    public static void editeProduct() throws SQLException {
        productService.editeProduct();
    }

    public static void deleteProduct() throws SQLException {
        productService.deleteProduct();
    }

    public static void signUP() throws SQLException {
        shareholderService.signUp();
    }

    public static void signIN() throws SQLException {
        shareholderService.signIn();
        shareholderBrandService.create();

    }

    public static void editeShareholder() throws SQLException {
        shareholderService.editeShareholder();

    }

    public static void deleteShareholder() throws SQLException {

        shareholderService.deleteShareholder();
    }


    public static void editeShareholderBrand() throws SQLException {

        shareholderBrandService.editeShareholderBrand();
    }

    public static void deleteShareholderBrand() throws SQLException {

        shareholderBrandService.editeShareholderBrand();
    }

}



