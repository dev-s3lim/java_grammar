package C03Inheritance;

import java.io.IOException;

/// extends 키워드를 통해 상속을 수생 -> 부모의 변수와 메서드를 자식 클래스가 물려 받음
public class C01Inheritance extends Parents { /// extends 부모 (즉, 자식 클래스의 범위가 부모 클래스보다 넓다.)
                                              /// extends Parents2, Parents3 (X)
                                              /// 어떤 클래스의 어떤 메서드를 호출할건지 혼선 발생
    static int b = 20;

    public static void main(String[] args) throws IOException {
        C01Inheritance c1 = new C01Inheritance(); /// <- 여기가 핵심

        /// 변수 (ex: int d) 도 자식 클래스가 부모 클래스 보다 우선함
        int d = 9999;
        System.out.println(d);

        System.out.println(c1.a); /// 자식클래스에서 부모클래스의 a변수 상속
        System.out.println(c1.b);
        ///System.out.println(c1.c);

        ///메서드 상속도 가능
        c1.m1();
        c1.m2();
        c1.m3();
    }

    /// 자식 클래스 내 메서드
    public void m2(){
        System.out.println("자식 클래스 m2 메서드입니다.");
    }

    /// 부모보다 자식 클래스 메서드가 더 우선 순위 높음 (메서드 오버라이딩; 부모 메서드의 '재정의'; 동일한 메서드 명일 경우)
    public void m3(){
        System.out.println("자식 클래스 m3 메서드입니다.");
    }

    @Override /// override된 메서드임을 '명시적'으로 표현하는 방식 (자바 컴파일러한테 미리 알려주는 역할을 함) - 성능 최적화에 도움됨
    public void m1(){
        System.out.println("[오버라이딩] 자식클래스 m1 입니다."); /// 자식 클래스의 메서드가 우선하므로 부모 클래스의 메서드를 덮어쓰기함
    }
}

class Parents {
    public int a = 10;
    /// private 접근 제어자는 클래스 내에서만 접근 가능 (private이면 자식 클래스도 상속 못받는다.)
    private int c = 30;

    public int d = 100;

    public void m1() {
        System.out.println("부모 클래스입니다.");
        System.out.println(c);
    }

    public void m3() {
        System.out.println("부모 클래스 m3 메서드입니다.");
        System.out.println(c);
    }
}

/// Java 에서는 클래스의 다중 상속을 지원하지 않음... (Interface에서는 다중 상속을 지원함 -> 반드시 부모 인터페이스를 재정의하도록 되어있기 때문)
class Parents2 {
    public int e = 50000;
}

class Parents3 {
    public int f = 77777;
}

/// 오버라이딩 = 부모클래스의 매서드를 자식이 재정의
/// 오버로딩 = 매개변수의 개수와 타입이 다른 같은 이름의 메서드 선언