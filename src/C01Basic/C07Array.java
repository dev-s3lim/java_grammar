package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;

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
        /*
        int[] arr = {17, 12, 20, 10, 15};

        for (int i = 0; i < arr.length-1; i++) { // 어차피 마지막에는 큰값 들어가있을 예정 (정석)
            int min = arr[i]; // 배열 가장 처음의 숫자로 초기화 하고...
            int minIndex = i; // 현재 구간에서 가장 작은 값이 어디 있는지를 기억해두기 위해

            for (int j = i+1 ; j < arr.length; j++) { // 순열: 0  조합: (i+1)
                if(arr[j] < min){ // min은 arr[i]인데, 이거보다 arr[j]가 작으면...
                    min = arr[j]; // min은 arr[j]이고
                    minIndex = j; // 현재구간은 j이다.
                }
            }
            //자리 체인지 로직
            int tmp = arr[i]; // arr[i]를 arr[j]로 스위치 할건데, arr[i] = arr[j] 하면 값이 날라가버리니...
            arr[i] = arr[minIndex]; // arr[i] = arr[j현재구간]
            arr[minIndex] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
} // n 제곱으로 계산 중 -> Arrays.sort를 쓰면 log를 쓰는 것임 (성능 차이)


         */
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

// log n -> 2의 제곱 승수 (복잡도)

//조합문제 : 모두 각기 다른 숫자의 배열이 있을 때, 만들어질 수 있는 두 숫자의 조합을 문자열 형태로 출력
/*
ex:     (10,20) (10,30) (10,40) (10,50)
        (20,30) (20,40) (20,50)
        (30,40) (30,50)
        (40,50)
 */
        /*
        int[] arr = {10, 20, 30, 40, 50};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("("+arr[i]+","+arr[j]+")");
            }
        }

         */
/*
        //배열의 중복제거 (set 자료구조 활용하여 중복 제거) - 중복과 순서가 없는 것이 특징
        int[] arr = {10,10,20,30,30,40};
        Set<Integer> mySet = new HashSet<>(); //Set은 큰 종류일뿐
        for(int a : arr){
            mySet.add(a);
        }
        System.out.println(mySet);
        int[] answer = new int[mySet.size()];
        int index = 0;

        for (int a : mySet){ //Set 에는 index가 없어서 for each를 필수적으로 써야함
            answer [index] = a;
            index++;
        }

        Arrays.sort(answer);

 */
        /*
        int[]numbers = {2,1,3,4,1};
        Set<Integer> answer = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                answer.add(arr[i]+arr[j]);
            }
        }

         */

        /*
        // 배열의 검색 (복잡도 n)
        int[] arr = {5,3,1,8,7};
        int target = 8;
        // 8이 몇번째에 있는지 출력
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == 8){
                System.out.println(i);
            }
        }

         */

        // 이진검색, 이분탐색, binary search
        // 사전에 데이터가 오름차순 정렬되어 있을 경우, 이분 탐색 가능
        /*
        int[] arr = {1,3,6,8,9,11,15};
        System.out.println(Arrays.binarySearch(arr, 15));

        //값이 있으면 index 리턴, 없으면 마이너스값 리턴

         */

        // 배열값 비교
        /*
        int[] arr1 = {10,20,30};
        int[] arr2 = {10,20,30};

        System.out.println(arr1 == arr2); //false
        System.out.println(Arrays.equals(arr1, arr2)); //true

         */

        // 2차원 배열의 선언과 값 할당
        /*
        int[][] arr = new int [3][2]; //가변 배열
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 3;
        arr[1][1] = 4;
        arr[2][0] = 5;
        arr[2][1] = 6;

        // 리터럴 방식도 가능
        int[][] arr2 = {{1,2},{3,4},{5,6}};

        // 가변 배열 : 배열의 전체 길이는 반드시 할당
        int[][] arr3 = {{1,2},{1,3,4},{5,6,8,9}};


         */
        // 2차원 배열의 출력
        /*
        System.out.println(arr3); // 2차원 배열의 주소값
        System.out.println(Arrays.toString(arr3)); // 각 1차원 배열의 주소값 모음
        System.out.println(Arrays.deepToString(arr3)); // 각 1차원 배열의 값을 출력

        int[][] arr4 = new int [3][];
        arr4[0] = new int[2];
        arr4[1] = new int[3];
        arr4[2] = new int[4];


         */
        // [3][4] 사이즈 선언하고, 1~12까지 숫자값을 각 배열에 순차적 할당
        // {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
/*
        int[][] arr5 = new int [3][4];
        int num = 1;
        for (int i = 0; i < arr5.length; i++){
            for (int j = 0; j < arr5[i].length; j++){
                arr5[i][j] = num;
                num++;
            }
        }
        System.out.println(Arrays.deepToString(arr5));

 */

        //가변배열 값 채우기
/*
        int[][] arr5 = new int [3][];
        int num = 1;
        for (int i = 0; i < arr5.length; i++){
            arr5 [i] = new int[4];
            for (int j = 0; j < arr5[i].length; j++){
                arr5[i][j] = num;
                num++;
            }
        }
        System.out.println(Arrays.deepToString(arr5));

 */
        //행렬의 덧셈
        /*
        int [][] arr1 = {{1,2},{2,3}};
        int [][] arr2 = {{3,4},{5,6}};
        int [][] answer = new int [arr1.length][arr1[0].length]; //동적으로 설정

        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println(Arrays.deepToString(answer));

         */

        // 배열 복사
        // Arrays.copyOf(배열명, length), Arrays.copyOfRange(배열명, start, end)
        int[] arr = {1,2,3,4,5,6,7,8};
        int[] arr1 = Arrays.copyOf(arr, 4);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = Arrays.copyOfRange(arr,3,6);
        System.out.println(Arrays.toString(arr2));
    }
}
