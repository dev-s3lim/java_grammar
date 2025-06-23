package C04Interface.BankService;

import C04Interface.C01AnimalInterface1;
import C04Interface.C01Dog;

import java.util.Scanner;

public class BankController {
    /// 사용자 인터페이스 클래스
    public static void main(String[] args) {
        System.out.println("계좌번호 입력 : ");

        Scanner sc = new Scanner(System.in);
        String accountNumber = sc.nextLine();
        BankAccount ba = new BankAccount(accountNumber);
        BankService bs;

        while (true) {
            System.out.println("입금은 1번, 출금은 2번을 눌러주세요.");
            String serviceNumber = sc.nextLine();

            if (serviceNumber.equals("1")) {
                System.out.println("입금 방식 선택 : 1 - 카카오, 2 - 토스");
                String methodNumber = sc.nextLine();
                if (methodNumber.equals("1")) {
                    bs = new BankKakao();
                } else if (methodNumber.equals("2")) {
                    bs = new BankToss();
                } else {
                    continue;
                }
                System.out.println("입금하실 금액 입력 : ");
                long money = Long.parseLong(sc.nextLine());
                bs.deposit(money, ba);

                /// 서비스 계층이 있다면, money와 bank account 던져주면서 잔액 확인
                bs.deposit(money, ba);

                System.out.println("입금이 완료되었습니다.");
            } else {
                System.out.println("출금하실 금액 입력 : ");
                System.out.println("출금 방식 선택 : 1 - 카카오, 2 - 토스");
                String methodNumber = sc.nextLine();
                if (methodNumber.equals("1")) {
                    bs = new BankKakao();
                } else if (methodNumber.equals("2")) {
                    bs = new BankToss();
                } else {
                    continue;
                }
                System.out.println("입금하실 금액 입력 : ");
                long money = Long.parseLong(sc.nextLine());
                bs.deposit(money, ba);
            }
            long money = Long.parseLong(sc.nextLine());

            if (bs.withdraw(money, ba)) {
                System.out.println("출금 완료");
            } else {
                System.out.println("잔액 부족");
            }
        }
    }
}
