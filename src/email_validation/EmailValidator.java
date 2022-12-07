package email_validation;

public class EmailValidator {
    private static final State startState ;
    static {
        State s0 = new State("s0", false);
        State s1 = new State("s1", false);
        State s2 = new State("s2", false);
        State s3 = new State("s3", false);
        State s4 = new State("s4", false);
        State s5 = new State("s5", false);
        State s6 = new State("s6", true);
        State s7 = new State("s7", true);
        State s8 = new State("s8", true);
        State s9 = new State("s9", true);

        s0.addTransitionByAllLetters(s1);

        s1.addTransitionByAllLetters(s1);
        s1.addTransitionByAllDigits(s1);
        s1.addTransition('.', s0);
        s1.addTransition('_', s0);
        s1.addTransition('@', s2);

        s2.addTransitionByAllLetters(s3);

        s3.addTransitionByAllLetters(s3);
        s3.addTransitionByAllDigits(s3);
        s3.addTransition('.', s4);

        s4.addTransitionByAllLetters(s5);

        s5.addTransitionByAllLetters(s6);

        s6.addTransitionByAllLetters(s7);

        s7.addTransitionByAllLetters(s8);

        s8.addTransitionByAllLetters(s9);

        startState = s0;
    }
    public static boolean validate(String email){
        State curState =startState;
        for (int i = 0; i < email.length(); i++) {
            curState = curState.getTransition(email.charAt(i));
            if (curState == null) return false;
        }
        return (curState!=null && curState.isFinite());
    }

}
