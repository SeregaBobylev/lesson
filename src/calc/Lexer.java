package calc;

import static calc.Type.*;
//import static calc.Type.NUMBER;

public class Lexer{
    private int pos;
    private int shiftLast=0;
    private final String expression;

    public Lexer(String expression) {
        this.expression = expression;
    }
    public Token getLookAhead() {
        pos = shiftLast;
        int length =expression.length();
        if(pos==24) System.out.println(pos);
        if(length<pos) return new Token(null,END);
        String tempString="";
        Token token = new Token(expression.charAt(pos)+"");
        if(token.type==NUMBER){
            while (length>pos){
                Token tempToken = new Token(expression.charAt(pos)+"");
                if(tempToken.type!=NUMBER) break;
                tempString+=tempToken.value;
                pos++;
            }
           token  = new Token(tempString,NUMBER);
        }else
        pos++;
        return token;
    }
    public void shift(){
        shiftLast=pos;
    }
}
