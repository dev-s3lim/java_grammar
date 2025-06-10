package C01Basic;

import java.math.BigDecimal;
import java.util.ArrayList;

public class C02Variable {
    public static void main(String[] args) {
        /*
        //정수 : byte(1바이트), int (4바이트), long(8바이트)
        byte a = 127;
        byte b = -128;

        //오버플로우 : 자료형이 표현할 수 있는 범위를 넘어선 경우
        a++;

        //언더플로우 :
        b--;

        System.out.println(a);
        System.out.println(b);

        long i1 = 10;
        long i2 = 10;

        // 롱은 명시적으로 L을 붙여 long 타입임을 명시하기도 함

        // 실수 : float, double (환율이나 외화 자산 표시할 때, 소수점이 유의미 할때나 씀)
        // 실수 연산 자체가 오차를 발생시킴
        // double 이 default 값
        float f1 = 1.123f;
        double d1 = 1.123;
        */

        // 부동소수점 오차 테스트
        /*double d2 = 0.1;
        //System.out.println(d2);

        double total = 0;
        for (int i = 0; i < 1000; i++){
            total += d2*10;
        }
        System.out.println(total/10);
         */
        // Java에서는 Bigddecimal 사용 예정

        /*double d1 = 1.03;
        double d2 = 0.42;
        System.out.println(d1-d2);
        BigDecimal b1 = new BigDecimal("1.03");
        BigDecimal b2 = new BigDecimal("0.42"); //값을 입력 받을 때부터 소수점으로 입력받게 되면, 이미 오차가 발생하므로 문자로 입력.
        double d3 = b1.subtract(b2).doubleValue();
        System.out.println(d3);
         */

        // 문자형 char
       /*char c1 = '가'; // char 는 내부적으로 숫자값을 가지고 있다.
        String st1 = "가나";
        System.out.println(c1);
        System.out.println(st1);

        */

        // Boolean (참 또는 거짓)
        /*boolean b1 = false;
        if(b1){
            System.out.println("참입니다.");
        }
        else {
            System.out.println("거짓입니다.");
        }
         */

        //Null도 하나의 타입이다.
        /*참조형 자료에 값을 할당하지 않으면 Null이 할당된다.
         */

        /*String st1 = "";
        String st2 = null;

        System.out.println(st1);
        System.out.println(st2);
        String st3;
        System.out.println(st1.isEmpty());
        System.out.println(st2.isEmpty());
        System.out.println(st3.isEmpty()); //Null을 대상으로 String에 메서드 사용불가.
         */

        /*
        String [] arr = new String[5];
        arr [0] = "";
        arr [1] = "hello1";
        arr [2] = "hello2";
        arr [4] = "hello4";

        for (int i = 0; i < 5; i++){
            System.out.println(arr[i]);
        }

         */

        // 타입변환
        // 묵시적
        /*
        int a = 10;
        long l = a;
        System.out.println(l);
         */

        /*
        char c1 = 'a';
        int i = c1;
        System.out.println(i);
        */

        /*
        char c1 = 'a';
        int i = c1;
        System.out.println(i);
        // 문자 변환을 위한 묵시적 타입변환
        System.out.println('a' > 'b');
        // 명시적

         */

        //알파벳 소문자 제거
        /*String st = "01abcde123";
        String answer = "";
        for (int i = 0; i < st.length(); i++){
            char ch = st.charAt(i);
            if (ch <'a' || ch > 'z'){
                answer += ch;
            }
        }
        System.out.println(answer);
         */

        //int -> double
        /*int i = 10;
        double d = i;
        System.out.println(d);

         */

        //double -> int
        /*double d2 = 10.5;
        int i2 = (int) d2;
        System.out.println(d2);

         */

        // 정수 / 정수 = 소수점 절사문제
        // 두수가 모두 정수이면 결과값이 정수일 것이라고 자바가 판단
        /*int a = 1;
        int b = 4; // 여기서 이미 소수점 날려 버림

        double d1 = a / b;
        double d2 = (double)a/b;
        System.out.println(d2);
         */

        /*
        //변수와 상수
        int a1 = 10;

        //변수값 재할당은 가능
        a1 = 20;
        int a1 = 30; //재 선언은 불가능

        //상수는 초기값은 할당 이후에 재할당하는 것이 불가능
        final int PI = 20; // Pi 3.14 같은 수 설정할 때 사용
        PI = 30; // 불가능

         */
    }
}
