package C01Basic;

//클래스의 명명규칙
//1)반드시 public class 명과 파일명이 일치해야한다.
//2)일반적으로 대문자 알파벳으로 시작한다.

public class C00HelloWorld {
    public static void main(String [] args){
    //3) 메서드명과 변수명은 일반적으로 소문자 알파벳으로 시작한다.
    //public = 어디에서든 접근 가능하고, void = 리턴값이 없는 메서드
    //main 메서드는 프로그램 실행시 가장 먼저 실행되는 메서드
        System.out.println("Hello World");
        //sout 단축어를 통해 실행
        //command + / -> 자동 주석 생성
        /*
        여러줄에
        주석처리 시에 이와 같은 방법으로
        주석처리 가능 (많이 쓰는 걸 추천)
         */
    }
}