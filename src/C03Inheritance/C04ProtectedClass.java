package C03Inheritance;

public class C04ProtectedClass {
    /// 변수 메서드에는 4가지 접근 제어자 존재
    /// 1. public = 전체 접근 (다른 패키지에서도 접근 가능) - 전역
    public String st1 = "hello java1";
    /// 2. private = 다른 패키지에서 접근 불가 (클래스 내에서만 접근 가능) - 클래스 내
    private String st2 = "hello java2";
    /// 3. default = 생략 가능 및 '패키지 내'에서만 접근 가능 - 같은 패키지 내
    static String st3 = "hello java3";
    /// 4. protected = 패키지(한 폴더)를 벗어나더라도 상속 관계인 경우에는 접근 가능; - 다른 패키지라하더라도 상속 관계
    protected String st4 = "hello java4";

    public static void main(String[] args) {

    }
}
