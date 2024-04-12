package com.example.slot15;

public class ValidateAccount {

    //Kiểm tra đăng nhập
    public final String MOBILE = "0965700995";
    public final String PASSWORD = "vu26122005";
    public boolean checkAccount(String mobile, String password) {
        if (mobile.equals(MOBILE)) {
            if (password.equals(PASSWORD)) {
                System.out.println("Đăng nhập thành công!");
                return true;
            }else {
                System.out.println("Mật khẩu sai, vui lòng nhập lại");
                return false;
            }
        }else {
            System.out.println("Kiểm tra lai số điện thoại hoặc password");
            return false;
        }
    }

}
