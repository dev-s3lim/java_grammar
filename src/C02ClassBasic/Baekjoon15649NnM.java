package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon15649NnM {
    static List<Integer> myList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 1; i <= n; i++){
            myList.add(i);
        }

        int target = m;

        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[myList.size()];
        permu(new ArrayList<>(), answer, visited, target);

        StringBuilder sb = new StringBuilder();

        for (List<Integer> a : answer){
            for (int num : a){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void permu (List<Integer> tmp, List<List<Integer>> result, boolean[] visited, int target){
        if(tmp.size() == target){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < myList.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(myList.get(i));
                permu(tmp, result, visited, target);
                tmp.remove(tmp.size()-1);
                visited[i] = false;
            }
        }
    }
}
