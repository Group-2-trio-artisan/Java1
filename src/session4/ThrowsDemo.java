package session4;

import java.io.IOException;
import java.util.Scanner;

public class ThrowsDemo {
    // Chỗ này là chương trình ko muốn sử dụng try catch để xử lý mà ta sẽ đẩy trách nhiệm cho phương thức khách
    public static int inputAge() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tuoi cua ban: ");
        int age = scanner.nextInt();
        if (age <= 0) throw new IOException("Tuoi ko duoc nho hon 0");
        return age;
    }
    public static void getAge(){
        try {
            int age = inputAge();
            System.out.println("Tuoi vua nhap: " + age);
        }catch(Exception e){
            System.out.println("Tuoi ko phu hop");
        }
    }
}
