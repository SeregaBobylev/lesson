package email_validation;

import java.util.HashMap;
import java.util.Map;

public class State {
    private String id;
    private boolean isFinite;



    private Map<Character, State> transitions = new HashMap<>();
    public boolean isFinite() {
        return isFinite;
    }

    public State getTransition(char symbol) {
        return transitions.get(symbol);
    }

    public State(String id, boolean isFinite) {
        this.id = id;
        this.isFinite = isFinite;
    }

    public void addTransition(char symbol, State state) {
        transitions.put(symbol, state);
    }

    public void addTransitionByAllLetters(State state) {
        for (char c = 'a'; c <= 'z'; c++) addTransition(c, state);
    }

    public void addTransitionByAllDigits(State state) {

        for (char i = '0'; i <= '9'; i++) {
            addTransition(i, state);
//            System.out.println(i);
        }
    }
}
