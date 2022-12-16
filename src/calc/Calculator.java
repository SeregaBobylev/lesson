package calc;

import java.security.Key;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Stack;

import static calc.TokenType.typeChar.*;


public class Calculator extends TokenType{
    private Token head = null, tail = null;

    public Calculator(String current) {
        System.out.printf("%.2f%n",calculating(reversePolishNotation(current)));
    }

    private double calculating(Token notation) {
        Stack<Token> tempStack = new Stack<>();
        double number1, number2;
        while (notation != null) {
//            System.out.println(notation.value);
            switch (notation.type) {
                case NUMBER:
                    tempStack.push(new Token(notation.value, NUMBER, null));
                    break;
                case PLUS:
//                    System.out.println(tempStack.peek().value);
                    number1 = Double.parseDouble(tempStack.pop().value);
//                    System.out.println(tempStack.peek().value);
                    number2 = Double.parseDouble(tempStack.pop().value);
                    tempStack.push(new Token(Double.toString(number1 + number2), NUMBER, null));
                    break;
                case MINUS:
                    number1 = Double.parseDouble(tempStack.pop().value);
                    number2 = Double.parseDouble(tempStack.pop().value);
                    tempStack.push(new Token(Double.toString(number2 - number1), NUMBER, null));
                    break;
                case DEGREE:
                    break;
                case DIVISION:
                    number1 = Double.parseDouble(tempStack.pop().value);
                    number2 = Double.parseDouble(tempStack.pop().value);
                    tempStack.push(new Token(Double.toString(number2 / number1), NUMBER, null));
                    break;
                case MULTIPLIED:
                    number1 = Double.parseDouble(tempStack.pop().value);
                    number2 = Double.parseDouble(tempStack.pop().value);
                    tempStack.push(new Token(Double.toString(number1 * number2), NUMBER, null));
                    break;
            }
            notation = notation.next;
        }
        return Double.parseDouble(tempStack.pop().value);
    }

    private Token reversePolishNotation(String current) {
        Stack<typeChar> symbol = new Stack<>();
        Lexer lexer = new Lexer(current);
        HashMap<typeChar, Integer> lvl = new HashMap<>();
        lvl.put(NUMBER, 0);
        lvl.put(PLUS, 2);
        lvl.put(MINUS, 2);
        lvl.put(DIVISION, 3);
        lvl.put(MULTIPLIED, 3);
        lvl.put(CLOSE, -1);
        lvl.put(OPEN, 1);
        while (lexer.getLookAhead() != null) {
            switch (lvl.get(lexer.getLookAhead().type)) {
                case 0:
                    setElement(new Token(lexer.getLookAhead().value, NUMBER, null));
                    break;
                case 1:
                    symbol.push(lexer.getLookAhead().type);
                    break;
                case -1:
                    while (!symbol.empty()){
                        if(symbol.peek()==OPEN){
                            symbol.pop();
                            break;
                        }
                        setElement(new Token(null,symbol.pop(),null));
                    }
                    break;
                default:
                    while (!symbol.empty()) {
                        if (lvl.get(symbol.peek()) >= lvl.get(lexer.getLookAhead().type)) {
                            setElement(new Token(null, symbol.pop(), null));
                        } else break;
                    }
                    symbol.push(lexer.getLookAhead().type);
                    break;
            }
            lexer.shift();
        }
        while (!symbol.empty()) {
            setElement(new Token(null, symbol.pop(), null));
        }
        return head;
    }

    private void setElement(Token token) {
        if (head == null)
            head = token;
        else
            tail.next = token;
        tail = token;

    }
}
