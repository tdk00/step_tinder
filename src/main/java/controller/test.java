package controller;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(5);

        // Add elements to the list
        list.add("Welcome");
        list.add("to");
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.remove(0);
        System.out.println(list.get(0));
    }
}
