package calc;

import java.security.Key;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Stack;

import static calc.Type.*;


public class Calculator {
    private Token head = null, tail = null;

    public Calculator(String current) {
        System.out.printf("%.2f%n", calculating(reversePolishNotation(current)));
    }

    private double calculating(Token notation) {
        Stack<Token> tempStack = new Stack<>();
        double number1, number2;
        while (notation.type != END) {
            switch (notation.type) {
                case NUMBER:
                    tempStack.push(notation);
                    break;
                case PLUS:
                    number1 = Double.parseDouble(tempStack.pop().value);
                    number2 = Double.parseDouble(tempStack.pop().value);
                    tempStack.push(new Token(Double.toString(number1 + number2), NUMBER));
                    break;
                case MINUS:
                    number1 = Double.parseDouble(tempStack.pop().value);
                    number2 = Double.parseDouble(tempStack.pop().value);
                    tempStack.push(new Token(Double.toString(number2 - number1), NUMBER));
                    break;
                case DEGREE:
                    break;
                case DIVISION:
                    number1 = Double.parseDouble(tempStack.pop().value);
                    number2 = Double.parseDouble(tempStack.pop().value);
                    tempStack.push(new Token(Double.toString(number2 / number1), NUMBER));
                    break;
                case MULTIPLIED:
                    number1 = Double.parseDouble(tempStack.pop().value);
                    number2 = Double.parseDouble(tempStack.pop().value);
                    tempStack.push(new Token(Double.toString(number1 * number2), NUMBER));
                    break;
            }
            notation = notation.next;
        }
        return Double.parseDouble(tempStack.pop().value);
    }

    private Token reversePolishNotation(String current) {
        Stack<Type> symbol = new Stack<>();
        Lexer lexer = new Lexer(current);
        HashMap<Type, Integer> lvl = new HashMap<>();
        lvl.put(NUMBER, 0);
        lvl.put(DEGREE, 4);
        lvl.put(PLUS, 2);
        lvl.put(MINUS, 2);
        lvl.put(DIVISION, 3);
        lvl.put(MULTIPLIED, 3);
        lvl.put(CLOSE, -1);
        lvl.put(OPEN, 1);
        while (lexer.getLookAhead().type != END) {
            switch (lexer.getLookAhead().type) {
                case NUMBER:
                    setElement(new Token(lexer.getLookAhead().value, NUMBER));
                    break;
                case OPEN:
                    symbol.push(lexer.getLookAhead().type);
                    break;
                case CLOSE:
                    while (!symbol.empty()) {
                        if (symbol.peek() == OPEN) {
                            symbol.pop();
                            break;
                        }
                        setElement(new Token(null, symbol.pop()));
                    }
                    break;
                default:
                    while (!symbol.empty()) {
                        if (lvl.get(symbol.peek()) >= lvl.get(lexer.getLookAhead().type)) {
                            setElement(new Token(null, symbol.pop()));
                        } else break;
                    }
                    symbol.push(lexer.getLookAhead().type);
                    break;
            }
            lexer.shift();
        }

        while (!symbol.empty())
            setElement(new Token(null, symbol.pop()));
        setElement(new Token(null, END));
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
