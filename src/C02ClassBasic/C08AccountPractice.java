package C02ClassBasic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C08AccountPractice {
    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();

        Account a = new Account();
        a.myAccount("Sung Hoo Lim", "12345-00-12345", 999999999);

        Account b = new Account();
        b.myAccount("Gil Dong Hong", "12345-00-12345", 500);

        list.add(a);
        list.add(b);

        for (Account answer : list){
            System.out.println(answer.myInfo());
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

        public String myInfo() {
            return "고객명 : " + this.name +"\n"+
            "계좌번호 : " + this.accountNum +"\n"+
            "잔액 : " + this.balance +"\n";
        }
    }
}
