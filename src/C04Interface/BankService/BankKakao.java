package C04Interface.BankService;

public class BankKakao implements BankService{
    @Override
    public void deposit(long money, BankAccount ba) {

    }

    @Override
    public boolean withdraw(long money, BankAccount ba) {
        return false;
    }
}
