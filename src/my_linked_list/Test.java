package my_linked_list;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> listEmail = new MyLinkedList<>();
        listEmail.add("serega@mail.com");
        listEmail.add("olga@mail.com");
        listEmail.add("oleg@mail.com");
        listEmail.add("alex@mail.com");
        System.out.println(listEmail.size);
    }
}
