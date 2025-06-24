package C05AnnonymousLambda;

import java.io.*;
import java.util.*;

public class Baekjoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> tree = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() - o2.length() == 0) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0; i < n; i++){
            String v = br.readLine();
            tree.add(v);
        }

        StringBuilder sb = new StringBuilder();

        for (String c : tree){
            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }
}
