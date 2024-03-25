package lab5.Exercise1;

abstract class Shape {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    abstract double getArea();

    @Override
    public String toString() {
        return "Color: " + color;
    }
}