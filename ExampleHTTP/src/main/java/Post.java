import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    private final int userId;
    private int id;
    private String title;
    private String body;

    public Post(
            @JsonProperty("userId") int userId,
            @JsonProperty("id") int id,
            @JsonProperty("title") String title,
            @JsonProperty("body") String body
    ) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() { return userId; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post" +
                "\n userId=" + userId+
                "\n id=" + id +
                "\n title=" + title +
                "\n body=" + body;
    }
}
