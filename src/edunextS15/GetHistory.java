package edunextS15;

import static edunextS15.ListHistory.listHistory;

public class GetHistory {
    public static void getHistory(){
        // in danh sach lich su giao dich
        for (TransactionHistory
                s : listHistory){
            System.out.println(s);
        }
    }
}
