package C01Basic;

import java.io.IOException;
import java.util.Scanner;

public class C04IfStatement {
    public static void main(String[] args) throws IOException {
        //도어락 키 예제
        /*String answer = "1234";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.length() != 4) {
            System.out.println("비밀번호가 틀렸습니다.");
        }
        else if(input.equals(answer)){
            System.out.println("문이 열렸습니다.");
        }
        else{
            System.out.println("비밀번호가 틀렸습니다.");
        }*/

        /*Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

         */
        //  if와 else if 구문에서 조건식은 택 1로서, 한조건에 해당하면 실행 후 구문 밖으로 빠져나간다.
        /*if (money > 10000){
            System.out.println("택시를 이용하세요.");
        }
        else if (money >= 3000){ // && 10000원 조건 걸을 필요없음 ; 위에서 이미 작동 중;
            System.out.println("버스를 타십시오.");
        }
        else{
            System.out.println("걸어가십시오.");
        }

         */

        // if문이 독립적으로 지정되어 있으면, 범위지정을 해줘야하며, 그렇지 않을 경우 중복됨
        /*if(money >= 10000){
            System.out.println("택시를 이용하세요.");
        }
        // if문이 각각 독립적으로 실행됨
        if(10000 > money && money >= 3000){
            System.out.println("걸어가십시오.");
        }
        if (money < 3000){
            System.out.println("걸어가십시오."); // 모든 조건식을 줄줄이 명확히 지정해야함
        }

         */


        // 삼항연산자 : 결과값 = 조건식 ? 반환값1 : 반환값2
        // 조건식이 참인 경우 반환값 1이 결과값에 담기고, 거짓인 경우 반환값2가 결과값에 담김
        /*
        String answer = "1234";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String result = (input.length() != 4) ?
                "❌ 비밀번호는 4자리여야 합니다." :
                (input.equals(answer) ?
                        "✅ 문이 열렸습니다." :
                        "❌ 비밀번호가 틀렸습니다.");

        System.out.println(result);

         */

        // 스위치문 : if, else if, else if 등 여러조건식이 있을 때 조건문을 가독성있게 표현한 구문
        // 원하시는 서비스 번호를 입력해주세요.
        // 1. 대출 관련, 2. 예금 관련, 3. 적금 관련, 0. 상담사 연결, 그외는 잘못된 입력

        /*
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input == 1){
            System.out.println("대출 관련입니다.");
        }
        else if (input == 2){
            System.out.println("예금 관련입니다.");
        }
        else if (input == 3){
            System.out.println("적금 관련입니다.");
        }
        else if (input == 0){
            System.out.println("상담사 연결 중입니다.");
        }
        else {
            System.out.println("잘못된 입력입니다.");
        }

         */

        // == 관계로 여러개 있을 때 switch 문 사용 적절
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input){
            case 1: // input == 1
                System.out.println("대출 관련입니다.");
                break;
            case 2: // input == 2
                System.out.println("예금 관련입니다.");
                break;
            case 3: // input == 3
                System.out.println("적금 관련입니다.");
                break;
            case 0: // input == 0
                System.out.println("상담사 연결 중입니다.");
                break;
            default: // else
                System.out.println("잘못된 연결입니다.");
                break;
        }
    }
}
