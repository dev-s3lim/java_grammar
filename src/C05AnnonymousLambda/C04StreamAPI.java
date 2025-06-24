package C05AnnonymousLambda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class C04StreamAPI {
    public static void main(String[] args) throws IOException {
/*
        /// 가장 전통적인 방식
        int[] arr = {20,10,4,12};
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        /// [지향] 함수형 프로그램 방식 : 데이터와 객체 중심이 아닌, 입력에 따른 출력만 존재
        /// StreamApi = java에서 함수형 프로그래밍을 지원하는 방식
        Arrays.stream(arr).forEach(a -> System.out.println(a));

        /// [간결함과 데이터 안정성] 입력 값을 훼손시키지 않을 수 있으나, 원본의 값을 수정할 때는 용이하지 않을 수 있음
        /// 함수형 프로그래밍 성능이 미세하게 더 떨어짐 (total, average 등 구할때는 많이 사용)
        /// 복사본

        /// Arrays.stream(arr) -> 스트림의 생성
        ///.forEach() -> 스트림의 각 요소를 소모하면서 동작 수행

        /// Stream의 생성 .stream()
        List<String> myList = new ArrayList<>();
        myList.add("html");
        myList.add("css");
        myList.add("js");

        Stream<String> stream1 = myList.stream();
        String[] myArr = new String[3];
        myArr[0] = "HTML";
        myArr[1] = "CSS";
        myArr[2] ="javascript";

        Stream<String> stream2 = Arrays.stream(myArr);

        /// 원시자료형을 위한 stream 객체가 별도로 존재
        int[] arr2 = {10,20,30,40,50};
        IntStream stream3 = Arrays.stream(arr2);

 */
/*
        /// stream의 중개 연산 (변환) : filter, map, sorted, distinct, mapToInt
        int[] arr = {10,10,30,40,50};

        /// 30보다 작은 값들의 총합을 구하라
        /// filter는 특정 기준을 대상으로 filtering하여 새로운 스트림을 반환하는 메서드
        /// sum은 stream의 요소를 하나씩 소모하여 총합을 구하는 메서드
        int total = Arrays.stream(arr).filter(n -> n <= 30).sum();
        System.out.println(total);

        /// map : 기존의 stream을 조작하여 새로운 stream을 반환한다.
        int[] arr2 = {10,10,30,40,50};
        int total2 = Arrays.stream(arr2).map(a -> a*10).sum();
        int[] i3 = Arrays.stream(arr2).map(a->a*10).toArray();

        int[] intArr3 = {10,10,30,40,50};
        int total3 = Arrays.stream(intArr3).distinct().sum();

        System.out.println(total3);

        int[] intArr4 = {10,40,10,30,50};
        int[] total4 = Arrays.stream(intArr4).sorted().toArray(); /// 원시 자료형은 comparator로 정렬 못함

        System.out.println(Arrays.toString(total4));

        /// mapToInt : intstream 형태로 변환해주는 map
        String[] stArr = {"HTML", "CSS", "JavaScript"};
        int lengthTotal = Arrays.stream(stArr).mapToInt(a -> a.length()).sum();
        /// Stream<String> -> Stream<Integer>

        System.out.println(lengthTotal);

 */
        /*
        int[] arr = {1,2,3,4,5,6};
        /// 1.arr에서 홀수만 담은 배열 생성 후 출력
        int[] a1 = Arrays.stream(arr).filter(a -> a % 2 != 0).toArray();
        System.out.println(Arrays.toString(a1));

        /// 2.arr에서 홀수만 걸러서 제곱값을 담은 배열 생성 후 출력
        int[] a2 = Arrays.stream(arr).filter(a -> a % 2 != 0).map(a -> a*a).toArray();
        System.out.println(Arrays.toString(a2));

        /// 3.arr에서 홀수만 걸러서 제곱값을 구하고, 해당 숫자값을 오름차 순으로 담아 배열 생성 후 출력
        int[] a3 = Arrays.stream(arr).filter(a -> a % 2 != 0).map(a -> a*a).sorted().toArray();
        System.out.println(Arrays.toString(a3));

         */

        /*
        /// 스트림의 소모 : forEach(출력), sum(합계), reduce(누적연산), max, min, count, findFirst (스트림의 1번째값 리턴)
        int[] arr = {10,20,30,40};
        Arrays.stream(arr).forEach(a -> System.out.println(a));
        int total = Arrays.stream(arr).sum();
        /// Optional객체 -> 값이 있을수도 있고, 없을수도 있다는 점을 명시한 객체 (경고 - max없을수도 있어~)
        int max = Arrays.stream(arr).max().getAsInt(); /// arr이 비어있을 경우, sum은 최소 0
        int min = Arrays.stream(arr).min().getAsInt();
        long count = Arrays.stream(arr).count();

        /// reduce : 누적 연산 -> reduce (초기값, 연산식)
        int accs = Arrays.stream(arr).reduce(0, (a,b) -> a+b);
        System.out.println(accs);

        int accm = Arrays.stream(arr).reduce(1, (a,b) -> a*b);
        System.out.println(accm);

        String[] stArr = {"hello", "java", "world"};
        String an = Arrays.stream(stArr).reduce("",(a, b) -> a+b);
        System.out.println(an);

        /// findFirst : 첫번째 요소 반환 (많이 쓰임)
        String first = Arrays.stream(stArr).filter(a -> a.length() >=5).findFirst().get();
        System.out.println(first);

         */

        /// 주의사항 : generic의 타입 소거
        /// 자바의 runtime 시점에 generic의 타입소거 발생
        /// -> toArray를 통해 바로 새로운 String 배열을 만드는 것은 불가
        /// IntStream은 따로 만든 것이라서 toArray 그냥 써도 됨
        String[] stArr = {"hello", "java", "world"};
        String[] answer = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(a -> new String[a]);
    }
}
