package C03Inheritance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/// final 키워드가 붙은 클래스는 상속 불가 ; final 키워드가 붙은 메서드는 Override 불가
//public class C06AbstractMain extends finalParents {
public class C06AbstractMain {
    public static void main(String[] args) throws IOException {
        /*
        AbstractDog d1 = new AbstractDog();
        d1.makeNoise1();
        d1.makeNoise2();

         */

        /// 추상 클래스는 구현체 없는 메서드가 있으므로, 기본적으로 객체 생성 불가능
        // AbstractAnimal a1 = new AbastractAnimal();

        AbstractAnimal d2 = new AbstractDog(); /// 우측이 객체의 실체이므로 (Dog class 통해 만들어짐) d2의 makeNoise2 사용 가능
        d2.makeNoise1();
        d2.makeNoise2();

        /// 모든 메서드가 abstract인 클래스를 interface라 한다.
        /// interface에는 구현체는 없고 모두 abstract이다. (선언만 있다.)
        /// 기본적으로 별도의 객체 생성 불가
        //List<Integer> myList = new List<>();
    }
}

/// 추상 메서드가 '하나'라도 있으면 abstract 키워드를 붙이고 추상 클래스가 됨
/// 추상 클래스는 다중 상속이 안됨 (하나라도 구현체가 있을 수 있기 때문)
abstract class AbstractAnimal { /// 혼자서 동작 못함
    /// 구현체가 있는 메서드
    void makeNoise1(){
        System.out.println("동물은 소리를 냅니다.");
    }

    /// 구현체가 없는 메서드
    /// 메서드를 선언만 하고 구현이 없는 메서드 선언 시, abstract 키워드 사용
    /// 구현의 강제성
    abstract void makeNoise2();
}

class AbstractDog extends AbstractAnimal{

    @Override /// abstract는 반드시 @Override
    void makeNoise2() {
        System.out.println("멍멍");
    }
}

final class finalParents {
    /// 상속 불가능한 부모 클래스
}