package session7;

import java.util.Iterator;
import java.util.LinkedHashSet;

//Duy trì thứ tự chèn, chứa các phần tử ko trùng nhau.
//Cho phép phần tử null
public class linkedHashSetExample {
    public static void linkedHashSetDemo(){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        //Adding elements
        linkedHashSet.add("Python");
        linkedHashSet.add("Java");
        linkedHashSet.add("C#");
        linkedHashSet.add("HTML");
        linkedHashSet.add("ASP.NET");
        linkedHashSet.add("ASP.NET");

        //Check exists
        System.out.println("Check exists: " + linkedHashSet.contains("C#"));
        System.out.println("LinkedHashSet: " + linkedHashSet);
        //Iterator: Dùng để lặp thông qua 1 LinkedHashSet
        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next() + " ");
        System.out.println();


        //Use foreach
        for (String str : linkedHashSet)
            System.out.println(str + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
        linkedHashSetDemo();
    }
}
