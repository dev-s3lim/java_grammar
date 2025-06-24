package C02ClassBasic;

import java.io.*;
import java.util.*;

public class Baekjoon5568Cards {
    static List<String> myList = new ArrayList<>();
    static Set<String> numSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String num = br.readLine();
            myList.add(num);
        }

        int target = k;

        Set<String> myAnswer = new HashSet<>();
        boolean[] isVisited = new boolean[myList.size()];
        permu (new ArrayList<>(), myAnswer, isVisited, target);

        System.out.println(myAnswer.size());
    }

    public static void permu (List<String> tmp, Set<String> result, boolean[] isVisited, int target){
        if (tmp.size() == target){
            StringBuilder sb = new StringBuilder();
            for (String s : tmp){
                sb.append(s);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < myList.size(); i++){
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
