package C02ClassBasic;

public class C04PersonMain {
    public static void main(String[] args) {
////        회원가입 예시
//        String name1 = "hong1";
//        String email1 = "ignis201@naver.com";
//        int age1 = 25;
//        printMember(name1, email1, age1);
//
//        String name2 = "hong2";
//        String email2= "hong2@naver.com";
//        int age2 = 30;
//        위와 같은 방식의 문제점
//        어떤 요소들이 그룹화되어 있지 않다보니 중복과 코드의 가독성이 저하
//
////        위와 같은 문제점을 해결하기 위해 클래스에 속성을 정의하고 객체로 생성하여 그룹화.
//        C04Person p1 = new C04Person();
//        p1.name = "hong1";
//        p1.email = "hong1@naver";
//        p1.age = 10;
//
//        C04Person p2 = new C04Person();
//        p2.name = "hong1";
//        p2.email = "hong2@naver.com";
//        p2.age = 30;


////        p1을 별도의 메서드 없이 그냥 출력할 경우 힙메모리 주소값이 출력
//        System.out.println(p1); ///p1만의 고유의 힙메모리 주소값 출력
//        printMember2(p1);
//
////        person의 변수값이 public 오픈돼 있을 경우 다른 클래스(패키지)에서 !너무 편하게! 변경가능하다
//        p2.name = "hongildong2";
//        printMember2(p2);

        C04Person p3 = new C04Person();
        p3.setName("hong3");
        p3.setEmail("hong3@naver.com");
        p3.setAge(30);

        p3.printPerson();

        System.out.println(p3.printPerson2()); ///return값이 있고 없고에 따라 달라짐



    }


    public static void printMember(String name, String email, int age) {
        System.out.println("이름은 : " + name + " 이메일은 : " + email + " 나이는 : " + age );
    }
    public static void printMember2(C04Person person) { /// person은 객체의 주소값이 매개변수로 전달
//        System.out.println("이름은 : " + person.name + " 이메일은 : " +person.email + " 나이는 : " + person.age); ///접근 불가
        System.out.println("이름은 : " + person.getName() + " 이메일은 : " + person.getEmail() + " 나이는 : " + person.getAge());
    }
}
