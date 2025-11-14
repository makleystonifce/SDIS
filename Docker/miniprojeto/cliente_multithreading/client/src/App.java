import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        
        Random random = new Random();

        int n1, n2;
        n1 = random.nextInt(10);
        n2 = random.nextInt(10);

        Thread calc = new Thread(new CalculadoraThread("soma", "http://calcpy:5000", "soma", n1, n2));
        
        calc.start();

        calc.join();

        System.out.println("Threads finalizadas!");
        

    }
}
