package session5;

import java.util.Scanner;

public class IntegerArrayDemo {
    Scanner scanner = new Scanner(System.in);

    //Input element to array
    public void createArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.println("Nhap pt array tai "+i+": ");
            arr[i] = scanner.nextInt();
        }
    }
    //Output array
    public void show(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + "\t");
        }
    }
    //sort asc
    public void ascSort(int arr[]){
        for (int i = 0; i < arr.length; i++)
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
    }
    //sort desc
    public void descSort(int arr[]){

    }
    static void stringArrayDemo(){
        String stringArray[] = new String[5];
        stringArray[0] = "Thu";
        stringArray[1] = "Vinh";
        stringArray[2] = "Hoang";
        stringArray[3] = "Vu";
        stringArray[4] = "Thao";

        for (int i = 0; i < stringArray.length; i++){
            System.out.print("String array at %d: %s\n"+stringArray[i]);
        }
    }
}
