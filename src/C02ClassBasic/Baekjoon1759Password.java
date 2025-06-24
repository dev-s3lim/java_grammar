package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1759Password {
    static List<String> pList = new ArrayList<>();
    static Set<String> vowelsSet = new HashSet<>(); ///vowels를 받아놓을 전역 Set 준비

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        vowelsSet.add("a");
        vowelsSet.add("e");
        vowelsSet.add("i");
        vowelsSet.add("o");
        vowelsSet.add("u");

        String[] input = br.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < C; i++){
            pList.add(input2[i]);
        }

        Collections.sort(pList); /// 올림차 순 정렬

        int target = L;

        List<List<String>> password = new ArrayList<>();
        combi(0, new ArrayList<>(), password, target);

        StringBuilder sb = new StringBuilder();

        for (List<String> s : password){
            for (String a : s){
                sb.append(a);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static boolean isValid (List<String> list){
        int vow = 0;
        int cons = 0;

        for (String s : list){
            if (vowelsSet.contains(s)){
                vow++;
            }
            else{
                cons++;
            }
        }
        return vow >= 1 && cons >= 2; /// vowels가 1개 이상, consonant가 2개 이상이면 true를 return 하라.
    }

    public static void combi (int start, List<String> tmp, List<List<String>> result, int target) {
        if (tmp.size() == target) {
            if(isValid(tmp)){ /// isValid 메서드에 tmp를 대입했을 때 true (즉, vowels가 1개 이상, consonant가 2개 이상이면...)
                result.add(new ArrayList<>(tmp));
                return;
            }
        }

        for (int i = start; i < pList.size(); i++) {
            tmp.add(pList.get(i));
            combi(i + 1, tmp, result, target);
            tmp.remove(tmp.size() - 1);
        }
    }
}
