package C01Basic;

import java.io.*;
import java.util.Arrays;

public class CustomProblems250611 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
    }
}
