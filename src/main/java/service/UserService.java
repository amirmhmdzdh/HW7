package service;

import model.User;
import userrepository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
    this.userRepository=userRepository;
    }

    public void signup() throws SQLException {
        System.out.println("please enter your name:");
        String name = scanner.next();

        System.out.println("please enter your username:");
        String userName = scanner.next();

        System.out.println("please enter your Email:");
        String email = scanner.next();

        System.out.println("please enter your password:");
        String password = scanner.next();

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
        }
        else
            System.out.println("WELCOME " + user.getUserName());

    }
}
