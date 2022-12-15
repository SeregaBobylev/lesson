package calc;

import java.util.Stack;

import static calc.TokenType.typeChar.*;


public class Calculator {
    private char[] current;
    private Stack<Character> convertStack;
    private Token head = null, tail = null;

    public Calculator(String current) {
        System.out.println(calculating(reversePolishNotation(current)));
    }

    private double calculating(Token notation) {
        Stack<Token> tempStack = new Stack<>();
        double number1, number2;
        while (notation != null) {
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
                    tempStack.push(new Token(Double.toString(number1 / number2), NUMBER, null));
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
        Stack<Token.typeChar> symbol = new Stack<>();
        Lexer lexer = new Lexer(current);
        while (lexer.getLookAhead() != null) {
            switch (lexer.getLookAhead().type) {
                case NUMBER:
                    setElement(new Token(lexer.getLookAhead().value, NUMBER, null));
                    break;
                case PLUS, MINUS, OPEN:
                    while (!symbol.empty()) {
                        if (symbol.peek() == DIVISION || symbol.peek() == MULTIPLIED) {
                            setElement(new Token(null, symbol.pop(), null));
                        } else
                            break;
                    }
                    symbol.push(lexer.getLookAhead().type);
                    break;
                case DIVISION, MULTIPLIED:
                    while (!symbol.empty()) {
                        if (symbol.peek() == lexer.getLookAhead().type) {
                            setElement(new Token(null, symbol.pop(), null));
                        } else
                            break;
                    }
                    symbol.push(lexer.getLookAhead().type);
                    break;
                case DEGREE:
                    break;
                case CLOSE:
                    while (symbol.peek() != OPEN) {
                        setElement(new Token(null, symbol.pop(), null));
                    }
                    symbol.pop();
                    break;

            }
            lexer.shift();
        }
        while (!symbol.empty()) {
            setElement(new Token(null, symbol.pop(), null));
        }
        while (head!=null){
            System.out.println(head.value);
            head=head.next;
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
