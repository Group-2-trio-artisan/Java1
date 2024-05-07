package edunextS15;

import java.time.LocalDate;
import java.util.Scanner;

import static edunextS15.Transfer.transfer;

public class ActionTransfer {
    public static void actionTransfer(){
        try{
            Scanner scanner = new Scanner(System.in);
            // thuc hien cac cong viec nhap so tai khoan thu huong,so tien mo ta tai day
            System.out.println("Nhap so tai khoan thu huong: ");
            String bankAccount = scanner.nextLine();
            System.out.println("Loi nhan: ");
            String description = scanner.nextLine();
            System.out.println("Nhap so tien can chuyen: ");
            long money = scanner.nextLong();
            LocalDate date = LocalDate.now();
            transfer(description,bankAccount,money,date);
        }catch (Exception e){
            System.out.println("ban da nhap sai , vui long nhap lai");
        }
    }
}
