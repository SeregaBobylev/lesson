package calc;

import java.util.Stack;

public class Lexer {
    Token getNextToken;
    Token lookAhead;
    public Lexer(String expression) {
        String tempString = new String();
        while(!expression.isEmpty()){
            tempString += expression.charAt(0);
            System.out.println(expression);
            System.out.println();
            if(TokenType.getType(expression.charAt(0)).equals(TokenType.getType(expression.charAt(1)))){
                tempString+=expression.charAt(1);
                continue;
            }else{
                if(getNextToken!=null){
                    getNextToken.nextToken = getNextToken;
                    getNextToken.value=tempString;
                    getNextToken.type=TokenType.getType(expression.charAt(0));
                }else
                getNextToken = new Token(tempString,TokenType.getType(expression.charAt(0)),null);
                tempString="";
            }

            expression.substring(1);
        }
    }
    public Token getGetNextToken() {
        return getNextToken;
    }
}
