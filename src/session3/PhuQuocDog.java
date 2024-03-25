package session3;

public class PhuQuocDog extends Dog{
    public PhuQuocDog(String name, int age, int height) {
        super(name, age, height);
    }

    @Override// Thể hiện theo cách mà đối tượng muốn(tính Đa hình trong OOP)
    public String getAnimalName() {
        return "Phu Quoc Dog";
    }
}
