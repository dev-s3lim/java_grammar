package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon6603Lottery {

    static List<Integer> lotteryList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String line = br.readLine();

            if (line.equals("0")){
                break;
            }

            String[] input = line.split(" ");
            int k = Integer.parseInt(input[0]);
            lotteryList.clear(); //!!!리스트를 클리어해줘야 리셋되어 다음 리스트를 받을 수 있음!!!

            for(int i = 1; i <= k; i++){  //!!!k는 몇번 넣을지 정하는 숫자; 그 다음 숫자들이 s(조합 대상) 숫자들임!!!
                int s = Integer.parseInt(input[i]);
                lotteryList.add(s);
            }

            List<List<Integer>> answer = new ArrayList<>();
            int target = 6; // !!!조합의 갯수가 만약 변경될 수도 있는 경우에는 Main 내부 지역 변수에서 조정해줄 수 있음!!!
            combinations(0, new ArrayList<>(), answer, target);

            StringBuilder sb = new StringBuilder();

            for (List<Integer> a : answer){
                for (int n : a){
                    sb.append(n).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb); //!!!줄바꿈 주의!!!
        }
    }

    public static void combinations (int start, List<Integer> tmp, List<List<Integer>> result, int target){
        if (tmp.size() == target){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < lotteryList.size(); i++){
            tmp.add(lotteryList.get(i));
            combinations(i+1, tmp, result, target);
            tmp.remove(tmp.size()-1);
        }
    }
}

//#15649
