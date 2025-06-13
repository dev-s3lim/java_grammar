package C01Basic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C09Map {
    public static void main(String[] args) throws IOException {
        //map은 key와 value로 이뤄진 자료구조이다.
        //key값은 중복이 있으면 value를 덮어쓰기

        Map<String, Integer> myMap = new HashMap<>();
        sports.put("basketball", 2);
        sports.put("volleyball", 1);

        //map은 키를 통해 value를 get
        //map에서 키값을 통한 검색 복잡도는 O(1)

        System.out.println(sports.get("농구"));
    }
}
