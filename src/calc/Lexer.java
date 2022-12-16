package calc;

import javax.swing.*;

import static calc.TokenType.typeChar.NUMBER;

public class Lexer extends TokenType {
    private final String current;
    private Token nextToken; // tail

    private Token lookAhead; //head

    public Lexer(String expression) {
        current = expression;
        char lastChar = expression.charAt(0);
        String numberString = "";
        Token tempToken;
        while (true) {
            if (getType(lastChar) != NUMBER) {
                numberString = lastChar + "";
                tempToken = new Token(numberString, TokenType.getType(lastChar), null);
                if (lookAhead != null) {
                    nextToken.next = tempToken;
                } else
                    lookAhead = tempToken;
                nextToken = tempToken;
                numberString = "";
            } else {
                numberString += lastChar;
                if (getType(expression.charAt(0)) != NUMBER) {
//                    code in .
                    numberString = Double.toString(Double.parseDouble(numberString));
                    tempToken = new Token(numberString, NUMBER, null);
                    if (lookAhead != null) {
                        nextToken.next = tempToken;
                    } else
                        lookAhead = tempToken;
                    nextToken = tempToken;
                    numberString = "";
                }
            }
            lastChar = expression.charAt(0);
            expression = expression.substring(1);
            if (expression.isEmpty()) {
                if (getType(lastChar) != NUMBER) {
                    numberString = lastChar + "";
                    tempToken = new Token(numberString, TokenType.getType(lastChar), null);
                    if (lookAhead != null) {
                        nextToken.next = tempToken;
                    } else
                        lookAhead = tempToken;
                    nextToken = tempToken;
                } else {
                    if (!numberString.isEmpty())
                        numberString += lastChar;
                    else numberString = lastChar + "";
                    numberString = Double.toString(Double.parseDouble(numberString));
                    tempToken = new Token(numberString, NUMBER, null);
                    if (lookAhead != null) {
                        nextToken.next = tempToken;
                    } else
                        lookAhead = tempToken;
                    nextToken = tempToken;
                }
                break;
            }
        }
//        }
//        tempToken = new Token(tempString, TokenType.getType(lastChar), null);
//        if (lookAhead != null) {
//            nextToken.next = tempToken;
//        } else
//            lookAhead = tempToken;
//        nextToken = tempToken;
//        tempString = "";
    }

    public Token getLookAhead() {
        return lookAhead;
    }

    public Token getNextToken() {
        return lookAhead.next;
    }

    public void shift() {
        lookAhead = lookAhead.next;
    }
}
