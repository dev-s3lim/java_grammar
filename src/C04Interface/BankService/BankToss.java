package C04Interface.BankService;

public class BankToss implements BankService {
    @Override
    public void deposit(long money, BankAccount ba) {

    }

    @Override
    public boolean withdraw(long money, BankAccount ba) {
        return false;
    }
}
