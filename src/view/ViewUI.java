package view;
import controller.UserController;
import java.util.Locale;
import java.util.Scanner;
public class ViewUI {
    private final UserController userController = new UserController();
    private void home(){
        System.out.println("+".repeat(20)+" CRUD OPERATION "+"+".repeat(20));
        System.out.println("1. Get All User".toUpperCase(Locale.ROOT));
        System.out.println("2. Create USER".toUpperCase(Locale.ROOT));
        System.out.println("3. Delete user by ID".toUpperCase(Locale.ROOT));
        System.out.println("4. Update user by id".toUpperCase(Locale.ROOT));
        System.out.println("5. Exit program".toUpperCase(Locale.ROOT));
        System.out.println("+".repeat(55));
    }
    private int option(){
        home();
        System.out.print("> Insert Option(1-5): ");
        return new Scanner(System.in).nextInt();
    }
    public void ui(){
        while (true){
            switch (option()){
                case 1 -> userController.getAllUsers();
                case 2-> userController.addUser();
                case 3 -> userController.deleteUserById();
                case 4 -> userController.updateUserById();
                case 5 -> System.exit(0);
                default -> System.out.println("Invailed Option!!!");
            }
        }
    }
}
