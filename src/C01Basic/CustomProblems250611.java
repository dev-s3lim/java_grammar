package C01Basic;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomProblems250611 {
    public static void main(String[] args) throws IOException {
        /*
        문자열이 주어진다.
        이 문자열에서 짝수 인덱스(0, 2, 4...)에 위치한 문자들만 골라서
        새로운 문자열로 만들어 출력하라.
         */

        /*
        String newString = "";
        char c = ' ';
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++){
            if (i % 2 == 0) {
                c = s.charAt(i);
                newString += c;
            }
        }
        System.out.println(newString);

         */

        /*
        문자열이 주어진다.
        이 문자열을 앞에서부터 2글자씩 잘라서,
        그중 짝수 번째 조각만 이어붙여 출력하라.
        (첫 조각은 0번째로 간주)

        입력: "abcdefgh"
        2글자씩 자르면 → "ab", "cd", "ef", "gh"
        짝수 인덱스 조각만 선택 → "ab"(0), "ef"(2)
        최종 출력 → "abef"
         */
/*
        String s = br.readLine();
        String addString = "";
        String newString = "";

        for (int i = 0; i < s.length() - 2; i++){
            if(i % 2 == 0){
                addString = s.substring(i, i+2);
                newString += addString;
            }
        }
        System.out.println(newString);

 */
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> myMap = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int cnt = 1;

        for (int i = 0; i < n; i++){
            String title = br.readLine();
            myMap.put(title, cnt);

            if (myMap.containsKey(title)) {
                myMap.put(title, myMap.get(title) + 1);
            }
            else if (myMap.get(k) == max){
                if(maxKey.compareTo(k) > 0){

                }
            }
        }
        System.out.println(myMap);

 */
        /*
        Map<String, Integer> myMap = new HashMap<>();

        String[] participant = {"Kim", "Lee", "Lim"};
        String[] completion = {"Lee", "Lim"};

        for (String name : participant) {
            myMap.put(name, myMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion){
            myMap.put(name, myMap.get(name) - 1);
        }

        String answer = "";

        for (String name : myMap.keySet()){
            if (myMap.get(name) > 0){
                answer = name;
            }
        }
        System.out.println(answer);

         */

    }
}

// 11004 (배열 및 정렬)
// 10867 (트리셋 .toString().strip()
// 11728 (배열 합치기)
// 11931 (정수 배열 내림차순)
// 1302 (TreeMap)
// 17219 (TreeMap과 for문)
// 프로그래머스 (완주하지 못한 선수)
// 프로그래머스 (의상)
// 프로그래머스 (폰켓몬)