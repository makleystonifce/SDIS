package threads;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteREST implements Runnable{
    
    private String name;
    private String url;

    public ClienteREST(String name, String url){
        this.name = name;
        this.url = url;
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
