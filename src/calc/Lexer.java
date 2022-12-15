package calc;

import javax.swing.*;

public class Lexer {
    private final String current;
    private Token nextToken; // tail

    private Token lookAhead; //head

    public Lexer(String expression) {
        current = expression;
        char lastChar= expression.charAt(0);
        String tempString =String.valueOf(expression.charAt(0));
        Token tempToken;
        while (!expression.isEmpty()){
            if (expression.charAt(0)==')' || expression.charAt(0)=='(' || !TokenType.getType(expression.charAt(0)).equals(TokenType.getType(lastChar))) {
                if(lastChar!=')' && lastChar!='(' && TokenType.getType(lastChar)==Token.typeChar.NUMBER  && !tempString.contains(".")){
                    tempString = Double.toString(Double.parseDouble(tempString));
                }
                Token temp = new Token(tempString, TokenType.getType(lastChar), null);
                if (lookAhead != null) {
                    nextToken.next = temp;
                } else
                    lookAhead = temp;
                nextToken = temp;
                tempString = "";
            }
            tempString += expression.charAt(0);
            lastChar = expression.charAt(0);
            expression = expression.substring(1);
        }
//        }
        tempToken = new Token(tempString, TokenType.getType(lastChar), null);
        if (lookAhead != null) {
            nextToken.next = tempToken;
        } else
            lookAhead = tempToken;
        nextToken = tempToken;
        tempString = "";
    }
    public Token getLookAhead() {
        return lookAhead;
    }
    public Token getNextToken() {
        return lookAhead.next;
    }
    public void shift(){
        lookAhead = lookAhead.next;
    }
}
