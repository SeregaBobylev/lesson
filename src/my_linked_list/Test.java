package my_linked_list;

import java.util.LinkedList;

public class Test {
    static MyLinkedList<String> listEmail = new MyLinkedList<>();

    static {
        listEmail.add("serega@mail.com");
        listEmail.add("olga@mail.com");
        listEmail.add("oleg@mail.com");
        listEmail.add("alex@mail.com");
        listEmail.add("andrey@mail.com");
    }

    public static void main(String[] args) {
        System.out.println(listEmail.get(0));
        System.out.println(listEmail.remove(0));
        System.out.println(listEmail.remove("oleg@mail.com"));
        System.out.println(listEmail.get(0));
        System.out.println(listEmail.get(1));
        System.out.println(listEmail.get(2));
        System.out.println(listEmail.contains("andrey@mail.com"));
        System.out.println(listEmail.contains("serega@mail.com"));

    }

}
