package lab4;

public class Cylinder extends Circle { // Kế thừa của lớp cha
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);// Để tham chiếu trực tiếp đến biến instance của lớp cha.
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override //Cho phép một lớp con cung cấp một định nghĩa mới cho một phương thức đã được định nghĩa trong lớp cha của nó
    public double getArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + height);
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }
}
