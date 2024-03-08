package controller;

import model.service.User;
import model.service.UserService;
import model.service.UserServiceImpl;

import java.util.*;

public class UserController {
    private static final UserService service = new UserServiceImpl();
    public void getAllUsers() {
        service.getAllUsers()
                .stream()
                .filter(user -> !user.getIsDeleted())
                .forEach(user -> {
                    System.out.println(STR."User Id : \{user.getUserId()}");
                    System.out.println(STR."User UUID : \{user.getUserUuid()}");
                    System.out.println(STR."User Name : \{user.getUserName()}");
                    System.out.println(STR."User Email: \{user.getUserEmail()}");
                    System.out.println(STR."User Password: \{user.getUserPassword()}");
                    System.out.println(STR."Delete Status : \{user.getIsDeleted()}");
                    System.out.println(STR."Verifcation Status : \{user.getIsVerified()}");
                    System.out.println("=".repeat(50));
                });
    }
    public void addUser() {
        System.out.println("> Insert user info".toUpperCase(Locale.ROOT));
        System.out.print("> User's name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("> User's email: ");
        String email = new Scanner(System.in).nextLine();
        // Generate UUID for user
        String userUuid = UUID.randomUUID().toString();
        // Generate random password for user
        String password = STR."\{UUID.randomUUID().toString()}@$#%^";
        // Add user and display the number of rows affected
        int rowsAffected = service.createUser(new User(null, userUuid, name, email, password, false, false));
        System.out.println(STR."Row(s) affected: \{rowsAffected}");
        System.out.println("> User added".toUpperCase(Locale.ROOT));
    }
    public void deleteUserById() {
        System.out.print("> Insert User ID: ");
        Integer userId = new Scanner(System.in).nextInt();
        // Check if the user with the given ID exists
        boolean userExists = service.getAllUsers().stream()
                .anyMatch(user -> user.getUserId().equals(userId));
        if (userExists) {
            int rowsAffected = service.deleteUserById(userId);
            System.out.println(STR."Row affected: \{rowsAffected}");
        } else {
            System.out.println(STR."User with ID \{userId} does not exist.");
        }
    }
    public void updateUserById() {
        System.out.print("> Insert user ID: ");
        int id = new Scanner(System.in).nextInt();
        boolean userExists = service.getAllUsers().stream()
                .anyMatch(user -> user.getUserId().equals(id));
        if (userExists) {
            System.out.print("> New User Name : ");
            String name = new Scanner(System.in).nextLine();
            System.out.print("> New User Email : ");
            String email = new Scanner(System.in).nextLine();
            System.out.println(STR."Row affected: \{service.updateUserById(id,
                    new User(id, UUID.randomUUID().toString(), name, email, UUID.randomUUID() + "@$#%^", false, false)
            )}");
        } else {
            System.out.println(STR."User with ID \{id} does not exist.");
        }
    }

}
