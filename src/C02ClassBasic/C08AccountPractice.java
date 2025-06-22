package C02ClassBasic;

import java.math.BigInteger;
import java.util.*;

public class C08AccountPractice {
    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();

        Account a = new Account();
        a.myAccount("Sung Hoo Lim", "123456-00-123456", 999999999);

        Account b = new Account();
        b.myAccount("Gil Dong Hong", "999000-00-777777", 500);

        list.add(a);
        list.add(b);

        /// 목록조회

        for (Account answer : list){
            System.out.println(answer.myInfo());
        }

        /// 사용자1이 사용자2에게 송금
        /// 입력먼저 받고, 누가, 얼마 보낼건지
        for (Account transfer : list){
            if (transfer.getAccountNum().equals("12345-00-12345")){
                transfer.setBalance(transfer.getBalance() - 50000);
            }
        }

        /// 계좌와 잔고 조회
        for (Account select : list){
            System.out.println("계좌번호 : " + a.getAccountNum() + a.getBalance());
        }

        /// Map을 자료구조로 사용
        Map<String, Account> accountMap = new HashMap<>();
        //accountMap.put("123456-00-123456", new Account("Soon Shin Yi", "12345", 1000000));
        //accountMap.put("999000-00-777777", new Account("Soon Shin Yi", "12345", 1000000));

        Account aData = accountMap.get("12345");
        Account bData = accountMap.get("12345");
        a.setBalance(a.getBalance() - 50000);
        b.setBalance(b.getBalance() + 50000);

        /// 계좌조회
        for (String ac : accountMap.keySet()){
            System.out.println(accountMap.get(ac).getAccountNum());
        }

        /// 계좌조회 2
        for (Account ac : accountMap.values()){
            System.out.println(accountMap.get(ac).getAccountNum());
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

        public void setBalance(long balance) {
            this.balance = balance;
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
