package C07Exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class C04HttpJsonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
        /// 외부 데이터 (api) 요청해서 json 받아오기 -> 서버간의 통신
        /// RestTemplate, RestClient -> Spring에서 많이 쓰이나, 지금은 java에 걍 내장된거 쓸 예정

        /// java의 내장 클래스로서 뱔도의 직렬화, 역직렬화 작업이 필요하다.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET() /// 일반 get 요청
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String postString = response.body();

        ObjectMapper objM = new ObjectMapper();

        JsonNode jsonNode0627 = objM.readTree(postString);
        List<Post> myList0627 = new ArrayList<>();

        for(JsonNode j : jsonNode0627){
            Post p0627 = objM.readValue(j.toString(), Post.class);
            myList0627.add(p0627);
        }

        for (Post a : myList0627){
            System.out.println(a);
            System.out.println();
        }
    }
}

class Post{
    /// reflection 기술 사용
    private long userId;
    private long id; /// 근데 이게 만약에 원본이 "1" 이런식이였다면?
    private String title;
    private String body;

    /// 기본 생성자 (필수)
    public Post(){
    };

    public Post(long userId, long id, JsonNode title, JsonNode body) {
    }

    /// Getter (필수)
    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}