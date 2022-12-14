package calc;

import java.util.Stack;

public class Calculator {
    private char[] current;
    private Stack<Character> convertStack;

    public Calculator(String current) {
        Lexer temp = new Lexer(current);
        Token head=null,tail=null;
        Stack<Token.typeChar> symbol = new Stack<>();
        while (temp.getLookAhead() != null) {
            switch (temp.getLookAhead().type) {
                case NUMBER:
                    Token tempToken = new Token(temp.getLookAhead().value, temp.getLookAhead().type, null);
                    if(head==null)
                        head = tempToken;
                    else
                        tail.next=tempToken;
                    tail=tempToken;
                    break;
                case PLUS, MINUS:
                    symbol
                    break;
                case DIVISION, MULTIPLIED:
                    break;
                case DEGREE:
                    break;
                case OPENBRACKET:
                    break;
                case CLOSEBRACKET:
                    break;

            }
            temp.shift();
        }


    }
}
