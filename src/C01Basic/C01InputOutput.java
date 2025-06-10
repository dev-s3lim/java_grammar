package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C01InputOutput {
    public static void main(String[] args) throws IOException {
        // 출력 : system.out을 통해 콘솔 출력
        /*System.out.println("Hello World1"); //문자열 넣을 때는 쌍따옴표를 쓴다.
        // println 은 줄바꿈이다.
        System.out.println(20);
        // print는 줄을 바꾸지 않음
        System.out.print("Hello World2");
        System.out.print(" -> Hello World3");
        */
        // 입력 : Scanner 클래스 : 입력을 위한 클래스
        // System.in -> 키보드 입력
        /*Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();// 입력받은 데이터를 한줄로 읽어서, String으로 return
        System.out.println("입력사항 : " + input);
         */


        // 아래와 같은 입력값이 주어질때 처리 방법
        /*
            abc
            bcd
            2
         */

        /*Scanner myScanner2 = new Scanner(System.in);
        String input1 = myScanner2.nextLine();
        String input2 = myScanner2.nextLine();
        int input3 = myScanner2.nextInt();

        System.out.println("입력사항 1 : " + input1);
        System.out.println("입력사항 2 : " + input2);
        System.out.println("입력사항 3 : " + input3);
        */

        //입력 : BufferedReader + System.in
        /*BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br1.readLine(); //한줄씩 읽어서 문자열로 리턴
        System.out.println(input1);
         */

        //입력 : abc bcd fgh
        /*BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String input2 = br2.readLine();
        String [] arr = input2.split(" ");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
         */

        //입력 : abc bcd fgh
        /*BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String [] arr = br2.readLine().input2.split(" ");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
         */

        // BufferedReader + StringTokenizer
        BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
        String input3 = br3.readLine();
        StringTokenizer st = new StringTokenizer(input3);
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());

    }
}
