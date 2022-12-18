package calc;

public class Lexer{
    private int pos = 0;
    private final String expression;

    public Lexer(String expression) {
        this.expression = expression;
    }
    public Token getLookAhead() {
        Token temp = new Token(expression.charAt(pos));
        if(expression.charAt(pos)==expression.length()){

        }
    }
    public void shift() {
        lookAhead = lookAhead.next;
    }
}
