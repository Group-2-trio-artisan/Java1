package edunextS15;

import java.util.Scanner;

import static edunextS15.ValidateAccount.checkAccount;

public class Check {
    public static boolean check(){
        Scanner scanner = new Scanner(System.in);
        boolean isCheck = false;
        while (!isCheck){
            System.out.println("Nhap so dien thoai");
            String mobile = scanner.nextLine();
            System.out.println("Nhap mat khau");
            String password = scanner.nextLine();
            isCheck = checkAccount(mobile,password);
        }
        return isCheck;
    }
}
