package C02ClassBasic;

import java.io.*;
import java.util.*;

public class Baekjoon15663NnM9 {
    static List <Integer> myList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(input2[i]);
            myList.add(num);
        }

        Collections.sort(myList);

        int target = m;

        Set<String> answer = new LinkedHashSet<>();
        boolean[] isVisited = new boolean[myList.size()];
        permu(new ArrayList<>(), answer, isVisited, target);

        StringBuilder sb = new StringBuilder();
        for (String s : answer){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    public static void permu (List<Integer> tmp, Set<String> result, boolean[] isVisited, int target){
        if (tmp.size() == target){
            StringBuilder sb = new StringBuilder();
            for (int a : tmp){
                sb.append(a).append(" ");
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0 ; i < myList.size(); i++){
            if (!isVisited[i]){
                isVisited[i] = true;
                tmp.add(myList.get(i));
                permu (tmp, result, isVisited, target);
                tmp.remove(tmp.size()-1);
                isVisited[i] = false;
            }
        }
    }
}
