package stack;

import java.util.ArrayList;
import java.util.Stack;

public class Test {
    static  MyStack<String> stack = new MyStack<>();
    static {
        stack.push("sergey");
        stack.push("oleg");
        stack.push("olga");
        stack.push("andrey");
        stack.push("goblin");
    }
    public static void main(String[] args) {
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
