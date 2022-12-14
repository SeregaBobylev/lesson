package calc;

public class Token {
    enum typeChar {PLUS,MINUS,NUMBER,DIVISION,MULTIPLIED,DEGREE,OPENBRACKET,CLOSEBRACKET};
    public String value;
    public typeChar type;
    public Token next;

    public Token(String value, typeChar type, Token nextToken) {
        this.value = value;
        this.type = type;
        this.next = nextToken;
    }
}
