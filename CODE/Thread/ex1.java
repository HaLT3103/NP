package Thread;

public class ex1 {
    public static void main(String[] args) {
        new PrintName("A").start();
        new PrintName("B");
        new Thread(new PrintName("C"));
        new Thread(new PrintName("D"));
    }
}

class PrintName() extends Thread {
    string name;
    public Printname(){
        this.name = name;
    }
    @Override
    public void run(){

    }
}