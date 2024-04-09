package session6;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LinkedListDemo {
  public static void demoLinkedList(){
      //Khởi tạo LinkedList
      LinkedList<String> student = new LinkedList<>();
      //Thêm danh sách
      student.add("Ngoc");
      student.add("Thanh");
      student.add("Tung");
      student.add("Binh");
      student.add("Trong");
      List<String> animal = new LinkedList<>();
      //Về cơ bản thì nó tương đương các phương thức trong ArrayList
      //add..., set..., get..., remove..., clear()
      //Poll(): Trả về pt đầu tiên và xóa khỏi danh sách
      student.poll();
      //pollLast() Trả về pt cuối và xóa khỏi danh sách
      student.pollLast();
      showList(student);
  }
  public static void showList(LinkedList list){
      for (Object linkedList : list){
          System.out.println(linkedList);
      }
  }

    public static void main(String[] args) {
        demoLinkedList();

    }

}
