package C03Inheritance.Protected;

import C03Inheritance.*;
/// 패키지 바로 하위의 모든 class는 *로 import 가능
/// 다만, 패키지 내의 패키지 안의 class *로 불가능
/// 같은 패키지 내에 클래스가 아닌 경우에는 import 필요

/// !!!클래스에는 public, default 접근제어자만 존재!!! (변수는 4개 다 존재)
public class ProtectedTest extends C04ProtectedClass {
    public static void main(String[] args) {
        ProtectedTest p1 = new ProtectedTest(); /// p1은 상속 받고 있음

        //public - 전역 접근 가능
        p1.st1 = "hello python";

        //default
        //p1.st3 = "hello python"; (패키지 다르므로 에러)

        //protected (상속 관계가 있을 경우에만 패키지가 달라도 접근 가능)
        p1.st4 = "hello python";

        C04ProtectedClass p2 = new C04ProtectedClass();
        //p2.st4 = "hello python";
        /// p2는 상속 받지 않고있는 '부모' 클래스의 객체이므로 protected 접근 불가 (public만 접근 가능)
    }
}
