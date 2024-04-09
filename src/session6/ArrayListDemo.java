package session6;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void arrayListMethod(){
        //ArrayList tạo bằng 2 cách

        //Cách 1:
        ArrayList<String> student = new ArrayList<>();

        //Cách 2:
        List<String> animal = new ArrayList<>();

        //Thêm phần tử vào ArrayList vừa tạo
        student.add("Ngoc");
        student.add("Vinh");
        student.add("Hung");
        student.add("Dat");
        student.add("Hai");
        //Hiển thị thông tin
        //System.out.println(student);
        //display(student);
        //System.out.println("=======================");
        show(student);
        System.out.println("=======================");

        student.add(2,"Thu");
        display(student);
        System.out.println("=======================");

        student.addFirst("Manh");
        student.addLast("Duong");
        display(student);
        System.out.println("=======================");
        int size = student.size();
        display(student);
        System.out.println("=======================");

        //Lấy 1 phần tử theo index
        String st = student.get(1);

        //Lấy pt đầu tiên
        String firstStudent = student.getFirst();//student.getLast()
        System.out.println("SV dau tien: "+firstStudent);

        //Sửa giá trị
        student.set(4, "new name at index 4");
        System.out.println("The final list after updated");
        display(student);

        //Xóa phần tử đầu tiên và lấy ra
        String first = student.removeFirst();
        //Remove bất kỳ
        student.remove(1);
        student.remove("Thu");
        System.out.println("=======================");
        //Xóa toàn bộ
        student.clear();
        size = student.size();
        System.out.println("ArrayList sau khi clear: "+ size);
        System.out.println("List sau khi clear");
        display(student);
        System.out.println("=======================");
    }
    public static void display(ArrayList list){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static void show(ArrayList list){
        //Sử dụng foreach để in thông tin
        for (Object arrList : list){
            System.out.println(arrList);
        }
    }

    public static void main(String[] args) {
//        ArrayListDemo arrayListDemo = new ArrayListDemo();
//        arrayListDemo.arrayListMethod();

          arrayListMethod();
    }
}
