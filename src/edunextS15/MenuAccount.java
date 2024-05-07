package edunextS15;

import java.util.Scanner;

import static edunextS15.ActionTransfer.actionTransfer;
import static edunextS15.Format.formatMoney;
import static edunextS15.GetBalanceNumber.getBalanceNumber;
import static edunextS15.GetHistory.getHistory;
import static edunextS15.Menu.menu;

public class MenuAccount extends Exception {
    public static void menuAccount(){
        Scanner scanner = new Scanner(System.in);
        try{
            while (true){
                menu();
                int chose = scanner.nextInt();
                switch (chose){
                    case 1:
                        System.out.println("So du");
                        long balance = getBalanceNumber();
                        System.out.println(formatMoney(balance));
                        break;
                    case 2:
                        actionTransfer();
                        break;
                    case 3:
                        System.out.println("Lich su giao dich");
                        getHistory();
                        break;
                    case 0:
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Khong co lua chon nay");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("Ban da nhap sai");
        }
    }
}
