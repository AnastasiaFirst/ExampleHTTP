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

import static java.net.http.HttpClient.newHttpClient;

public class Main {

    public static void main(String[] args) {

        try {
            HttpClient client = newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Ответ от сервера: " + response.body());

            if (response.statusCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                List<Post> posts = mapper.readValue(
                        response.body(), new TypeReference<List<Post>>() {
                        });

                for (Post post : posts) {
                    System.out.println("UserID: " + post.getUserId());
                    System.out.println("ID: " + post.getId());
                    System.out.println("Title: " + post.getTitle());
                    System.out.println("Body: " + post.getBody());
                    System.out.println("-----------------------------------");
                }
            } else {
                    System.out.println("Ошибка: " + response.statusCode());
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
