package session4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowDemo {
    public static void validate(){
        try {
            //noi code
            int age = inputAge();
            if (age < 18){
                throw new ArithmeticException("Your age not validate");
            }else{
                System.out.println("Your age not Valid!!!");
            }
        }catch (InputMismatchException e){
            System.out.println("Input age not Valid!!!");
        }
    }
    public static int inputAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your age: ");
        int age = scanner.nextInt();
        return age;
    }
}
