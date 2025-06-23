package C04Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C01InterfaceMain {
    public static void main(String[] args) throws IOException {
/*
        C01Dog d1 = new C01Dog();
        d1.makeSound();

        C02Cat c1 = new C02Cat();
        c1.makeSound();

 */


        /// 다형성 : 하나의 부모타입으로 여러 자식 객체를 다룰 수 있음
        C01AnimalInterface1 d2 = new C01Dog(); ///C01Dog를 상속만 받고 있음
        d2.makeSound();

        /// 부모 클래스 (자식의 객체) = 자식 클래스
        C01AnimalInterface1 c2 = new C02Cat();
        c2.makeSound();
/*
        /// 예시:
        List<Integer> myList1 = new ArrayList<>(); /// 우측 클래스에 모든 구현체가 있음
        List<Integer> myList2 = new LinkedList<>();

        /// Interface 장점
        /// 1. 개발의 표준(규격)을 지정할 수 있다.
            // ex: List는 반드시 Integer 타입이어야 한다.
        /// 2. 다형성의 장점 (왼쪽에 부모타입을 적는 것) - 기존의 구현체를 다른 객체로 변경할 시의 이점
            // 왼쪽에 인터페이스, 오른쪽에는 구현체를 쓴다.
            // ex : PaymentInterface p1 = new Kakaopay();
            // ex : PaymentInterface p1 = new Tosspay();



        ///디중 구현의 예시 -> interface 의 종류에 따라, 사용 가능 메서드 제한
        List<Integer> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
    }

 */
    }

}
