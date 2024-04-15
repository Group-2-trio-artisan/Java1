package com.example.slot15;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private static long balanceNumber = 1000000;
    static List<TransactionHistory> listHistory = new ArrayList<TransactionHistory>();

    public long getBalanceNumber(){
        return balanceNumber;
    }

    public static long transfer(long money){
        //Kiểm tra nếu số tiền nhỏ hơn 50.000 thì thông báo số tiền chuyển tối thiểu phải là 50.000
        //Nếu số tiền chuyển lớn hơn số dư thì thông báo tài khoản không đủ
        //Nếu chuyển thành công, thì thông báo chuyển khoản thành công, in ra số dư mới và thêm lịch sử giao dịch mới
        if(money < 50000){
            System.out.println("Số tiền chuyển tối thiểu phải là 50.000");
        }
        else if(money > balanceNumber){
            System.out.println("Số dư tài khoản ko đủ");
        } else {
            long newbalance = balanceNumber - money;
            System.out.println("Số dư khả dụng: \n" + newbalance);
            balanceNumber = newbalance;
            //Thêm lịch sử giao dịch mới
        }

        return balanceNumber;

    }

    public static void actionTransfer(){
        //Thực hiện các công việc như nhập số tài khoản thụ hưởng, số tiền mô tả tại đây
        System.out.println("Nhập TK thụ hưởng: ");
        Scanner scanner = new Scanner(System.in);
        String receiveAccountNumber = scanner.nextLine();
        System.out.println("Nhập tiền muốn chuyển: ");
        long amount = scanner.nextLong();
        System.out.println("Nhập mô tả: ");
        scanner.nextLine();
        String description = scanner.nextLine();
        LocalDate currentDate = LocalDate.now();
        TransactionHistory history = new TransactionHistory();
        history.setMoney(amount);
        history.setDescription(description);
        history.setBeneficiaryAccount(receiveAccountNumber);
        history.setDayTrading(currentDate);
        listHistory.add(history);
        transfer(amount);
    }

    public void getHistory(){
        //In danh sách lịch sử giao dịch

        System.out.println("Lịch sử giao dịch:");
        System.out.println("-------------------");

        for (TransactionHistory history : listHistory) {
            history.setId(IdGenerate.getNewId());
            System.out.println("ID: " + history.getId());
            System.out.println("Ngày: " + history.getDayTrading());
            System.out.println("Mô tả: " + history.getDescription());
            System.out.println("TK thụ hưởng: " + history.getBeneficiaryAccount());
            System.out.println("Số tiền: " + Controller.formatMoney(history.getMoney()));
            System.out.println("-------------------\n");
        }

    }

    //Định dạng số tiền theo mình mong muốn
    public static String formatMoney(long money){
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        //100000->100,000.00
        return formatter.format(money);
    }
}
