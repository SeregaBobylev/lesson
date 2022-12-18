package calc;

import java.util.HashMap;

public class Token{
    public char value;
    public Type type;
    private static HashMap<Character,Type> charType = new HashMap<>();
    static {
        charType.put('(',Type.OPEN);
        charType.put(')',Type.CLOSE);
        charType.put('-',Type.MINUS);
        charType.put('+',Type.PLUS);
        charType.put('*',Type.MULTIPLIED);
        charType.put('/',Type.DIVISION);
        charType.put('^',Type.DEGREE);
        for(char i = '0';i<='9';i++)
            charType.put(i,Type.NUMBER);
    }
    public Token(char value) {
        this.value = value;
        this.type = charType.get(value);
    }
}
