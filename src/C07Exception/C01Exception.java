package C07Exception;

import java.sql.SQLException;
import java.util.Scanner;

public class C01Exception {
    public static void main(String[] args) throws SQLException {
        /*
        /// 일반적인 예외(error) 처리 - 에러 나면 안됨 -> 프로그램이 중지가 안됨 : 예외가 발생 시에 프로그램이 중지되지 않도록 하는 프로그래밍
        System.out.println("나눗셈 프로그램");
        Scanner sc = new Scanner(System.in);
        /// 예외가 발생할 것으로 예상되는 코드들을 try{}로 감싼다.
        try{
            System.out.println("분자 입력 :");
            int head  = Integer.parseInt(sc.nextLine());
            System.out.println("분모 입력 :");
            int tail = Integer.parseInt(sc.nextLine());
            int r = head / tail; /// 여기서 예외 발생 시, try 내부의 아래코드는 실행되지 않는다.

            System.out.println("결과 :");
            System.out.println(r);
        }
        /// catch를 통해 예상되는 예외클래스를 분기처리
        catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
            /// 아래와 같은 방식으로 시스템 로그를 기록
            e.printStackTrace();
            System.out.println(e.getMessage()); /// 에러 핵심 메시지만 간략하게 출력
        }
        catch (NumberFormatException f){
            System.out.println("문자를 입력할 수 없습니다.");
            f.printStackTrace();
            System.out.println(f.getMessage());
        }
        catch (Exception all) {
            /// 모든 예외의 조상 클래스
            System.out.println("예상치 못한 에러 발생");
            all.printStackTrace();
            System.out.println(all.getMessage());
        }
        finally {
            /// 예외가 발생하든 하지 않든 무조건 실행되는 클래스
            System.out.println("무조건 실행되는 문구입니다.");
        }

        System.out.println("hello world");
         */
        /// 의도된 예외 강제 발생: 특정 시점에 프로그램 강제 중지

        System.out.println("비밀번호 입력 :");
        Scanner sc = new Scanner(System.in);
        String pw = sc.nextLine();
        /// 에러는 기본적으로 메서드를 호출한 쪽으로 전파된다.(이 경우는 login 메서드를 호출한 main에서 에러)
        login(pw);
        System.out.println("환영합니다.");

        /// checked exception의 경우에는 예외처리를 위임받게 되면 반드시 예외처리하거나, 다시 throws 해야함
        try{
            login2(pw);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /// throws 키워드를 통해 예외(에러)를 위임한다.
    /// 다만, unchecked 예외에서는, 예외가 강제가 아니므로, throws는 큰 의미가 없음
    /// 그러나, (서버 통신 등)checked에서는 예외 처리가 강제되므로, throws가 의미가 있음
    static boolean login (String password) throws IllegalArgumentException{ /// 명시적
        if (password.equals("1234")){
            return true;
        }
        else{
            /// 예외를 강제 발생시킴으로서 이 시점에서 해당 메서드 강제 종료
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
    }

    static boolean login2(String password) throws SQLException {
        if (password.equals("1234")){
            return true;
        }
        else {
            /// 해당 메서드 내에서 예외 처리를 하던, 아니면 명시적으로 throws 통해 호출 메서드 쪽에 위임
            throw new SQLException("잘못된 비밀번호입니다.");
        }
    }
}

/// 서버 통신 관련 에러 (checked error) 아니면 다 unchecked error다.
/// 강제 예외 발생은 unchecked
