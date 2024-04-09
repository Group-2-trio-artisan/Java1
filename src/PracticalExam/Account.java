package PracticalExam;

import java.util.Scanner;

public class Account {
    private String customerCode;
    private String customerName;
    private int accNumber;
    private long amount;

    public Account(String customerCode, String customerName, int accNumber, long amount) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.accNumber = accNumber;
        this.amount = amount;
    }


    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer code(must be 5 characters long):");
        customerCode = sc.next();
        while(customerCode.length() != 5){
            System.out.println("invalid customer code, must be 5 characters long, try again:");
            customerCode = sc.next();
        }
        System.out.println("Enter customer name:");
        customerName = sc.next();
        System.out.println("Enter account number(must be a positive number with 6 digits and starts with '100'): ");
        accNumber = sc.nextInt();
        while (String.valueOf(accNumber).length() != 6 || !String.valueOf(accNumber).startsWith("100")){
            System.out.println("invalid input, account number must be 6 digits and starts with '100', try again: ");
            accNumber = sc.nextInt();
        }
    }


    public void depositAndWithdraw(long money,int type){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose type(0 : deposit, 1 : withdraw)");
        type = scanner.nextInt();
        if(type == 0 && money >= 0) {
            System.out.println("Enter amount of money you want to deposit: ");
            money = scanner.nextInt();
            amount += money;
            System.out.println("Deposit successful.");
        } else if(type == 1 && money <= amount) {
            System.out.println("Enter amount of money you want to withdraw: ");
            money = scanner.nextInt();
            amount -= money;
            System.out.println("Withdraw successful.");
        } else {
            System.out.println(type == 0 ? "invalid type" : "“non- sufficient funds”");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "CustomerCode = '" + customerCode + '\'' +
                ", CustomerName = '" + customerName + '\'' +
                ", AccNumber = " + accNumber +
                ", Amount = " + amount +
                '}';
    }

    public static void main(String[] args) {
        Account account = new Account("", "",5, 100000);
        account.input();
        account.depositAndWithdraw(100000,0);
        System.out.println("====================");

        System.out.println(account);
    }
}


