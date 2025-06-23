package C04Interface;

public class C01AnimalMainClass implements C01AnimalInterface3 {
    /// interface3 쓰면 2개 메서드 사용 가능 (상속 관계 따져보면)
    @Override
    public void makeSound() {

    }

    @Override
    public String play(String a, String b) {
        return "";
    }
}

/// 인터페이스A 객체명 = new 클래스A();
/// 좌측이 더 메서드가 적을 수 밖에 없다.
/// 추가적으로 우측에 메서드 +@ 할 수 있음.
