package C07Exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class C01Exception {
    public static void main(String[] args) {
////        일반적인 예외처리 방식 : 예외가 발생시에 프로그램이 중지되지 않도록 하는 프로그래밍.
//        System.out.println("나눗셈 프로그램입니다.");
//        Scanner sc = new Scanner(System.in);
////        예외처리 : 예외가 발생할 것으로 예상되는 코드를 try로 감싼다.
//        try {
//            System.out.println("분자를 입력해주세요");
//            int head = Integer.parseInt(sc.nextLine());
//            System.out.println("분모를 입력해주세요");
//            int tail = Integer.parseInt(sc.nextLine());
//            int result = head/tail; //여기서 예외 발생시 try내부의 하단의 코드는 실행되지 않음.
//            System.out.println("두 수를 나눈 결과 값은 " + result);
////            catch를 통해 예상되는 예외클래스를 분기처리한다.
//        }catch (ArithmeticException e){
//            System.out.println("0으로 나누시면 안됩니다.");
////            아래와 같은 방식으로 시스템 로그를 기록.
//            e.printStackTrace();
//            System.out.println(e.getMessage()); //메시지만 간략히 출력
//        }catch (NumberFormatException e){
//            System.out.println("문자를 입력하시면 안됩니다.");
//            e.printStackTrace();
////        Exception은 모든 예외의 조상 클래스
//        }catch (Exception e){
//            System.out.println("예상치 못한 에러가 발생했습니다.");
//            e.printStackTrace();
//        }finally {
////            예외가 발생하든 하지 않든 무조건 실행되는 구문
//            System.out.println("무조건 실행되는 문구 입니다.");
//        }

////        의도된 예외 강제 발생 : 특정 시점에 프로그램을 강제 중지.
//        System.out.println("로그인을 위한 비밀번호를 입력해주세요");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        login(input);

//        checked exception의 경우
//        1)호출받는 쪽에서 예외처리 후 unchecked exception 예외발생. 호출하는쪽에서 예외처리하여 사용자에게 적절한 message전달
        try {
            String result = fileRead("src/C07ExceptionFileParsing/test.txt");
            System.out.println(result);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
//        2)throws를 통해서 checked예외처리를 위임받게되면, 호출하는 쪽에서 예외처리
//        String result= null;
//        try {
//            result = fileRead("src/C07ExceptionFileParsing/test.txt");
//        } catch (IOException e) {
//            throw new RuntimeException("입출력 과정에서 예외가 발생 했습니다.");
//        }
//        System.out.println(result);
    }

    //    throws키워드를 통해 예외를 위임.
//    다만, unchecked예외에서는 예외처리가 강제가 아니므로, thorws가 큰의미는 없음.
//    그러나, checked예외에서는 예외처리가 강제되므로, throws가 의미가 있음.
    static boolean login(String password) throws IllegalArgumentException, NoSuchElementException  {
        if(password.equals("1234")){
            return true;
        }else if(password==null){
//            예외를 강제 발생시킴으로서 이 시점에서 해당 메서드 강제 종료
//            예외는 기본적으로 해당 메서드를 호출한 쪽으로 전파
            throw new IllegalArgumentException("비밀번호를 잘못 입력하였습니다.");
        }else{
            throw new NoSuchElementException("그러한 비밀번호 없습니다.");
        }
    }

    //    static String fileRead(String path) throws IOException {
    static String fileRead(String path) throws RuntimeException {
        Path filePath = Paths.get(path);
//        checked Exception의 경우 예외처리가 강제
//        방법1.checked를 try catch한 이후에 unchecked예외를 다시 throw
        String text = null;
        try {
            text = Files.readString(filePath);
        } catch (IOException e) {
//            System.out.println("입출력 과정에서 예외가 발생했습니다.");
//            보통은 코드중지목적으로 unchecked exception으로 다시 throw.
            throw new RuntimeException("입출력 과정에서 예외가 발생했습니다.");
        }
////        방법2. 현재 메서드를 호출하는 쪽으로 예외를 위임(throws).
//        String text = Files.readString(filePath);
        return text;
    }


}
