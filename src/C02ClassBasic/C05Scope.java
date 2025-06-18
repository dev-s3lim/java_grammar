package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

//변수의 유효범위
public class C05Scope {
    public static int v2=10; ///클래스변수
    public static void main(String[] args) {
//        지역변수의 유효범위
        int v1 = 10;
        scope(v1);//20 | 원시자료형은 스택에 값이 할당돼있어서 그 값을 던짐
        System.out.println(v1);//10
//        this.scope(); ///이게 불가한 이유는 main이 클래스메서드이기 때문에 객체메서드를 호출 할 수는 없다.
/*
        클래스 메서드: 객체 필요없이 실행가능
        객체 메서드 : 객체 생성이 반드시 필요
        클레스 메서드내에서 객체 메서드를 호출 할 수 없음
        객체 메서드에서 객체 메서드 호출 가능
        객체 메서드에서 클래스 메서드 호출 가능할까
/

//        객체의 유효범위
/
        C04Person p1 = new C04Person();
        p1.setName("yoon");
        p1.setEmail("ignis201@naver.com");
        p1.setAge(25);
        scope2(p1); ///메서드간에 객체를 넘길 때 객체의 주소값을 넘겨주는 것이다.
        System.out.println(p1.printPerson2());

        List<C04Person> myList = new ArrayList<>();
        myList.add(p1);///메모리 주소를 add
        myList.get(0).setAge(40);
        System.out.println(p1.printPerson2());
*/


//        클래스변수의 유효범위
        System.out.println(v2);

    }
    /// 강사님이 메서드 구현 보여줄때 static을 붙이는 이유 : 매번 객체 선언 하기 번거로워서
    public static void scope(int v1) { /// call by value
        v1 = 20;
        v2 = 30;
        System.out.println(v1);
    }
    public static void scope2(C04Person p1) { /// 힙 메모리 주소, call by reference
        p1.setAge(23);
        System.out.println(p1.printPerson2());
    }
    /// 클래스 변수 (최상위)
    /// 객체의 전달 방식 (힙메모리)
}