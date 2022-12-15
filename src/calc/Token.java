package calc;

public class Token extends TokenType {
    public String value;
    public typeChar type;
    public Token next;
    public Token() {}
    public Token(String value, typeChar type, Token nextToken) {
        this.value = value;
        this.type = type;
        this.next = nextToken;
    }
}
