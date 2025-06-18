package C02ClassBasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 메서드 오버로딩은 같은 이름의 메서드명을 사용하되, 매개변수의 개수 또는 타입이 달라지는 메서드 생성 방식.
public class C06MethodOverloading {
    public static void main(String[] args) throws IOException {
        //메서드 오버로딩 사례 (example)
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(0, 20);
        System.out.println("hello");
        System.out.println(20);

        //직접 메서드 오버로딩 후 호출
        System.out.println(sum(10, 20));
        System.out.println(sum(10, 20, 30));
        System.out.println(sum(10.5, 20.5));

    }

    public static int sum(int a, int b){
        return  a+b;
    }
    public static int sum(int a, int b, int c){
        return  a+b+c;
    }
    public static double sum(double a, double b){
        return a+b;
    }
}
