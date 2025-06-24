package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon15664NnM10 {
    static List<Integer> myList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            int digit = Integer.parseInt(input2[i]);
            myList.add(digit);
        }

        Collections.sort(myList);

        int target = m;

        Set<String> answer = new LinkedHashSet<>();
        combi(0, new ArrayList<>(), answer, target);

        StringBuilder sb = new StringBuilder();
        for (String a: answer){
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }

    public static void combi (int start, List<Integer> tmp, Set<String> result, int target){
        if(tmp.size() == target){
            StringBuilder sb = new StringBuilder();
            for (int a : tmp){
                sb.append(a).append(" ");
            }
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < myList.size(); i++){
            tmp.add(myList.get(i));
            combi(i+1, tmp, result, target);
            tmp.remove(tmp.size()-1);
        }
    }
}