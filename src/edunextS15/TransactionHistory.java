package edunextS15;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static edunextS15.GetBalanceNumber.getBalanceNumber;
import static edunextS15.GetNewId.getNewId;

public class TransactionHistory {
    private Long id;
    private LocalDate dayTrading;
    private String description;
    private String beneficiaryAccount;
    private long money;
    public TransactionHistory(String description,String beneficiaryAccount, long money,LocalDate day){
        this.id = getNewId();
        this.dayTrading = day;
        this.description = description;
        this.beneficiaryAccount = beneficiaryAccount;
        this.money = money;
    }
    public TransactionHistory() {
    }


    public  String getBeneficiaryAccount(){
        return beneficiaryAccount;
    }
    public long getMoney(){
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return "TransactionHistory{" +
                "id=" + id +
                ", dayTrading=" + dayTrading +
                ", description='" + description + '\'' +
                ", beneficiaryAccount='" + beneficiaryAccount + '\'' +
                ", money=" + money +
                '}' ;
    }
}
