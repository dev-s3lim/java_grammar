package C05AnnonymousLambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/// arr[0] 기준으로 정렬 (O)
/// 세 가지 경우의 수 고려: 떨어져 있는 것, 겹치는 것(부분 또는 전체 포함), start ~ end 잘 관리

public class Baekjoon2170DrawingLines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 개수 입력

        int[][] arr = new int[n][2]; // 1. 정보를 저장할 2차원 배열 생성

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" "); // 2. 한 줄을 입력받아 공백 기준으로 분리
            arr[i][0] = Integer.parseInt(input[0]);    // 3. 시작점 저장
            arr[i][1] = Integer.parseInt(input[1]);    // 4. 끝점 저장
        }

        // 5. 배열을 시작점 기준으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]); // 시작점 오름차순
            }
        });

        int start = arr[0][0]; // 6. 첫 번째 시작점
        int end = arr[0][1];   // 7. 첫 번째 끝점
        int total = 0;         // 8. 총 길이 누적 변수

        // 9. 두 번째부터 순회하며 병합 또는 길이 누적 처리
        for (int i = 1; i < n; i++) {
            int currentS = arr[i][0]; // 현재 선의 시작점
            int currentE = arr[i][1]; // 현재 선의 끝점

            if (currentS <= end) {
                // 현재 선의 시작점이 이전 선의 끝점과 겹치거나 연결됨
                // → 끝점을 더 큰 값으로 확장
                end = Math.max(end, currentE);
            } else {
                // 겹치지 않으면 이전 선분 종료 → 길이 누적
                total += (end - start);
                // 새 선 시작
                start = currentS;
                end = currentE;
            }
        }

        // 10. 최종 길이 누적
        total += (end - start);

        System.out.println(total); // 11. 전체 선 길이 출력
    }
}
