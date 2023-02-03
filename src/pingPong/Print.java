package pingPong;

public class Print {
    int i =0;
    public void PrintPing(){
        System.out.println("Ping");
    }
    public void PrintPong(){
        System.out.println("Pong");
    }
    public void PrintText(){
        synchronized (this){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int i =  this.i;
            if(i%2==1) PrintPing();
            else PrintPong();
            this.i = i+1;
        }

    }
}
