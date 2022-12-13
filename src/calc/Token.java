package calc;

import java.util.HashMap;
import java.util.Map;

public abstract class Token {
    private enum prioritySymbol {HIGHEST,HIGH,AVERAGE,LOW,NUMBER};
    public Object value;
    private static class TokenType{
        private static Map<Character,Enum> symbolMap = new HashMap<>();
        static {
            for(char i='0' ; i<='9'; i++)
                symbolMap.put(i, prioritySymbol.NUMBER);
            symbolMap.put('-', prioritySymbol.LOW);
            symbolMap.put('+', prioritySymbol.LOW);

            symbolMap.put('(', prioritySymbol.HIGHEST);
            symbolMap.put(')', prioritySymbol.HIGHEST);

            symbolMap.put('/', prioritySymbol.AVERAGE);
            symbolMap.put('*', prioritySymbol.AVERAGE);

            symbolMap.put('^', prioritySymbol.HIGH);
        }
        public Enum getType(char symbol){
            return symbolMap.get(symbol);
        }
    }
}
