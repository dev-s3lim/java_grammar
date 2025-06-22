package C02ClassBasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PermutaitonPractice {
    static List<Integer> myList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        int target = 2;

        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[myList.size()];
        permu(new ArrayList<>(), answer, visited, target);

        System.out.println(answer);
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
