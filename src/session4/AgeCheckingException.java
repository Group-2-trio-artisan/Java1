package session4;
// Custom exception: Ngoại lệ do người dùng định nghĩa
public class AgeCheckingException extends Exception {
// Đây là phương thức tự định nghĩa
    public AgeCheckingException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "Loi nhap vao tuoi: " + super.getMessage();
    }
}
