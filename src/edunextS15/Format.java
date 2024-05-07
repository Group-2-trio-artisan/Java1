package edunextS15;

import java.text.DecimalFormat;

public class Format {
    public static String formatMoney(long money){
        DecimalFormat formater = new DecimalFormat("###,###,###.00");
        // 100000 -> 100,000.00
        return formater.format(money);
    }
}
