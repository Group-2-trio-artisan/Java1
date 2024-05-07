package session7;

import java.util.SortedSet;
import java.util.TreeSet;
//SortedSet: sắp xếp tăng dần. Ko trùng nhau
public class SortedSetExample {
    public static void sortedSetDemo(){
        //Khai bao SortedSet
        SortedSet<String> st = new TreeSet<String>();
        //Add() method to add elements
        st.add("Vinh");
        st.add("Văn");
        st.add("Ngọc");
        st.add("Hải");
        st.add("Anh");
        st.add("Hoàng");
        System.out.println("Initial TreeSet: " + st);
        //Remove the elements
        st.remove("Hải");
        st.add("Vinh");
        System.out.println("After remove and add: "+ st);
    }

    public static void main(String[] args) {
        sortedSetDemo();
    }
}
