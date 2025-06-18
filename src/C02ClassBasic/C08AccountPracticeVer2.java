package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

public class C08AccountPracticeVer2 {
    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();

        Account a = new Account();
        a.myAccount("Sung Hoo Lim", "12345-00-12345", 999999999);
        System.out.println(a.toString());

        Account b = new Account();
        b.myAccount("Gil Dong Hong", "12345-00-12345", 500);
        System.out.println(b.toString());

        list.add(a);
        list.add(b);

        System.out.println("\n" + "toString으로 사용 시..." + "\n");
        for (Account answer : list) {
            System.out.println(answer.toString());
        }
    }

    public static class Account{
        private String name;
        private String accountNum;
        private long balance;

        public String getName() {
            return name;
        }

        public String getAccountNum() {
            return accountNum;
        }

        public long getBalance() {
            return balance;
        }

        public void myAccount (String name, String accountNum, long balance){
            this.name = name;
            this.accountNum = accountNum;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "name='" + name + '\'' +
                    ", accountNum='" + accountNum + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }
}
