package session9.view;

import session9.controller.LoginController;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginConsoleUI{
    private final Scanner sc;
    public LoginConsoleUI() {
        this.sc = new Scanner(System.in);
    }

    //Step 1
    LoginController loginController = new LoginController();
    MVCLogin.entity.Users user = new MVCLogin.entity.Users();
    private int menu() {
        System.out.println("==========Admin zone==========");
        System.out.println("1.Login Statement");
        System.out.println("2.Login PreparedStatement");
        System.out.println("0.exit");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    private void loginStatementUI() throws SQLException {
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        //Step 1
        String result = loginController.loginStatementController(user);
        //Step 5
        System.out.println(result);
    }
    private void loginPrepareStatementUI() throws SQLException {
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        //Step 1
        String result = loginController.loginPreparedStatementController(user);
        //Step 5
        System.out.println(result);
    }
    public void start() throws SQLException {
        while(true){
            int choice = menu();
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    loginStatementUI();
                    break;
                case 2:
                    loginPrepareStatementUI();
                    break;
                default:throw new AssertionError();
            }
        }
    }


}
