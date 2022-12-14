package calc;

import java.util.Objects;
import java.util.Stack;

public class Calculator {
    private char[] current;
    private Stack<Character> convertStack;

    public Calculator(String current) {
        Lexer temp = new Lexer(current);
        System.out.println(temp);
        while(temp.getNextToken.value!=null){
            System.out.println(temp.getNextToken.value);
            temp.getNextToken=temp.getNextToken.nextToken;
        }
    }
}
