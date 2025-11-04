import threads.ClienteREST;

public class App {
    public static void main(String[] args) throws Exception {
        
        Thread t1 = new Thread(new ClienteREST("Thread_A", "https://g1.globo.com/"));
        Thread t2 = new Thread(new ClienteREST("Thread_B", "https://www.google.com/"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Threads finalizadas!");












        






        // Thread ta = new Thread(new ThreadTestes("ThreadA"));
        // Thread tb = new Thread(new ThreadTestes("ThreadB"));
        // ta.start();
        // tb.start();
        // ta.join();
        // tb.join();
        // System.out.println("Threads finalizadas!");
    }
}
