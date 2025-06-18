package C02ClassBasic;

import java.io.IOException;

public class C01Method {
    public static void main(String[] args) throws IOException {
        //for문을 이용해 1~10까지 가산
        /*
        int total = 0;

        for (int i = 1; i <= 10; i++){
            total += i;
        }

        System.out.println(total);

        //for문을 이용해 10~20까지 가산
        int total2 = 0;

        for (int i = 10; i <= 20; i++){
            total2 += i;
        }

        System.out.println(total2);

         */

        // 메서드 : 지속적인 중복적인 기능 반복을 방지하기 위해 '모듈화' 시켜 별도 분리 후 호출
        int total1 = sumAcc(1, 10);

        // 클래스 메서드 기본 호출 방식은 보통 : 클래스명.메서드명();
        System.out.println((C01Method.sumAcc(1, 10)));

        // 예외 : 같은 클래스 내에서 정의된 클래스 메서드의 호출은 클래스명 생략 가능
        System.out.println(sumAcc(10, 20));

    }

    // 접근 제어자 (public), 클래스 메서드 여부 (클래스일 경우 static or 없을 경우 객체 메서드) 필요
    // int, String, Arrays 등은 반환 타입, 매개변수 (input 값)
    public static int sumAcc(int start, int end){
        int total = 0;

        for (int i = start; i <= end; i++){
            total += i;
        }
        return total;
    }
}
