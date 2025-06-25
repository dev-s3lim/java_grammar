package C06EtcClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04GenericMain {
    public static void main(String[] args) {
        /// <>꺽쇠
        String[] stArr = {"java", "python", "C"};
        /// 자리가 체인지된 객체 출력 메서드
        stChange(stArr, 0, 1);
        //System.out.println(Arrays.toString(stArr));

        Integer[] intArr = {10,20,30};
        intChange(intArr, 0, 1);
        //System.out.println(Arrays.toString(intArr));

        allChange(stArr, 0, 1);
        allChange(intArr, 0, 1);

        /// 일반 객체 생성시
        Person p1 = new Person("hong");
        GenericPerson<String> p2 = new GenericPerson<>("hong");
        GenericPerson<Integer> p3 = new GenericPerson<>(10);

        /// 제네릭 사용 예시
        List<String> list = new ArrayList<>();
    }

    /// generic 메서드는 반환타입 왼쪽에 <T>라고 선언
    /// 이때 T에는 참조형 변수인 객체 타입만을 허용 (T는 어떤 타입이라도 들어와도 됨)
    static<T> void allChange(T[] arr, int a, int b){
        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void stChange(String[] arr, int a, int b){
        String tmp = arr [a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void intChange(Integer[] arr, int a, int b){
        Integer tmp = arr [a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}

/// generic class는 클래스명 옆에 <T> 선언 -> 동적인 클래스 선언 방식
class GenericPerson<T> {
    private T value;

    public GenericPerson(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class Person {
    private String value;

    public Person(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}