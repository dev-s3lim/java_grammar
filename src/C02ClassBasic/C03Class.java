package C02ClassBasic;

import java.io.IOException;
import java.util.*;

public class C03Class {
    public static void main(String[] args) throws IOException {
        /*
        System.out.println(MyCalculator.sum(10, 20));

        //A 부서의 매출
        //20원 매출 발생
        System.out.println(MyCalculator.acc(20));
        //30원
        System.out.println(MyCalculator.acc(30));
        //40원
        System.out.println(MyCalculator.acc(40));
        //누적 : 90원

        //B 부서의 매출
        //10원 매출 발생
        System.out.println(MyCalculator.acc(10)); // B 부서는 10원이 되어야함 (클래스만 사용시의 한계)
        //20원
        System.out.println(MyCalculator.acc(20));

         */

        //객체를 활용한 매출 계산
        //A 부서 매출 : 10원, 20원
        MyCalculatorInstance aDept = new MyCalculatorInstance();
        aDept.sumAcc(10);
        System.out.println(aDept.total);
        aDept.sumAcc(20);
        System.out.println(aDept.total);

        MyCalculatorInstance bDept = new MyCalculatorInstance();
        bDept.sumAcc(30);
        System.out.println(bDept.total);
        bDept.sumAcc(50);
        System.out.println(bDept.total);

        System.out.println(MyCalculatorInstance.total_count);
        /*
        aDept.sumAcc(10);
        aDept.sumAcc(20);
        aDept.printDeptSales("A브랜드", aDept.total);

        MyCalculatorInstance bDept = new MyCalculatorInstance();
        bDept.sumAcc(20);
        bDept.sumAcc(40);
        bDept.printDeptSales("B브랜드", bDept.total);

        MyCalculatorInstance cDept = new MyCalculatorInstance();
        cDept.sumAcc(100);
        cDept.sumAcc(50);
        cDept.printDeptSales("C브랜드", cDept.total);

         */

        //자료구조에서 객체 사용 예시
        //배열
        String[] arr1 = {"hello", "java", "python"};
        Arrays.sort(arr1); // 클래스 메서드
        System.out.println(arr1.length); // 객체 메서드

        List<String> myList = new ArrayList<>();
        Collections.sort(myList); // 클래스 기반
        myList.sort(Comparator.naturalOrder()); // 객체 기반
    }
}
/*
class MyCalculator {
    public static int sum (int a, int b){
        return a+b;
    }
    // static 이 붙어있으면 class 변수, static이 붙어 있지 않느면 객체 변수
    static int total = 0; //***객체이기 때문에 static 붙여줌

    public static int acc (int a){
        total += a;
        return total;

 */

class MyCalculatorInstance { //객체를 만들기 위한 클래스가 됨 -> 즉, 클래스의 복제본이 생성됨 (별도의 객체에 할당 가능해며, 고유의 힙메모리 보유)
    //MyCalculator A, B, C 가 만들어지는 효과와 동일

    int total = 0;
    // 클래스 변수는 모든 인스턴스(객체) 간의 상태 공유 목적으로 주로 사용
    static int total_count = 0;

    //클래스를 만들면 아래와 같은 클래스명의 이름을 가진 특별한 메서드 (생성자)가 기본으로 만들어짐 (깡통)
    //객체 생성 시 실행되면서, 객체 변수를 초기화하기 위한 목적으로 주로 사용
    public MyCalculatorInstance(){
        total_count++;
    }

    // 클래스 메서드는 객체의 상태와 상관없는 즉시 *독립적인* 로직 수행 시에 사용 가능
    public static int sum (int a, int b){
        return a+b;
    }

    public void sumAcc (int total){
        //this는 객체 그 자신을 의미한다.
        //일반적으로 매개변수와 객체변수를 구분 짓기 위해 사용한다. ex) 매개 변수명도 total, 객체 변수명도 total
        this.total += total;
    }

    public void printDeptSales(String deptName, int amount) {
        System.out.println(deptName + " 부서의 매출은 = " + amount + " 입니다.");
    }

}