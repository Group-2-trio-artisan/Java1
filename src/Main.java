import session2.Person;

public class Main{
    public static void main(String[] args){
        Person newName = new Person();
        newName.getId();
        newName.setName("Hai");
        newName.setBornYear(1998);
        newName.setPhone("123456789");

        Person truongGia = new Person("Binh",1954,"09123456");
        Person truongTung = new Person("Tung",1956,"09123456");
        Person noname;// Chưa cập phát và khởi tạo
        //Lấy tên của đối tượng getter
        truongGia.getName();
        //Đổi tên của đối tượng setter
        truongGia.setName("new Name");

    }
}
