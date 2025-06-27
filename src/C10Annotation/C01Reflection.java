package C10Annotation;

import java.lang.reflect.Field;

public class C01Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /// reflection은 java에서 runtime 시점에 class의 변수를 수정할 수 있는 기능
        Person p1 = new Person();
        /// 아래와 같은 방식을 통해 private 변수인 name 변수에 직접 접근 가능
        Field nameField = Person.class.getDeclaredField("name");
        nameField.setAccessible(true); /// private에 접근 가능토록 세팅 변경
        nameField.set(p1, "Danny Lim");

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p1, 33); // 나이를 int로 설정

        System.out.println(p1);
    }
}

class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}