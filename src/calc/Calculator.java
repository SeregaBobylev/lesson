package calc;

import java.util.Stack;

public class Calculator {
    private char[] current;
    private Stack<Character> convertStack;

    public Calculator(String current) {
        Lexer temp = new Lexer(current);
        String newExpression = "";
        Stack<Token.typeChar> symbol = new Stack<>();
        while (temp.getLookAhead()!=null){

            temp.shift();
        }


    }
}
