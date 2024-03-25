package session3;

public class Cat extends Animal {
    private int age;
    private int height;
    private boolean fly;
    public Cat(String name, int age, int height, boolean fly) {
        super(name);
        this.age = age;
        this.height = height;
        this.fly = fly;
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

    public boolean getFly() {
        return fly;
    }

    public void setFly(boolean fly) {
        this.fly = fly;
    }
    @Override
    public String getAnimalName() {
        return "Cat";
    }
}
