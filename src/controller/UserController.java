package controller;

import model.service.User;
import model.service.UserService;
import model.service.UserServiceImpl;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;
public class UserController {
    private static final UserService service = new UserServiceImpl();
    public void getAllUsers(){
        service.getAllUsers().stream().filter(user -> user.getIsDeleted().equals(false)).forEach(System.out::println);
    }
    public void addUser(){
        System.out.println("> Insert user info".toUpperCase(Locale.ROOT));
        System.out.println("====");
        System.out.print("> User's name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("> User's email: ");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Row affected: " + service.createUser(
                new User(null, UUID.randomUUID().toString(),name,email,UUID.randomUUID().toString()+"@$#%^",false,false)
        ));
    }
    public void deleteUserById(){
        System.out.print("> Insert User ID: ");
        Integer userId = new Scanner(System.in).nextInt();
        System.out.println("Row affected: " + service.deleteUserById(userId));
    }
    public void updateUserById(){
        System.out.print("> Insert user ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Row affected: " + service.updateUserById(id,
                new User(1, UUID.randomUUID().toString(),"SoPi Takk","sopi123@gmail.com","2323",false,false)
        ));
    }
}
