package C02ClassBasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 조합과 순열 예제 통합
public class C13RecursiveCombiPermu {

    static List<Integer> myList = Arrays.asList(1, 2, 3, 4);

    public static void main(String[] args) throws IOException {
        // ---------------------------
        // 조합 - 방법 1: 2중 for문
        List<List<Integer>> hardCoded2 = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            for (int j = i + 1; j < myList.size(); j++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(myList.get(i));
                tmp.add(myList.get(j));
                hardCoded2.add(tmp);
            }
        }

        // ---------------------------
        // 조합 - 방법 2: 3중 for문
        List<List<Integer>> hardCoded3 = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            tmp.add(myList.get(i));
            for (int j = i + 1; j < myList.size(); j++) {
                for (int k = j + 1; k < myList.size(); k++) {
                    tmp.add(myList.get(j));
                    tmp.add(myList.get(k));
                    hardCoded3.add(new ArrayList<>(tmp));
                    tmp.remove(tmp.size() - 1); // remove k
                    tmp.remove(tmp.size() - 1); // remove j
                }
            }
            tmp.remove(tmp.size() - 1); // remove i
        }

        // ---------------------------
        // 조합 - 방법 3: 재귀
        List<List<Integer>> combiResult = new ArrayList<>();
        combi(0, new ArrayList<>(), combiResult, 2);

        // ---------------------------
        // 순열 - 재귀 방식
        List<List<Integer>> permuResult = new ArrayList<>();
        boolean[] visited = new boolean[myList.size()];
        permu(new ArrayList<>(), permuResult, visited, 2);

        // ---------------------------
        // 출력
        System.out.println("✅ 2중 for문 조합:");
        System.out.println(hardCoded2);
        System.out.println();

        System.out.println("✅ 3중 for문 조합:");
        System.out.println(hardCoded3);
        System.out.println();

        System.out.println("✅ 재귀 조합 결과:");
        System.out.println(combiResult);
        System.out.println();

        System.out.println("✅ 재귀 순열 결과:");
        System.out.println(permuResult);
    }

    // ---------------------------
    // 재귀 기반 조합 함수 (순서 X)
    static void combi(int start, List<Integer> tmp, List<List<Integer>> result, int target) {
        if (tmp.size() == target) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < myList.size(); i++) {
            tmp.add(myList.get(i));
            combi(i + 1, tmp, result, target);
            tmp.remove(tmp.size() - 1);
        }
    }

    // ---------------------------
    // 재귀 기반 순열 함수 (순서 O)
    static void permu(List<Integer> tmp, List<List<Integer>> result, boolean[] visited, int target) {
        if (tmp.size() == target) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(myList.get(i));
                permu(tmp, result, visited, target);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
