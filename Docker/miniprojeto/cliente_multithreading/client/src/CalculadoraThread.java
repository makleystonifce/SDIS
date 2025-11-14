import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CalculadoraThread implements Runnable{
    private String name;
    private String url;
    private double num1;
    private double num2;
    private String operacao;

    public CalculadoraThread(String name, String url, String operacao, double num1, double num2){
        this.name = name;
        this.operacao = operacao;
        this.num1 = num1;
        this.num2 = num2;
        this.url = url;
        this.url +=  "/"+operacao+"?num1="+this.num1+"&num2="+num2;
    }

    @Override
    public void run() {
        System.out.println(this.name+": inicializada!");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(this.name + ": "+response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    
}
