package C02ClassBasic;

import java.util.Arrays;

public class C12RecursivePractice {
    public static void main(String[] args) {
        // for문으로 1~10까지 누적합계
        /*
        int sum = 0;
        for (int i = 1; i < 11; i++){
            sum = sum + i;
        }

         */

        // 피보나치 수열 f(n-1) + f(n-2) = f(n)
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, ?
        int n1 = 1;
        int n2 = 1;
        int n3 = 0;

        //for문만을 활용한 풀이법 1
        for (int i = 2; i < 10; i++){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        System.out.println(n3);
        System.out.println(sumAcc(1, 10));
        System.out.println(factorial(5));

        //DP - Dynamic Programming 알고리즘(기억하기 - 메모이제이션) 활용한 풀이법
        int arr[] = new int [10];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 10; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(Arrays.toString(arr));

        //앞에까지 실행했던 연산을 기억해놓았다 나중에 참고

        sumAcc(1 , 10);
        factorial(5);
    }
    //재귀 함수로 하면?
    public static int sumAcc(int n, int target){
        if(n > target){
            return 0;
        }
        return n + sumAcc(n+1, target); /// n + (함수 function 호출) -> n + (n + 함수 function 호출)

    }

    // 재귀 함수로 factorial 값 구하기
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);

    }

    //재귀함수 피보나치
    public static int fibonacci(int n){
        if (n <= 2){
            return 1; //f(10)까지 갔다가 리턴해서 다시 올라옴
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }


}
