package ua.training;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyBufferedArrayList<String> strings = new MyBufferedArrayList<>();

        strings.add("Mama");
        strings.add("Papa");
        strings.add("Bodya");
        strings.add("Vika");

        System.out.println(strings.get(2));
        System.out.println(strings.length());

        for (String s : strings) {
            System.out.println(s);
        }

        strings.put(2, "Adopted child");

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
