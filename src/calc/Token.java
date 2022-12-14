package calc;

import java.util.HashMap;
import java.util.Map;

public class Token {
    enum typeChar {PLUS,MINUS,NUMBER,DIVISION,MULTIPLIED,DEGREE,OPENBRACKET,CLOSEBRACKET};
    public String value;
    public typeChar type;
    public Token nextToken;

    public Token(String value, typeChar type, Token nextToken) {
        this.value = value;
        this.type = type;
        this.nextToken = nextToken;
    }
}
