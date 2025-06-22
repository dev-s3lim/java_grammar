package C02ClassBasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationPractice {
    static List<Integer> myList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        List<List<Integer>> finalCombi = new ArrayList<>();
        combi(0, new ArrayList<>(), finalCombi, 2);

        System.out.println(finalCombi);
    }

    public static void combi (int start, List<Integer> tmp, List<List<Integer>> result, int target){
        if(tmp.size() == target){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start; i < myList.size(); i++){
            tmp.add(myList.get(i));
            combi (start + 1, tmp, result, target);
            tmp.remove(tmp.size()-1);
        }
    }
}
