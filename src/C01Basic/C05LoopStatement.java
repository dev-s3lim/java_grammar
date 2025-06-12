package C01Basic;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class C05LoopStatement {
    public static void main(String[] args) throws IOException {
        //while문
        /*
        int a = 2;
        while (a < 11) { //보통은 횟수 셀때 미만을 많이 사용, = 넣으면 헤깔릴수도
            System.out.println(a);
            a += 1;
        }

         */

        // 무한반복 + 맞추면 종료되는 도어락 및 5회입력 횟수 제한 키 예제
        /*String answer = "1234";
        Scanner sc = new Scanner(System.in);
        int inputLimit = 0;

        while (true){
            String input = sc.nextLine();
            if (input.length() != 4) {
                System.out.println("비밀번호가 틀렸습니다.");
            }
            else if (input.equals(answer)) {
                System.out.println("문이 열렸습니다.");
                break;
            }
            else {
                System.out.println("비밀번호가 틀렸습니다.");
            }

            inputLimit++;

            if (inputLimit == 5){
                System.out.println("비밀번호" + inputLimit + " 초과");
                break;
            }
        }

         */

        // 입력한 숫자의 구구단 단수 출력 ex) 2 -> 2x1=2 2x2=4 ...
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 1;

        while (m < 10){
            System.out.println(n + "x" + m + "=" + (n*m));
            m++;
        }

         */

        //do while 문 -> 무조건 한번은 실행되는 while문
        /*int a = 100;
        do{
            System.out.println(a);
        }
        while (a < 10);

         */

        // for문 -> 초기식, 조건식, 증감식이 모두 포함된 반복문
        // for문은 사용 했던 변수명을 for문이 끝난 이후에 재선언 가능
        /*
        for (int a = 1; a < 11; a++) {
            if (a % 2 != 0) {
                System.out.println(a);
            }
        }

         */

        // 1~20까지 짝수의 총합 출력
        /*
        int sum = 0; //for문 안에 넣으며 0으로 계속 리셋되므로 밖으로 뻄

        for (int a = 1; a < 21; a++) {
            if (a % 2 == 0) {
                sum = sum + a;
            }
        }
        System.out.println(sum);

         */

        // 두수의 최대공약수
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min = a > b ? b : a;
        int answer = 0;

        for (int i = 1; i <= min; i++){
            if (a%i == 0 && b%i == 0){
                answer = i;
            }
        }
        System.out.println(answer);

         */

        // --

        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min = a > b ? b : a;
        int answer = 0;

        for (int i = min; i > 0; i--){
            if (a%i == 0 && b%i == 0){
                answer = i;
                break;
            }
        }
        System.out.println(answer);

         */

        // 소수 구하기 1과 자신을 제외한 숫자로 나누어지지 않는 수
        // 사용자가 입력한 값이 소수인지 아닌지 판별하는 프로그램

        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isNotPrime = false;

        for (int i = 2 ; i < n; i++){
            if (n % i == 0){
                isNotPrime = true;
                break;
            }
        }

        if (isNotPrime == false){ //또는 !isNotPrime
            System.out.println(n + " is a prime number!");
        }
        else{
            System.out.println(n + " is not a prime number!");
        }

         */

        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isNotPrime = false;

        for (int i = 2 ; i*i < n; i++){
            if (n % i == 0){
                isNotPrime = true;
                break;
            }
        }

        if (isNotPrime == false){ //또는 !isNotPrime
            System.out.println(n + " is a prime number!");
        }
        else{
            System.out.println(n + " is not a prime number!");
        }

         */

        //continue : 반복문의 조건식으로 이동하는 명령어
        /*for (int i = 1; i < 11; i++) {
            if (i % 2 == 0) {
                //continue는 코드의 직관성과 가독성을 위해 사용
                continue; //짝수면 다시 반복문으로 돌아간다. (예외적으로 다시 돌아간다.)
            }
            System.out.println(i);

        }

         */

        // enhanced for문 (향상된 for문), 또는 for each문
        //int[] array = {1,3,5,7};
        /*int[] array = new int [4];
            array[0] = 1;
            array[1] = 3;
            array[2] = 5;
            array[3] = 7;

         */

        // 일반 for문
        /*
        int[] array = {1,3,5,7};
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

         */

        //향상된 for문을 활용한 배열 접근방식
        int[] array = {1, 3, 5, 7};
        /*for(int n : array){
            System.out.println(n);
        }

         */

        //일반 for문을 통한 array의 저장된 값 변경
        /*
        for (int i = 0; i < array.length; i++){
            array[i] += 10;
            System.out.println(array[i]);

        }
        // 참조형 변수(객체타입)는 기본적으로 변수를 통한 출력시에 메모리 값이 출력.
        System.out.println(Arrays.toString(array)); //클래스 메서드

         */
        //향상된 for문을 통한 array의 저장된 값 변경  ->  원본의 값 변경 불가능

        /*
        for (int a : array){
            a += 10;
        }
        // 참조형 변수(객체타입)는 기본적으로 변수를 통한 출력시에 메모리 값이 출력.
        System.out.println(Arrays.toString(array)); //클래스 메서드

         */

        // 자바 변수의 유효 범위 {}
        /*
        int num = 10;
        if (true){
            num = 20;
            int num2 = 20;
        }
        num2 = 30; //if문 중괄호 내에서 정의된 변수는 해당 중괄호 밖에서는 사용 불가능하다.

         */

        // 다중 반복문 (중첩 반복문)
        // 2~9단까지 한꺼번에 출력 + 각 단마다 몇단입니다. 출력

        /*
        for (int i = 2; i < 10; i++){
            System.out.println(i + " 단입니다.");
            for (int j = 1; j < 10; j++){
                System.out.println(i + " * " + j + " = " + (i*j));
            }
            System.out.println();
        }

         */

        // 라벨문 : 반복문에 이름을 붙이는 것
        /*
        loop1:
        for (int i = 0; i < 10; i++){
            loop2:
            for (int j = 0; j < 10; j++){
                if(true){
                    break loop1;
                }
            }
        }

         */

        // 2차원 배열
        /*
        int[][] arr = {{1,2,3},{100,200,11},{10,20,30},{55,11,35}}; //배열안에 배열이 들어가있는 구조
        loop1:
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == 11){
                    System.out.println("("+ i + " , " + j + ")");
                    break loop1;
                }
            }
        }

         */

        /*
        int[][] arr = {{1,2,3},{100,200,11},{10,20,30},{55,11,35}}; //배열안에 배열이 들어가있는 구조
        boolean check = false;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == 11){
                    check = true;
                    System.out.println("("+ i + " , " + j + ")");
                    break;
                }
            }
            if (check){
                break;
            }
        }

         */

        // 다중 반복문
        // 100 ~ 200까지 수 중에서 가장 작은 소수를 출력하라.
        /*
        int primeNumber = 0;

        for (int i = 100; i < 201; i++) {
            boolean isPrime = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumber = i;
                break;
            }
        }
        System.out.println(primeNumber);
    }
}

         */

        /*
        labelC:
        for (int i = 100; i <= 200; i++) {
            for (int j = 2; j < Math.sqrt(i)+1; j++) {
                if(i%j == 0) {
                    break;
                }
                if(j < Math.sqrt(i)) {
                    System.out.println("100~200 중 가장 작은 소수는 " + i + "입니다.");
                    break labelC;
                }
            }
        }

         */


//        100~200까지 수 중에서 가장 작은 소수를 출력하라

        loop1:
        for (int i = 100; i <= 200; i++) {
            loop2:
            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0){
                    continue loop1; // 소수가 아님. 다음 i로 넘어감.
                }
            }
            // 여기까지 왔다는 건 소수라는 뜻
            System.out.println(i);
            break; // 가장 처음 나온 소수니까 출력하고 종료
        }

    }
}