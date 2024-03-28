package lab6.III.Ex1;

public class Main {
    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(3, 4, 3);
            // Use the triangle object as needed
        } catch (InvalidTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
