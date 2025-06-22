package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon10974Permutation {
    static List<Integer> myList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++){
            myList.add(i);
        }

        Collections.sort(myList);

        int target = n;

        List<List<Integer>> answer = new ArrayList<>();
        boolean[] exists = new boolean[myList.size()];
        permu(new ArrayList<>(), answer, exists, target);

        StringBuilder sb = new StringBuilder();

        for (List<Integer> a : answer){
            for (int num : a){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void permu (List<Integer> tmp, List<List<Integer>> result, boolean[] exists, int target){
        if(tmp.size() == target){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < myList.size(); i++){
            if(!exists[i]){
                exists[i] = true;
                tmp.add(myList.get(i));
                permu(tmp, result, exists, target);
                tmp.remove(tmp.size()-1);
                exists[i] = false;
            }
        }
    }
}