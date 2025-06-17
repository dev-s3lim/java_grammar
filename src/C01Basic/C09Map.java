package C01Basic;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C09Map {
    public static void main(String[] args) throws IOException {
        //map은 key와 value로 이뤄진 자료구조이다.
        //key값은 중복이 있으면 value를 덮어쓰기
/*
        Map<String, Integer> sports = new HashMap<>();
        sports.put("basketball", 2);
        sports.put("volleyball", 1);

 */
/*
        //map은 키를 통해 value를 get
        //map에서 키값을 통한 검색 복잡도는 O(1)

        System.out.println(sports.get("basketball")); //o1 복잡도

        //map의 전체 데이터 출력
        System.out.println(sports);

        //map의 key값 접근시에 index사용 불가능 (순서가 없으므로...)
        //keySet() : 맵의 전체 key 목록 리턴
        //values() : 맵의 전체 value 목록 리턴

        int total = 0;
        for (int v : sports.values()){
            total += v;
        }
        System.out.println(total);

        int total2 = 0;
        for (String key : sports.keySet()){
            total2 += sports.get(key);
        }
        System.out.println(total2);

        // 특정 키 밸류 삭제 = remove - 키를 통해 map의 요소 삭제
        sports.remove("basketball");
        System.out.println(sports);

 */
        /*

        // 기존의 키값에 put할 경우 덮어쓰기됨
        sports.put("volleyball", 10);
        System.out.println(sports);

         */
/*
        Map<String, String> sports = new HashMap<>();
        sports.put("soccer", "축구");
        sports.put("baseball", "야구");
        sports.put("basketball", "농구");
        //키값이 없는 경우에만...
        sports.putIfAbsent("soccer", "운동");
        sports.putIfAbsent("tennis", "테니스");

 */
/*
        System.out.println(sports);

        //containsKey() - 있으면 true, 없으면 false
        System.out.println(sports.containsKey("tennis"));
        System.out.println(sports.containsKey("pingpong"));

        //map 출력 방법 2가지
        // 1. 강화된 for문 (for each)
        for (String a : sports.keySet()){
            System.out.println(a);
            System.out.println(sports.get(a));
        }

        // 또는

        Set<String> mySet = sports.keySet();
        for (String a : sports.keySet()){
            System.out.println(a);
        }
 */

        // 2. iterator를 활용
        /*
        Map<String, String> sports = new HashMap<>();
        sports.put("soccer", "축구");
        sports.put("baseball", "야구");
        sports.put("basketball", "농구");
        Iterator<String> iterator = sports.keySet().iterator();
        // next() 메서드는 데이터를 하나씩 소모시키면서 값을 반환한다.
        /*
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        // 다 소모되어 에러 System.out.println(iterator.next());
        //hasNext - iterator안에 그값이 있는지 없는지 boolean으로 return
        System.out.println(iterator.hasNext());
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

         */

        //map은 key의 values를 카운트하는데 활용된다.
        /*
        Map<String, Integer> sports = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            String[] input = br.readLine().split(" ");
            String sportName = input[0];
            int students = Integer.parseInt(input[1]);
            sports.put(sportName, students);
        }

        System.out.println(sports);


        */
/*
        Map<String, Integer> myMap = new HashMap<>();
        String[] arr = {"soccer", "basketball", "baseball", "soccer", "basketball"};

        for (int i = 0; i < arr.length; i++) {
            if (myMap.containsKey(arr[i])) {
                myMap.put(arr[i], myMap.get(arr[i]) + 1);
            } else {
                myMap.put(arr[i], 1);
            }
        }
        // 이 코드는 반복문 외부에 있고 i를 참조하므로 제거하거나 수정 필요
        // 아래는 문법상 맞는 코드지만, 의미 없는 중복이라 주석 처리
        // myMap.put(arr[i], myMap.getOrDefault(arr[i], 0) + 1);



        System.out.println(myMap);

 */
/*
        //감소 로직

        Map<String, Integer> myMap = new HashMap<>();

        String[] removeArr = {"basketball", "basketball", "basketball", "baseball", "soccer", "soccer"};

        for (String r : removeArr) {
            if (myMap.containsKey(r)) {
                if (myMap.get(r) == 1){
                    myMap.remove(r);
                }
            } else {
                myMap.put(r, myMap.get(r) - 1);
            }
        }
        System.out.println(myMap);

 */
/*
        Map<String, Integer> myMap = new HashMap<>();

        //가장 value가 큰 key값 찾기
        int max = Integer.MIN_VALUE;
        String maxKey = "";

        myMap.put("축구", 3);
        myMap.put("테니스", 3);
        myMap.put("농구", 2);
        myMap.put("야구", 1);

        for (String k : myMap.keySet()){
            if (myMap.get(k) > max){
                max = myMap.get(k);
                maxKey = k;
            }
        }
        System.out.println(maxKey + " " + max);

 */
        //데이터의 삽입 순서 보장 (LinkedHashMap)
        /*
        Map<String, Integer> linked = new LinkedHashMap<>();
        linked.put("hello1", 1);
        linked.put("hello2", 2);
        linked.put("hello3", 3);
        linked.put("hello4", 4);
        linked.put("hello5", 5);

        for(String l : linked.keySet()){
            System.out.println(l);
        }

        // TreeMap - key를 기본적으로 오름차 순으로 정렬
        Map<String, Integer> tree = new TreeMap<>();
        tree.put("hello5", 5);
        tree.put("hello4", 4);
        tree.put("hello3", 3);
        tree.put("hello2", 2);
        tree.put("hello1", 1);

        for(String t : tree.keySet()){
            System.out.println(t);
        }

         */
/*
        // LinkedHashSet : 입력 순서 보장
        Set<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(1);
        linkedSet.add(1);
        linkedSet.add(0);
        linkedSet.add(3);
        linkedSet.add(1);
        System.out.println(linkedSet); // 1, 0, 3

        // TreeSet : 데이터를 오름차순 정렬
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(0);
        treeSet.add(3);
        treeSet.add(1);
        System.out.println(treeSet); // 0, 1, 3

 */

        // 집합 관련 함수 : 교집합(retainAll), 합집합(addAll), 차집합(removeAll)
        Set<String> set1 = new HashSet<>();
        set1.add("java");
        set1.add("python");
        set1.add("C++");

        Set<String> set2 = new HashSet<>();
        set2.add("java");
        set2.add("html");
        set2.add("css");

        //set1.retainAll(set2); //set1에는 java만 남음
        //set1.addAll(set2); //set1에는 java, python, C++, java, html, css
        set1.removeAll(set2); //set1에는 python, c++
        System.out.println(set1);
    }
}
