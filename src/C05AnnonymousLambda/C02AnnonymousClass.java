package C05AnnonymousLambda;

import java.io.IOException;
import java.util.Scanner;

public class C02AnnonymousClass {
    /// 익명 내부 클래스
    public static void main(String[] args) throws IOException {

        /// AbstractAnimal을 상속한 별도의 객체가 존재하지 않고
        /// ***익명 클래스가 만들어짐과 동시에 '익명 객체'가 생성되고 있음
        /// abstract 외 interface 또한 구현체가 없는 경우가 있기 때문에 익명 객체로 생성 가능
        AbstractAnimal a1 = new AbstractAnimal() {
            @Override
            void makeSound() {}
        };
        a1.makeSound(); /// 메서드 2개 상속
        a1.makeSound2();

        Animal1 a2 = new Animal1() {
            @Override
            public void makeSound1() {

            }

            @Override
            public void makeSound2() {

            }
        };

        /// 예외 조항 : interface의 익명 객체에 구현 메서드가 '1개밖에 없을 때'에는 람다 표현식 (->) 사용 가능
        /// 메서드 2개 이상을 가지게 되면 어떤 메서드를 쓸지 모르기 때문에 람다식 사용 불가능
        Animal2 a3 = new Animal2() {
            @Override
            public void makeSound1() {
            }
        };

        Animal2 a4 = () -> { /// 한개의 구현체 (메서드 ) + 익명 객체 = 람다 가능
            System.out.println("hello world 1");
            System.out.println("hello world 2");
        };

        a4.makeSound1();
        /// 원래는...
        /// interface -> 상속 -> 메서드


        /// 실행문이 1줄일때는 중괄호 {} 제거 가능
        Animal2 a5 = () -> System.out.println("hello world 3");

        a5.makeSound1();

        /// 매개변수가 있는 익명 객체의 람다함수 생성
        Animal3 a6 = new Animal3() {
            @Override
            public String makeSound1(String a, String b, String c) {
                return "";
            }
        };
        Animal3 a7 = (i1, i2, i3) -> {return i1+", "+i2+", "+i3;};
        Animal3 a8 = (i1, i2, i3) -> i1+", "+i2+", "+i3;
        System.out.println(a7.makeSound1("kotlin","javascript","html"));
        System.out.println(a8.makeSound1("java","python","C++"));

        /// 익명 객체 생성 - 기능 : int 숫자값이 10이상이면 a + b를 리턴, 10미만이면 a만 리턴
        Animal4 p1 = new Animal4() {
            public String makeSoundPractice(String a, String b, int c) {
                if (c >= 10) {
                    return a + b;
                } else if (c < 10) {
                    return a;
                }
                return null;
            }
        };

        Animal4 p2 = (a, b, c) -> {
            if (c >= 10) {
                return a + b;
            } else if (c < 10) {
                return a;
            }
            return null;
        };
        System.out.println(p1.makeSoundPractice("A","B",5));
        System.out.println(p2.makeSoundPractice("A","B",11));
    }
}

abstract class AbstractAnimal {
    /// 추상 클래스
    /// 객체는 기본적으로 못만듬 (구현체가 없기 때문)
    abstract void makeSound();

    void makeSound2() {
    }

}

interface Animal1{
    void makeSound1();
    void makeSound2();
}

interface Animal2{
    void makeSound1();
}

interface Animal3{
    String makeSound1(String a, String b, String c);
}

interface Animal4{
    String makeSoundPractice(String a, String b, int c);
}