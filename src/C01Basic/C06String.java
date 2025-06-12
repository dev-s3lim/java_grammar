package C01Basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class C06String {
    public static void main(String[] args) throws IOException {
        //원시 자료형은 Stack 메모리에 저장되므로, 비교시 값자체를 비교 (클래스 기반 아님) <- 기능 빈약함
        /*
        int a = 10;
        int b = 10;
        System.out.println(a==b);

        //참조자료형의 경우, 기본적으로 Heap 메모리 주소값끼리 비교된다. (클래스 기반 및 객체 - 클래스의 복제본 생성 가능) <- 여러 기능 보유
        String st = new String("Hello");
        String str = new String("Hello");

        System.out.println(st == str); // Heap 메모리값으로 비교되는 중 (이상한 난수값으로 출력)
        System.out.println(st.equals(str));

        //Wrapper class 기본형 타입을 wrapping한 클래스 (int 기능이 빈약해서 Integer이라는 wrapper를 만듬)
        int i1 = 10;
        // 자동으로 형변환을 시켜줌
        // 오토 박싱 : 원시자료형에서 wrapper 클래스로 자동 형변환
        // 원래는 Integer i2 = new Integer (10); 이렇게 해야함 (훨씬 일반적)
        Integer i2 = 10;
        // 오토 언박싱 : wrapper를 원시자료형으로...
        int i3 = i2;

        long d = 10;
        Long d1 = 10L;

        Character ch = 'a';

        // List<참조자료형> list...
        // int [] <- 배열은 원시자료형으로도 사용 가능 ; 배열에는 원시타입 세팅이 가능함 (부족한 메모리를 최적화하는데 가장 뛰어나며, 효율적)
        int[] arr = {10, 20, 30};
        // 그외 (List, Set, Map) 등에는 참조 자료형을 세팅해야함 (메모리를 더 쓰게됨)
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);

        // wrapper class 의 기능들
        int i4 = 10;
        String st3 = Integer.toString(i4); //
        String st4 = String.valueOf(i4); //i4 정수를 문자열로 변환
        i4 = Integer.parseInt(st3);

         */

        /*
        // String 선언 방법
        // 1. 객체 선언방법
        String st1 = new String ("Hello World"); // 각 Heap 메모리를 생성하기 때문에 메모리 낭비
        String st2 = new String ("Hello World");

        // 2. 리터럴 방식 (java에서 권장하는 방식 String (intern) pool 을 사용해서 반대로 중복되는 Heap 주소 값을 가져옴 -> 공간 낭비 방지)
        String st3 = "Hello World";
        String st4 = "Hello World";

        System.out.println(st1 == st2);
        System.out.println(st3 == st4);
        System.out.println(st1 == st3);
        // 참조자료형의 경우 == 를 지양한다.
        System.out.println(st1.equals(st3)); //그냥 참조자료는 equals 써라

         */

        // 각종 메서드
        // equals : 두 문자열 비교
        /*
        String st1 = "Hello1";
        String st2 = "hello1";
        String st3 = "HeLlo1";

        System.out.println(st1.equals(st3));
        System.out.println(st1.equalsIgnoreCase(st3));

        // length : 문자열 길이
        String st4 = "Hello1 World Java";
        System.out.println(st4.length());

        // charAt(n = 몇번째) : 특정 index의 문자값을 리턴
        char c = st4.charAt(3);

         */
        /*
        String st5 = "Hello1 World1 Java2";
        // 위 문자열의 소문자 알파벳 개수 구하기 :
        int cnt = 0;

        for (int i = 0; i < st5.length(); i++){
            if ('a' <= st5.charAt(i) && st5.charAt(i) <= 'z'){
                cnt++;
            }
        }
        System.out.println(cnt);
         */
        /*
        String st6 = "abcdefgabaaaa";

        int cnt = 0;
        for (int i = 0; i < st6.length(); i++){
            if (st6.charAt(i) == 'a'){
                cnt++;
            }
        }
        System.out.println(cnt);

        */
        // toCharArray : String 문자열을 char 배열로 리턴
        /*
        String st7 = "abcdefgabaaaa";
        char[] chArr = st7.toCharArray();
        int cnt = 0;

        for (char c : st7.toCharArray()){
            if (c == 'a') cnt++; // 실행문이 1줄밖에 없을 때는 중괄호 생략 가능
        }
        System.out.println(cnt);

         */

        // indexOf : 특정 문자열의 위치 (index) 반환. 가장 먼저나오는 문자열의 위치 반환
        /*
        String st1 = "hello java java";
        System.out.println(st1.indexOf("java"));

        // contains : 특정 문자열이 포함되어 있는지 여부를 리턴 (boolean)
        System.out.println(st1.contains("hello")); //true
        System.out.println(st1.contains("world")); //false

         */

        // 문자열 더하기 : +=
        /*
        String st1 = "hello";
        st1 += " world";
        st1 += " 1"; // String에 char를 더하면 가산됨
        System.out.println(st1);

         */

        // substring(a,b) : a 이상 b 미만의 index 문자를 잘라 문자열 반환
        /*
        String st1 = "hello world";
        System.out.println(st1.substring(0, 5));
        System.out.println(st1.substring(6, st1.length()));
        */

        // 공백 제거 메서드 : 문자열 양쪽 사이드 공백 제거
        /*
        String st1 = " Hello World ";
        String trim1 = st1.trim();
        String strip1 = st1.strip();
        System.out.println(trim1);
        System.out.println(strip1);


        // 대소문자 변환, toLowerCase, toUpperCase : 모든 문자열을 소문자로 변환
        String s1 = "Hello";
        String s2 = s1.toUpperCase();
        String s3 = s2.toLowerCase();
        System.out.println(s2);
        System.out.println(s3);

         */

        // replace (a,b) : a 문자열을 b 문자열로 대체
        /*
        String st1 = "hello world";
        String st2 = st1.replace("world", "java");
        System.out.println(st2);

         */

        // replaceAll (a, b) : replace 와 동일하나 정규 표현식을 쓸수 있는점이 차이점
        /*
        String st1 = "01abcABC한글123";
        //한글 제거
        String answer1 = st1.replaceAll("[가-힣]","");
        String answer2 = st1.replaceAll("[a-z]","");
        String answer3 = st1.replaceAll("[A-Za-z]","");
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);

         */

        /*
        // 전화번호
        String num = "010-1234-4567";
        boolean check = num.matches("^\\d{3}-\\d{4}-\\d{4}$");
        if (check == false){
            System.out.println("다시 입력하세요.");
        }
        System.out.println(check);
        // 이메일
        String email = "한글123@naver.com";
        boolean checkEmail = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
        System.out.println(checkEmail);
        // split
        String a = "a:b:c:d";
        String[] arr = a.split(":");
        System.out.println(Arrays.toString(arr));

        String b = "a b c  d";
        String[] arr2 = b.split(" ");
        String[] arr3 = b.split("\\s+"); // \s는 공백을 의미, \n은 줄바꿈을 의미
        System.out.println(Arrays.toString(arr2));

        //null과 공백의 차이
        String st1 = null; //null 은 String 아니나, 특수한 타입이기에 가능
        String st2 = ""; //공백은 문자열
        System.out.println(st1 == st2);
        System.out.println(st2.isEmpty()); //true
        //System.out.println(st1.isEmpty()); //error : NullPointerException 발생
        String st3 = " ";
        System.out.println(st3.isEmpty());
        System.out.println(st3.isBlank());

        String abc = "Hello    World  Java";
        for (int i = 0 ; i < abc.length(); i++){
            if (abc.substring(i, i+1).isBlank()){
                System.out.println(i + "번째는 blank");
            }
        }
         */

        /*
        // 문자열 합치기
        String[] arr = {"java", "python", "javascript"};
        String answer1 = "";
        for (String a : arr){
            answer1 += a;
            answer1 += " ";
        }

        System.out.println(answer1);
        String answer2 = String.join("\n", arr);

        System.out.println(answer2);

         */

        // StringBuffer : 문자열 조립 객체 (스프링 개발시에서는 버퍼 사용)
        /*
        StringBuffer sb = new StringBuffer();
        sb.append("java");
        sb.append("python");
        sb.append("javascript"); //append는 맨뒤의 문자열을 더하는 메서드

        String answer = sb.toString();
        System.out.println(answer);
        */
        /*
        String[] arr = {"java", "python", "javascript"};
        StringBuffer sb2 = new StringBuffer();

        for (int i = 0; i < arr.length; i++){
            sb2.append(arr[i]);
            sb2.append("\n");
        }
        sb2.insert(0, "C++\n");
        sb2.deleteCharAt(sb2.length()-1);
        System.out.println(sb2);

         */

        // StringBuilder : 문자열 조립 객체 (가장 빠름) <- 실전에서는 이거 쓰면 됨
        /*
        String st1 = "Hello";
        // StringBuilder는 동시성 이슈 O == Thread Safe하지 않음 (성능 높음) -- 문제풀 때는 빌더 (값 보장이 안됨)
        StringBuilder sb = new StringBuilder();
        // StringBuffer는 동시성 이슈 X == Thread Safe함 (성능 낮음) -- 웹 서비스에는 버퍼
        StringBuffer sb2 = new StringBuffer();

         */

        //문자열 뒤집기
        /*
        String st1 = "hello";
        StringBuilder sb = new StringBuilder();
            for (int i = st1.length()-1; i >= 0; i--){
                sb.append(st1.charAt(i));
            }
        System.out.println(sb);

         */

        //
        String A = "banana";

        StringBuffer sb = new StringBuffer();
        for (int i = A.length()-1; i >= 0; i--){
            sb.append(A.charAt(i));
            sb.insert(0, sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb);
    }
}
