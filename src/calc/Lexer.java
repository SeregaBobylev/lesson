package calc;

import static calc.Type.*;
//import static calc.Type.NUMBER;

public class Lexer {
    private int pos;
    private int shiftLast = 0;
    private final String expression;
    private final int length;

    public Lexer(String expression) {
        this.expression = expression;
        this.length = expression.length();
    }

    public Token getLookAhead() {
        pos = shiftLast;
        if (length <= pos) return new Token("end", END);
        String tempString = "";
        Token token = new Token(expression.charAt(pos) + "");
        if (token.type == NUMBER) {
            Token temp = token;
            while (temp.type == NUMBER) {
                tempString += temp.value;
                pos++;
                if (pos == length) break;
                temp = new Token(expression.charAt(pos) + "");
            }
            if (!tempString.contains("."))
                tempString = Double.toString(Double.parseDouble(tempString));
            token = new Token(tempString, NUMBER);
        } else
            pos++;
        return token;
    }

    public void shift() {
        shiftLast = pos;
    }
}
