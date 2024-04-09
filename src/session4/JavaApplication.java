package session4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaApplication {
//    khối lệnh try catch finally
//    try{
//       code có thể ném ra ngoại lệ
//    }catch (Exception_class_name e){
//       code xử lý ngoại lệ
//    }finally{
//       code trong khối này luôn được thực thi
//    }
//    Một số phương thức(Method) của lớp Exception
//    getMessage(): trả về một message cụ thể về exception đã xảy ra
//    getCause(): Trả về nguyên nhân xảy ra exception
//    toString(): Trả về tên của lớp và kết hợp với kết quả từ phương thức getMessage()
//    printStackTrace(): In ra kết quả của phương thức toString cùng với stack trace đến System.error
//    fillInStackTrace(): Làm đầy stack trace của đối tượng Throwable bằng stack trace hiện tại

// Throw và Throws
// Từ khóa Throw trong java được sử dụng để ném ra một ngoại lệ (Exception) cụ thể
// Chúng ta có thể ném ra 2 ngoại lệ check và uncheck trong java bằng từ khóa throw
// Từ khóa throw chủ yếu được sử dụng để ném ra ngoại lệ tùy chỉnh
// (ngoại lệ do người dùng định nghĩa)
// Sau Throw là một hoặc nhiều instance
// Ko thể Throw nhiều exceptions
//
// Từ khóa Throws
// Từ khóa Throws trong java được sử dụng khi bạn k muốn phải xây dựng Try Catch bên trong 1 phương thức nào đó
// Bạn "đẩy trách nhiệm" phải try catch này cho phương thức nào đó bên ngoài có gọi đến nó phải try catch giúp bạn
// Sau câu lệnh Throws này là một hoặc nhiều class
// Có thể khai báo nhiều exceptions
// Ví dụ: public void methodName() throws IOException, SQLException{...}
    public static void main(String[] args) {
//        ThrowDemo.validate();
//        ThrowsDemo.getAge();

//        Custom exception
        try {
            int age = inputAge();
            System.out.println("Tuoi da nhap: " + age);
        }catch (AgeCheckingException e){
            System.out.println(e.getMessage());
        }
    }
    static int inputAge() throws AgeCheckingException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tuoi cua ban: ");
        int age = 0;
        try {
            age = scanner.nextInt();
            if (age < 0) throw new AgeCheckingException("Tuoi ko duoc nho hon 0");
        }catch (InputMismatchException e){
            throw new AgeCheckingException("Tuoi phai la so(number)");
        }
        return age;
    }







}
