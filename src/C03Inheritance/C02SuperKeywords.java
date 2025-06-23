package C03Inheritance;

import java.io.IOException;

public class C02SuperKeywords extends SuperParents {
    int a = 10;

    C02SuperKeywords(){
        /// super() -> 부모 클래스 '생성자'를 호출(접근)하는 메서드
        super(77);
    }

    public static void main(String[] args) throws IOException {
        C02SuperKeywords c2 = new C02SuperKeywords();
        System.out.println(c2.a);
        c2.display();

    }

    public void display (){
        System.out.println("자식의 변수 " + a);
        System.out.println("부모의 변수 " + super.a); ///부모 클래스의 메서드를 호출하려면 super. 붙이면 됨
    }
}

/// 같은 패키지 내에서 클래스명 중복 불가
/// 부모 클래스를 상속 받을 때, 부모 클래스에 기본 생성자 (constructor)가 없으면, 자식 클래스에서 상속 시 기본적으로 에러 발생
class SuperParents {
    int a = 20;
    int b;

    public SuperParents (int a){
        this.a = a;
        this.b = 99;
    }

    /*
    public SuperParents (){
    } /// 깡통 생성자 만들어 줘야 에러 안남 (내가 별도로 만든 생성자는 Java가 쉽게 호출 못함)

     */
}