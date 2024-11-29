import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Ответ от сервера: " + response.body());

            String jsonResponse = "{\"userId\":1,\"id\":1,\"title\":\"Test title\",\"body\":\"Test body\"}";

            ObjectMapper mapper = new ObjectMapper();
            Post post = mapper.readValue(jsonResponse, Post.class);


            System.out.println("ID: " + post.getId());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Body: " + post.getBody());
            //System.out.println("-----------------------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
