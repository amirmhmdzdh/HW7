package service;

import model.User;
import repository.UserRepository;
import utility.InputValidation;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup() throws SQLException {
        System.out.println("please enter your name:");
        String name = scanner.next();


        String userName;
        while (true) {

            System.out.println("please enter your username:");
            userName = scanner.next();
            if (InputValidation.isValidUsername(userName))
                break;
            else
                System.out.println("please enter correct username");
        }


        String email;
        while (true) {
            System.out.println("please enter your Email:");
            email = scanner.next();

            if (InputValidation.isValidEmail(email))
                break;
            else
                System.out.println("please enter a correct Email");
        }

        String password;
        while (true) {

            System.out.println("please enter your password:");
            password = scanner.next();
            if (InputValidation.isValidPassword(password))
                break;
            else
                System.out.println("please enter correct password");
        }
        User user = new User(name, userName, email, password);
        int result = userRepository.registerUser(user);

        if (result == 1)
            System.out.println(name + "you successfully is signup :)");
        else
            System.out.println("something is wrong :/");
    }

    public void signIn() throws SQLException {
        System.out.println("please enter your username:");
        String userName = scanner.next();

        System.out.println("please enter your password:");
        String password = scanner.next();

        User user = userRepository.findUser(userName);
        if (user == null)
            System.out.println("please register first");

        else if (!user.getPassword().equals(password)) {
            System.out.println("please enter correct password");
        } else
            System.out.println("WELCOME " + user.getUserName());
        System.out.println();

    }
}
