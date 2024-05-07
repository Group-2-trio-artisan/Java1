package MVCLogin.view;

import MVCLogin.controller.LoginController;
import MVCLogin.entity.Users;

import java.io.IOException;
import java.util.Scanner;

public class LoginConsoleUI {
    LoginController loginController = new LoginController();
    Users user = new Users();
    private final Scanner scanner;
    public LoginConsoleUI() throws IOException{
        this.scanner = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("====Admin zone =======");
        System.out.println("1.Login statement");
        System.out.println("2.Login Prepare statement");
        System.out.println("0.Exit");
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }
    private void loginStatement(){
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        //step 1 call controller
        String result = loginController.loginStatementController(user);
        System.out.println(result);

    }
    private void loginPrepareStatement(){
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        //step 1 call controller
        String result = loginController.loginPrepareController(user);
        // step 4 to view (return to view from model)
        System.out.println(result);
    }
    public void start(){
        while (true){
            int choice = menu();
            switch (choice){
                case 0 :
                    System.exit(0);
                    break;
                case 1:
                    loginStatement();
                    break;
                case 2:
                    loginPrepareStatement();
                    break;
                default:
                    System.out.println("khong co lua chon nao");
            }
        }
    }
}
