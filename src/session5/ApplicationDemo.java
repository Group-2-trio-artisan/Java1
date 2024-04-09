package session5;

import java.util.Scanner;

public class ApplicationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntegerArrayDemo integerArrayDemo = new IntegerArrayDemo();
        System.out.println("How many elements of array: ");
        int size = sc.nextInt();
        int intArray[] = new int[size];
        // Chuyển 1 mảng vào 1 hàm
        integerArrayDemo.createArray(intArray);
        integerArrayDemo.show(intArray);
        System.out.println();

        System.out.println("Length of array: " + intArray.length);
        System.out.println("Value of index 3: " + intArray[3]);

        integerArrayDemo.ascSort(intArray);

        //sort....
    }
}
