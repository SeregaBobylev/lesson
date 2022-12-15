package calc;

import javax.swing.*;

public class Lexer extends TokenType{
    private final String current;
    private Token nextToken; // tail

    private Token lookAhead; //head

    public Lexer(String expression) {
        current = expression;
        char lastChar= expression.charAt(0);
        String tempString="";
        Token tempToken;
        while (!expression.isEmpty()){
            if (getType(lastChar)!= Token.typeChar.NUMBER) {
                Token temp = new Token(tempString, TokenType.getType(lastChar), null);
                if (lookAhead != null) {
                    nextToken.next = temp;
                } else
                    lookAhead = temp;
                nextToken = temp;
                tempString = "";
            }
            if(getType(expression.charAt(0))==typeChar.NUMBER)
            tempString += expression.charAt(0);
            else {
                if(!tempString.contains(".")){
                    tempString=Double.toString(Double.parseDouble(tempString));
                }
                Token temp = new Token(tempString, TokenType.getType(lastChar), null);
                if (lookAhead != null) {
                    nextToken.next = temp;
                } else
                    lookAhead = temp;
                nextToken = temp;
                tempString = "";
            }
            lastChar = expression.charAt(0);
            expression = expression.substring(1);
            if(expression.isEmpty()) {
                if(!tempString.contains(".")){
                    tempString=Double.toString(Double.parseDouble(tempString));
                }
                Token temp = new Token(tempString,typeChar.NUMBER, null);
                if (lookAhead != null) {
                    nextToken.next = temp;
                } else
                    lookAhead = temp;
                nextToken = temp;
                tempString = "";
                break;}
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
    public void shift(){
        lookAhead = lookAhead.next;
    }
}
