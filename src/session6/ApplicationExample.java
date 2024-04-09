package session6;

import java.util.ArrayList;

public class ApplicationExample {
    public static void main(String[] args) {
        Student student = new Student(1, "Ngoc", 20);
        ArrayList<Student> listStudents = new ArrayList<>();

        //Thêm sinh viên vào list
        listStudents.add(student);
        listStudents.add(new Student(2,"Binh",70));
        listStudents.add(new Student(3,"Ngoc",70));
        listStudents.add(new Student(4,"Tung",60));
        listStudents.add(new Student(5,"Thanh",70));
        listStudents.add(new Student(6,"Khoa",40));
        for (Student stu : listStudents){
            System.out.println(stu);
        }
        System.out.println("Tim kiem sv ");
        for (int i = 0; i<listStudents.size(); i++){
            if (listStudents.get(i).name.contains("Binh")){
                System.out.println(listStudents.get(i));
                listStudents.remove(listStudents.get(i));
            }
        }
        System.out.println("DS sau khi tim dc va xoa");
        for (Student stu2 : listStudents){
            System.out.println(stu2);
        }
    }
}
