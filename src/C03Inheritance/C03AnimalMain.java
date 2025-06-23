package C03Inheritance;

import java.io.IOException;

public class C03AnimalMain {
    public static void main(String[] args) throws IOException {
        Dog d1 = new Dog();
        d1.sound();

        Cat c1 = new Cat();
        c1.sound();

        /// 상속 관계일때는 부모클래스의 타입을 자식클래스의 객체 타입으로 지정 가능
        Animal d2 = new Dog();

        /// sound2는 안됨; 부모클래스의 타입 지정 시, 부모 클래스에서 정의된 메서드만 객체에서 사용 가능
        d2.sound(); /// Dog의 객체
        //d2.sound2(); 사용 불가능
    }
}

class Animal {
    public void sound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
    public void sound2(){
        System.out.println("멍멍멍멍");
    }
}

class Cat extends Animal{
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
