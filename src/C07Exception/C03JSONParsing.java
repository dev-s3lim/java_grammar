package C07Exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.readString;

public class C03JSONParsing {
    public static void main(String[] args) throws IOException {
        /// 사용법 1 (객체 생성 readValue)
        /// ObjectMapper : json 직렬화, 역직렬화를 위한 라이브러리
        ObjectMapper o1 = new ObjectMapper(); /// Jackson
        /// 사용법 2 : 클래스명 객체명 = o1.readValue(문자열, 클래스명);

        Path filePath = Paths.get("/Users/shlim/Desktop/16기/java_grammar/src/C07Exception/myjson1.json");
        String json1 = Files.readString(filePath);

        Map<String, String> myMap = o1.readValue(json1, Map.class);
        System.out.println(myMap.get("name"));
        System.out.println(myMap);

        Student s1 = o1.readValue(json1, Student.class);
        System.out.println(s1);

        /// 사용법 2 (Tree구조의 jsonNode로 변환)
        /// JsonNode 객체명 = o1.readTree (문자열);
        /// 복잡한 json 자료구조일 경우에, Tree구조의 JsonNode 사용
        Map<String, String> myMap2 = new HashMap<>();
        JsonNode jsonNodes = o1.readTree(json1);

        myMap2.put("id", jsonNodes.get("id").asText());
        myMap2.put("name", jsonNodes.get("name").asText());
        myMap2.put("classNumber", jsonNodes.get("classNumber").asText());
        myMap2.put("city", jsonNodes.get("city").asText());

       /// myjson2를 가지고, List<Student> 객체 형식으로 변환
        Path filePath2 = Paths.get("/Users/shlim/Desktop/16기/java_grammar/src/C07Exception/myjson2.json");
        String json2 = Files.readString(filePath2);

        Map<String, String> myMap3 = new HashMap<>();
        JsonNode jsonNode2 = o1.readTree(json2);
        List<Student> myList2 = new ArrayList<>();

        for(JsonNode j : jsonNode2){
            Student s2 = o1.readValue(j.toString(), Student.class);
            myList2.add(s2);
        }

        /// Json 직렬화 : 객체 -> json 변환. writeValueAsString (객체)
        String returnSt = o1.writeValueAsString(myList2);
        System.out.println(returnSt);
    }
}

class Student{
    private int id;
    private String name;
    private String classNumber;
    private String city;

    /// Setter도 없고, 생성자도 없는데? 실제 값으 세팅은 private이라 할지라도 직접 접근하여 setting 하고 있다.
    /// reflection 기술을 활용하여 접근 가능 (실시간으로 클래스를 검색 및 접근할 수 있는 기능)
    /// ObjectMapper는 Getter의 메서드명을 통해 필드값을 유추하므로, 반드시 기본생성자 + Getter는 있어야 한다.
    public Student(){
    };

    public Student(String id, JsonNode name) {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

/// 나중에는 클래스를...
    /// 모든 변수 private
    /// getter 생성
    /// 생성자2개 생성(생성자 + 깡통)