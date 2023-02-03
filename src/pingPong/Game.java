package pingPong;

public class Game extends Thread {
    Print print;

    Game(Print print){
        this.print=print;
    }
    public void run(){
        for (int i = 0; i <10000 ; i++) {

            print.PrintText();

        }
    }

}
