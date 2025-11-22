import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        while (true) {
            int temp = random.nextInt(42);
            System.out.println("Umidade:"+temp);
            Thread.sleep(1000);
        }
    }
}
