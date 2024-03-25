package lab5.Exercise1;

public class TestShape {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("Red", 5.0, 6.0);
        System.out.println(rectangle + ", Area: " + rectangle.getArea());

        Triangle triangle = new Triangle("Blue", 4.0, 7.0);
        System.out.println(triangle + ", Area: " + triangle.getArea());
    }
}
