package calc;

import java.util.Stack;

import static calc.Token.typeChar.*;

public class Calculator {
    private char[] current;
    private Stack<Character> convertStack;
    private Token head=null,tail=null;
    public Calculator(String current) {
        System.out.println(calculating(reversePolishNotation(current)));
    }
    private double calculating(Token notation){
        Stack<Token> tempStack=new Stack<>();
        while (notation!=null){
            switch (notation.type){
                case NUMBER:
                    tempStack.push(new Token(notation.value,NUMBER,null));
                    notation=notation.next;
                    break;
                case PLUS:break;
                case MINUS:break;
                case DEGREE:break;
                case DIVISION: break;
                case MULTIPLIED: break;
            }
//            notation.ty
        }
    }
    private Token reversePolishNotation(String current){
        Stack<Token.typeChar> symbol = new Stack<>();
        Lexer temp = new Lexer(current);
        while (temp.getLookAhead() != null) {
            switch (temp.getLookAhead().type) {
                case NUMBER:
                    setElement(new Token(temp.getLookAhead().value, temp.getLookAhead().type, null));
                    break;
                case PLUS, MINUS, OPEN:
                    while(!symbol.empty()){
                        if(symbol.peek()==DIVISION || symbol.peek()==MULTIPLIED )  {
                            setElement(new Token(null, symbol.pop(), null));
                        }
                        else
                            break;
                    }
//                    symbol.push(temp.getLookAhead().type);
                    symbol.push(temp.getLookAhead().type);
                    break;
                case DIVISION, MULTIPLIED:
                    while(!symbol.empty()){
                        if( symbol.peek()==temp.getLookAhead().type)  {
                            setElement(new Token(null, symbol.pop(), null));
                        }
                        else
                            break;
                    }
                    symbol.push(temp.getLookAhead().type);
                    break;
                case DEGREE:
                    break;
                case CLOSE:
                    while(symbol.peek()!= OPEN){
                        System.out.println(symbol.peek());
                        setElement(new Token(null, symbol.pop(), null));
                    }
                    symbol.pop();
                    break;

            }
            temp.shift();
        }
        while(!symbol.empty()){
            setElement(new Token(null,symbol.pop(),null));
        }
        while(head!=null){
            System.out.println(head.value+" "+head.type);
            head=head.next;
        }
        return head;
    }
    private void setElement(Token token){
        if(head==null)
            head = token;
        else
            tail.next=token;
        tail=token;

    }
}
