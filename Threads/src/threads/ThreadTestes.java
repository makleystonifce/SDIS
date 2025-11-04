package threads;

public class ThreadTestes implements Runnable{

    private String name;
    static int contator = 0;
    public ThreadTestes(String name){
        this.name =name;
    }

    public static synchronized void incrementar(){
        contator++;
    }

    @Override
    public void run() {
        System.out.println(this.name+": Inicializada!");
        for (int i = 0; i < 5; i++) {
            incrementar();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name+": número = "+contator);
        System.out.println(this.name+": Finalizada!");
    }
}
