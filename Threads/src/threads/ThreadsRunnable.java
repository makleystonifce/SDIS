package threads;

public class ThreadsRunnable implements Runnable {

    private String name;
    static int contator = 0;

    public ThreadsRunnable(String name){
        this.name = name;
    }

    public static synchronized void incrementar(){
        contator++;
    }

    @Override
    public void run() {
        System.out.println(this.name+": inicializada!");
        for (int i = 0; i < 10; i++) {
            incrementar();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name+": finalizada!");
        System.out.println(this.name+": O valor Global é "+contator);
    }
    
}
