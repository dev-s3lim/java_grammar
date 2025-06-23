package C04Interface.BankService;

public class BankAccount { /// 엔티티 (상태관리) 클래스 - 계좌의 실체(객체) - 어떤 싱크가 맞는 요소들 - 각 변수들의 상태를 바꿔주는 곳
    private String accountNumber;
    private Long balance = 0L; /// 입출금 변수에 손을 대야하는데, private이라 setter 필요함

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    /// 최종 확정 금액을 통해 update치겠다 (연산 안함; 입출금에서 활용)
    public void updateBalance(long balance){
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}

/// 1. Controller (사용자 인터페이스)
/// 2. Service (핵심로직 처리)계층 도입
/// 3. Entitiy 상태관리