package xyz.kacperm.handler;

import xyz.kacperm.account.user.User;

import java.util.Scanner;

public class Program {

    // 1 - user login
    // 2 - teacher login
    // 3 - admin login
    // 4 - log out

    public void handle(){

        Scanner scanner;
        int result;

        do {
            System.out.println("Please enter action");
            System.out.println("""
                    1 - User login
                    2 - Teacher login
                    3 - Admin login
                    4 - Log out
                    """);
            scanner = new Scanner(System.in);
            result = scanner.nextInt();

            switch (result) {
                case 4 -> {
                    System.out.println("Logging out");
                    System.exit(1);
                }
                case 1 -> {
                    Scanner userScanner;
                    String user;
                    do {
                        System.out.println("Please enter username");
                        userScanner = new Scanner(System.in);
                        user = userScanner.nextLine();
                    } while (user.length() <= 0);
                    Scanner passwordScanner;
                    String password;
                    do {
                        System.out.println("Please enter password");
                        passwordScanner = new Scanner(System.in);
                        password = passwordScanner.nextLine();
                    } while (password.length() <= 7);

                    boolean exists = new User().validate(user, password);
                    if (!exists) {
                        System.out.println("Unknown username or password");
                        System.exit(1);
                    }
                }
            }
        } while (true);
    }
}
