package session3;

public class AppName {
    public static void main(String[] args) {
        Dog quick = new Dog("Quick", 5, 120);
        quick.getAnimalName();
        // Gọi các phương thức kế thừa của lớp cha
        System.out.println("Name: " + quick.getName());
        System.out.println("Animal Name: " + quick.getAnimalName());
        // Gọi các phương thức khai báo trên lớp Dog
        System.out.println("Age: " + quick.getAge());
        System.out.println("Height: " + quick.getHeight());
        System.out.println("====================");



        Cat Tom = new Cat("Tom", 3, 30, true);
        System.out.println("Name: " + Tom.getName());
        System.out.println("Animal Name: " + Tom.getAnimalName());
        System.out.println("Age: " + Tom.getAge());
        System.out.println("Height: " + Tom.getHeight());
        System.out.println("Fly: " + Tom.getFly());
        System.out.println("====================");

        //Thể hiện tính đa hình
        Dog quick2 = new PhuQuocDog("PQ Dog", 3, 130);
        System.out.println("Animal name: " + quick2.getAnimalName());
    }
}
