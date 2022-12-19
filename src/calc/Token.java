package calc;

import java.util.HashMap;

public class Token{
    public String value;
    public Type type;
    public Token next;
    private static HashMap<String,Type> charType = new HashMap<>();
    static {
        charType.put("(",Type.OPEN);
        charType.put(")",Type.CLOSE);
        charType.put("-",Type.MINUS);
        charType.put("+",Type.PLUS);
        charType.put("*",Type.MULTIPLIED);
        charType.put("/",Type.DIVISION);
        charType.put("^",Type.DEGREE);
        for(char i = '0';i<='9';i++)
            charType.put(i+"",Type.NUMBER);
        charType.put(".",Type.NUMBER);
    }
    public Token(String value) {
        this(value,charType.get(value));
    }

    public Token(String value, Type type) {
        this.value = value;
        this.type = type;
    }
}
