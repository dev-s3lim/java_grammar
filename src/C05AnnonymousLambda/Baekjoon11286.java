package C05AnnonymousLambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baekjoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)){
                    return o1.compareTo(o2);
                }
                else return Math.abs(o1) - Math.abs(o2);
            }
        });

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());

            if (m != 0){
                pq.add(m);
            }
            else if (pq.isEmpty()){
                sb.append(0).append("\n");
            }
            else if (m == 0){
                sb.append(pq.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
