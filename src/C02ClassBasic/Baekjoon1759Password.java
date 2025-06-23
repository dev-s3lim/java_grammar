package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon1759Password {
    static List<String> pList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        pList.addAll(Arrays.asList(input2));

        int target = C;

        List<List<String>> password = new ArrayList<>();
        boolean[] visited = new boolean[pList.size()];
        permu(new ArrayList<>(), password, visited, target);

        StringBuilder sb = new StringBuilder();

        for (List<String> s : password){
            for (String a : s){
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void permu (List<String> tmp, List<List<String>> result, boolean[] visited, int target){
        if (tmp.size() == target){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < pList.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(pList.get(i));
                permu (tmp, result, visited, target);
                tmp.remove(tmp.size()-1);
                visited[i] = false;
            }
        }
    }
}
