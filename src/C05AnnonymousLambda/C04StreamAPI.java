package C05AnnonymousLambda;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.*;

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
/*
        String[] stArr = {"hello", "java", "world"};
        String[] answer = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(a -> new String[a]);


        /// 메소드 참조: 하나의 메소드만을 호출하는 경우에 매개변수를 제거하는 방식 -> 클래스명::메서드명
        Arrays.stream(stArr).forEach(a -> System.out.println());
        Arrays.stream(stArr).forEach(System.out::println);

        String[] answer2 = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(a -> new String[a]);
        String[] answer3 = Arrays.stream(stArr).filter(a -> a.length() >= 5).toArray(String[]::new);

 */
/*
        /// 스트림api 실습
        /// 1.list에 Student객체 4개 담기 kim:20, choi:32, lee: 35, park:22 O


        List<Student1> list = new ArrayList<>();

        list.add(new Student1("kim", 20));
        list.add(new Student1("choi", 32));
        list.add(new Student1("lee", 35));
        list.add(new Student1("park", 22));

        /// 2.모든 객체의 평균 나이
        double averageAge = list.stream().mapToInt(Student1::getAge).average().getAsDouble();

        /// 3.가장 나이 어린 사람 찾기 (정렬)
        Student1 s1 = (Student1) list.stream().sorted(new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                return o1.getAge()-o2.getAge();
            }
        }).findFirst().get();
        System.out.println(s1);

        /// 4.30대인 사람들의 이름만 모아서 새로운 스트링 배열에 담기
        String[] arr1 = list.stream().filter(a->a.getAge()>=30).map(a -> a.getAge()).toArray(String[]::new);
        System.out.println(Arrays.toString(arr1));


 */
/*
        /// optional 객체 -> 특정 객체에 값이 없을지도 모른다는것을 명시적으로 표현
        String st1 = null;
        if (st1 != null){
            System.out.println(st1.compareTo("hello"));
        }
        else System.out.println("값이 없습니다.");

        Optional<String> opt1 = Optional.ofNullable("hello");
        if(opt1.isPresent()){ /// 검사 후 get하는 것이 정석
            System.out.println(opt1.get().compareTo("hello"));
        }
        else System.out.println("값이 없습니다.");

 */
        /// optional 객체 생성 방법 3가지
        /// 1.
        Optional<String>opt1 = Optional.empty(); /// 비어있는 Optional 객체 생성
        /// 2.
        Optional<String>opt2_1 = Optional.ofNullable(null); /// 비어있는 Optional 객체 생성 (있을수도, 없을수도 있음)
        Optional<String>opt2_2 = Optional.ofNullable("hello"); /// 값이 있는 Optional 객체 생성 (있을수도, 없을수도 있음)
        /// 3.
        Optional<String>opt3 = Optional.of("hello"); /// 값이 있는 Optional 객체 생성 (반드시 값이 있어야 됨)

        /*
        /// optional 객체 처리 방법 4가지
        /// 1. isPresent()로 확인 후 get()
        if (opt1.isPresent()){
            System.out.println(opt2_1.get());
        }
        else
        ///에러 발생 else System.out.println(opt2_1.get());
        System.out.println("값이 없습니다.");


         */
        /*
        /// 2. orElse() : 값이 있으면 값 return, 없으면 지정한 값 return
        System.out.println(opt2_1.orElse("값이 없습니다."));
        System.out.println(opt2_2.orElse("값이 없습니다."));

        /// 3. orElseGet() : 값이 있으면 있는 값 return, 없으면 람다 함수 실행
        System.out.println(opt2_2.orElseGet(() -> new String("값이 필요없습니다.")));

        /// 4. (가장 많이 사용) orElseThrow : 값이 있으면 있는 값을 return, 없으면 지정된 예외 처리 (에러) 강제 발생.
        /// 일부러 의도하여 에러 발생 시키는 경우임
        /// 개발에서 사용자에게 적절한 메시지 전달 목적과, 의도된 코드 중단을 목표로 강제로 예외 발생시킴
        System.out.println(opt2_1.orElseThrow(() -> new RuntimeException("값이 없습니다."))); /// 의도적 에러
        System.out.println(opt2_1.get()); /// 의도치 않은 발생

        /// 예시1 (평균 구하기 방법1):
        List<Student1> list = new ArrayList<>();

        OptionalDouble age = list.stream().mapToInt(a -> a.getAge()).average();
        if(age.isPresent()){
            System.out.println(age.getAsDouble());
        }
        else {
            throw new NoSuchElementException("값이 없습니다.");
        }

         */

        /// 실제 DB
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("kim", 22));
        list.add(new Student1("lee", 25));
        list.add(new Student1("park", 23));
        list.add(new Student1("choi", 21));

        System.out.println("조회하고자 하는 학생의 번호(index)를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        int ind = Integer.parseInt(sc.nextLine());
        /// index 범위가 list안에 있으면 optional.ofnullable or of, ofEmpty 섞어서

        Optional<Student1> optStudent;
        if(list.size() <= ind){
            optStudent = Optional.empty();
        }
        else {
            optStudent = Optional.of(list.get(ind));
        }
        System.out.println(optStudent.orElseThrow(() -> new NoSuchElementException("입력하신 index가 없습니다.")));

        /// 예시2 (평균 구하기 방법2):
        /*
        System.out.println(list.stream().mapToInt(a -> a.getAge()).average().orElseThrow(()
                -> new NoSuchElementException("값이 없습니다. 확인해주세요.")));

         */

        /// System.out.println(opt2_1.orElseThrow(() -> new RuntimeException("값이 없습니다."))); 걍 외워
    }
}

class Student1{
    private String name;
    private int age;

    public Student1(String name, double age) {
        this.name = name;
        this.age = (int) age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}