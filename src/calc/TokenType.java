package calc;

import java.util.HashMap;
import java.util.Map;

public class TokenType {
    private static Map<Character,Token.typeChar> symbolMap = new HashMap<>();
    static {
        for(char i='0' ; i<='9'; i++)
            symbolMap.put(i, Token.typeChar.NUMBER);
        symbolMap.put('-', Token.typeChar.MINUS);
        symbolMap.put('+', Token.typeChar.PLUS);
        symbolMap.put('(', Token.typeChar.OPENBRACKET);
        symbolMap.put(')', Token.typeChar.CLOSEBRACKET);
        symbolMap.put('/', Token.typeChar.DIVISION);
        symbolMap.put('*', Token.typeChar.MULTIPLIED);
        symbolMap.put('^', Token.typeChar.DEGREE);
    }
    public static Token.typeChar getType(char symbol){
        return symbolMap.get(symbol);
    }
}