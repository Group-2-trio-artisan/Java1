package session3;

public class Dog extends Animal {
    private int age;
    private int height;

    public Dog(String name, int age, int height) {
        // Gọi tới constructor của Animal
        // Giá trị của Field trong lớp cha sẽ được gán
        // Constructor public Animal(String name) sẽ được gọi và gán giá trị
        super(name);
        // Sau đó giá trị Field trong lớp con mới được gán
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override// Thực hiện triển khai phương thức Abstract
    public String getAnimalName() {
        return "Dog";
    }

}
