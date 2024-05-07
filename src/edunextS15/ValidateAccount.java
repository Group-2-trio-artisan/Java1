package edunextS15;

public class ValidateAccount {
    public static final String MOBILE = "000";
    public static final String PASSWORD = "ok";

    public static boolean checkAccount(String mobile, String password) {
        if (mobile.equals(MOBILE)) {
            if (password.equals(PASSWORD)) {
                System.out.println("Dang nhap thanh cong");
                return true;
            } else {
                System.out.println("Mat khau sai, vui long nhap lai");
                return false;
            }
        } else {
            System.out.println("Kiem tra lai so dien thoai hoac password");
            return false;
        }
    }
}
