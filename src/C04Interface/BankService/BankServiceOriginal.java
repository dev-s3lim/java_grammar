package C04Interface.BankService;

public class BankServiceOriginal { /// 서비스 기능 클래스 (엔티티에서 넘겨받는 곳)
    public void deposit(long money, BankAccount ba){ /// 1번 입금
        /// 현재 얼마있는지 조회
        ///  그 금액과 money와 합산하여 updateBalance

        long current = ba.getBalance();
        long newBalance = current + money;
        ba.updateBalance(newBalance);
    }

    public boolean withdraw (long money, BankAccount ba){ /// 2번 출금
        /// 현재 얼마있는지 조회 && 출금 금액과 비교
        ///  그 금액과 money와 차감하여 updateBalance

        long current = ba.getBalance();
        if (current < money){
            return false;
        }
        else {
            long newBalance = current - money;
            ba.updateBalance(newBalance);
            return true;
        }
    }
}
