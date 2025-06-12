package C01Basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class C07Array {
    public static void main(String[] args) throws IOException {
        // 배열 표현식 #1 - 배열 선언 후 할당 방식
        // * 배열은 반드시 사전에 길이가 결정되어야 함
/*
        int[] arr1 = new int[5];
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        arr1[3] = 40;
        arr1[4] = 50;
        arr1[5] = 60; //배열의 길이는 동적으로 늘어날 수 없음

 */

        /*
        arr1[0] = 10;
        arr1[1] = 20;

        arr1[3] = 40;
        arr1[4] = 50;
        // int 배열인 경우 0으로 초기화 ; String 배열은 null
        System.out.println(arr1[2]);

        // 배열 표현식 #2 - 리터럴 방식
        int[] arr2 = {10, 20, 30, 40, 50, 60};

        // 배열 표현식 #3
        int[] arr3 = new int[]{10, 20, 30, 40, 50}; //선언함과 동시에 수를 정함

        // 배열 표현식3. 예시
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[5]);
        list.add(new int[]{1,3,5,7,9});

        System.out.println(list.get(1)[0]);
        System.out.println(list.get(1)[1]);
        System.out.println(list.get(1)[2]);

        // 배열 표현식4. 불가
        int[] arr4 = new int[?]; //배열의 길이를 반드시 확장시켜야함

         */
        //메서드 Arrays.fill - 배열의 모든 값을 변경
        /*
        String[] arr = new String[5];
        for (int i = 0; i < arr.length; i++){
            arr[i] = "";
        }
        Arrays.fill(arr, ""); //주요 기능은 Arrays class에 내장

         */
/*
        int[] arr = {85, 65, 90};
        int[] arr2 = {10, 20, 30, 12, 8, 7};
        // 최댓값; 최소값
        int max = MIN_VALUE; //또는 Integer.MIN_VALUE
        int min = MAX_VALUE; //또는 Integer.MAX_VALUE
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        int avg = sum / arr.length;

        for (int i = 0; i < arr2.length; i++){
            if (max < arr2[i]){
                max = arr2[i];
            }
            if (min > arr2[i]) { //else 아님
                min = arr2[i];
            }
        }
        System.out.println(sum);
        System.out.println((double)avg); //나누기 할때는 절사
        System.out.println(max);
        System.out.println(min);
        System.out.println(Arrays.stream(arr2).max());
        System.out.println(Arrays.stream(arr2).min());


 */

        // 배열의 자리 바꾸기
        /*
        int[] arr = {20, 10, 30};
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
        System.out.println(Arrays.toString(arr));

         */

        // 배열 뒤집기
        /*
        int[] arr = {10, 20, 30, 40, 50};
        int[] newArr = new int[arr.length];
        int index = 0;
        for (int i = arr.length - 1 ; i >= 0; i--){
            newArr[index] = arr[i];
            index++;
        }
        System.out.println(Arrays.toString(newArr))

         */

        // 배열의 정렬
        /*
        int[] arr = {17, 12, 20, 10, 15};
        Arrays.sort(arr); //오름차순
        System.out.println(Arrays.toString(arr));
        // Arrays.sort(arr, Comparator.reverseOrder()); 원시자료형은 Comparator 사용 불가능

        String[] s = {"abc", "aaa", "acb", "abb"};
        Arrays.sort(s, Comparator.reverseOrder());
        System.out.println(Arrays.toString(s));

         */

        // 선택정렬 알고리즘 직접 구현 min, 자리 change, 이중 포문
        int[] arr = {17, 12, 20, 10, 15};
        int tmp = arr[0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[i]){ //arr[j] < arr[i]을 충족할 때마다...
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp; // ...swap 시켜라.
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

/*
i = 0;
17 -> 12 -> 10
17,12,20,10,15 -> 12,17,20,10,15 -> 10,17,20,12,15

i = 1;
17 -> 10
10,17,20,12,15 -> 10,12,20,17,15

i = 2;
20 -> 17
10,12,20,17,15 -> 10,12,17,20,15 -> 10,12,15,20,17

i = 3;
20
10,12,15,20,17 -> 10,12,15,17,20

 */