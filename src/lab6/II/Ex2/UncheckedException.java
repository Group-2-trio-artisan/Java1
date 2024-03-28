package lab6.II.Ex2;

/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UncheckedException{
    /**
     * Constructor for objects of class Client
     */
    public UncheckedException() {
        // To do:
    }

    public static void main(String[] args) {
        int i, n = 2;
        int a[] = new int[n];

        // Declare Scanner Object named input
        java.util.Scanner input = new java.util.Scanner(System.in);
// mã lỗi ở đây
        for (i = 0; i < n; i++) {
            try {
                // in ra dạng "a[i] = ",i  để thông báo  đang nhập phần tử thứ i của mảng a[]
                System.out.printf("a[%d] = ", i);
                //đọc một số nguyên từ đầu vào (input) và gán cho phần tử thứ i của mảng a[].
                a[i] = input.nextInt();
                // nếu nhập ko phù hợp sẽ báo lỗi InputMismatch.... và hiển thị thông báo lỗi
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                // Clear the input buffer
                input.nextLine();
                i--; // Decrement i to reattempt input at the same index
            }
        }
    }
}