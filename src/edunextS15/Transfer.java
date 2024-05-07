package edunextS15;

import java.time.LocalDate;

import static edunextS15.Controller.balanceNumber;
import static edunextS15.ListHistory.listHistory;
import static edunextS15.Messenge.Mess;

public class Transfer {
    public static long transfer(String description, String beneficiaryAccount, long money, LocalDate day){
        if (money < 50000){
            System.out.println("So tien chuyen khong duoc nho hon 50k");
        }else if (money > balanceNumber){
            System.out.println("So tien chuyen lon hon so du cua tai khoan");
        }else {
            long bank = balanceNumber - money;
            balanceNumber = bank;
           Mess(money);
            TransactionHistory  newTransaction = new TransactionHistory(description,beneficiaryAccount,money,day);
            listHistory.add(newTransaction);
        }
        // kiem tra so tien neu so tien nho hon 50k thi thong bao so tien toi thieu phai chuyen
        // la 50 k
        // neu so tien chuyen lon hon so du thi thong bao tai khoan k du
        // neu chuyen thanh cong , thi thong bao chuyen khoan thanh cong,in ra so du moi va lich su giao dich
        return balanceNumber;
    }
}
