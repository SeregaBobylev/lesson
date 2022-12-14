package calc;

import javax.swing.*;

public class Lexer {
    private final String current;
    private Token nextToken; // tail

    private Token lookAhead; //head

    public Lexer(String expression) {
        current = expression;
        String tempString = "";
        char lastChar= expression.charAt(0);
        while (!expression.isEmpty()){
            if (!TokenType.getType(expression.charAt(0)).equals(TokenType.getType(lastChar))) {
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
        Token temp = new Token(tempString, TokenType.getType(lastChar), null);
        if (lookAhead != null) {
            nextToken.next = temp;
        } else
            lookAhead = temp;
        nextToken = temp;
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
