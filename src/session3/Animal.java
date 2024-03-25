
package session3;
// Khai báo lớp
// Lớp này có thể chứa 1 or nhiu phương thức abstract
// Cho phép các lớp con kế thừa và thay đổi hành vi trong các method abstract
public abstract class Animal {
    private String name;
    public Animal(){
        // Gán giá trị mặc định cho name
        // this.name="Tom";
        this.name = this.getAnimalName();
    }

    public Animal(String name) {
        // Constructor này sẽ được gọi trong constructor của lớp Dog
        // Bằng từ khóa là super()
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Abstract: đây là lớp "trừu tượng" -> có thể được "sửa" ở lớp con
    // Lớp con định nghĩa lại hành vi mà nó muốn
    // Thể hiện tính chất Đa hình
    // Ko chứa mã(code) bên trong
    // Nó phải thuộc về 1 lớp abstract
    public abstract String getAnimalName();

}
