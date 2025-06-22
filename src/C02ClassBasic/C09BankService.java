package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C09BankService {
//        계좌개설 및 입출금 서비스 : id(auto_increment), name(String), accountNumber(String), balance(long).
//        주의사항1 : main메서드에서 입출력 처리를 하고, deposit, withdraw, transfer 메서드는 BankAccount클래스에 생성.
//        주의사항2 : 프로그램은 항상 실행될수 있도록 전체코드를 while(true)처리
//        서비스번호를 입력하세요. 1.개설 2.조회 3.입금 4.출금 5.송금

//        1.계좌개설 : 계좌번호와 현재가지고 계신 돈을 입력하세요. -> 자동으로 id값 증가되어 세팅
//        2.계좌조회 : 계좌조회서비스입니다. 계좌번호를 입력해주세요. -> 잔고출력
//        3.입금 : 계좌입금서비스입니다. 계좌번호와 입금금액을 입력해주세요. -> 현재 계좌에 얼마 (잔액)가 있습니다. 출력.
//        4.출금 : 계좌출금서비스입니다. 계좌번호와 출금금액을 입력해주세요.(*잔액검증*) -> 남은 금액은 얼마입니다. 출력. 또는 "잔액부족" 메시지 pop
//        5.송금 : 송금서비스입니다. 본인의 계좌번호를 입력해주세요. 보내고자 하는 상대방의 계좌번호를 입력해주세요. 송금금액을 입력해주세요.(잔액검증)
//                또는 "잔액이 부족합니다" pop.

    // BankAccount 객체를 담아둘 자료구조 선언 필요

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<BankAccount> bankAccountList = new ArrayList<>();

        while(true){
            System.out.println("OO은행입니다. 이용하실 서비스 번호를 입력해주세요.");
            System.out.println("1. 계좌개설");
            System.out.println("2. 계좌조회");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 송금");

            String serviceType = br.readLine();
            if(serviceType.equals("1")){
                System.out.println("고객님의 성함, 계좌번호, 그리고 현재 보유한 금액을 입력하세요 : ");

                String[] regInfo = br.readLine().split(" ");

                String name = regInfo[0];
                String acccountNumber = regInfo[1];
                String money = regInfo[2];

                BankAccount creationProcess = new BankAccount();
                creationProcess.registration(name, acccountNumber, Long.parseLong(money));
                bankAccountList.add(creationProcess);

                System.out.println("\n" + "***********************************************");
                System.out.println(creationProcess.getName() +"님, 개설을 축하드립니다! ");
                System.out.println("계좌번호는 " + creationProcess.getAccountNumber() + " 입니다.");
                System.out.println("현재 보유 금액은 " + creationProcess.getMoney() + "원 입니다.");
                System.out.println("***********************************************" + "\n");

            }
            else if(serviceType.equals("2")){
                System.out.println("계좌조회 서비스입니다. 계좌번호를 입력해주세요 : ");
                String accNumInput = br.readLine();

                for (BankAccount check : bankAccountList){
                    if (accNumInput.equals(check.getAccountNumber())){
                        System.out.println("\n" + "***********************************************");
                        System.out.println(check.getName() + "님의 현재 잔액은 " + check.getMoney() + "원 입니다.");
                        System.out.println("***********************************************" + "\n");
                    }
                }
            }
            else if(serviceType.equals("3")){
                System.out.println("계좌입금 서비스입니다. 계좌번호와 입금하실 금액을 입력해주세요 : ");

                String[] depositInput = br.readLine().split(" ");
                String accountNumber = depositInput[0];
                long depositAmount = Long.parseLong(depositInput[1]);

                for (BankAccount check : bankAccountList){
                    if (accountNumber.equals(check.getAccountNumber())){
                        check.deposit(depositAmount);
                        System.out.println("\n" + "***********************************************");
                        System.out.println(check.getName() + "님 입금이 성공적으로 완료되었습니다.");
                        System.out.println("현재 " + check.getName() +"님의 잔고는 : " + check.getMoney() + "원 입니다.");
                        System.out.println("***********************************************" + "\n");
                    }
                }
            }
            else if(serviceType.equals("4")){
                System.out.println("계좌출금 서비스입니다. 계좌번호와 출금하실 금액을 입력해주세요 : ");

                String[] wdInput = br.readLine().split(" ");
                String accountNumber = wdInput[0];
                long wdAmount = Long.parseLong(wdInput[1]);
                boolean accExist = false;

                for (BankAccount w : bankAccountList){
                    if (accountNumber.equals(w.getAccountNumber())){
                        accExist = true;
                        if (w.withdraw(wdAmount)){
                            System.out.println("\n" + "***********************************************");
                            System.out.println(w.getName() + "님, " + wdAmount + "원이 성공적으로 출금되었습니다.");
                            System.out.println("현재 잔액은 " + w.getMoney() + "원 입니다.");
                            System.out.println("***********************************************" + "\n");
                        }
                        else {
                            System.out.println("\n" + "***********************************************");
                            System.out.println(w.getName() + "님, 잔액이 부족합니다.");
                            System.out.println("***********************************************" + "\n");
                        }
                    }
                }
            }
            else if(serviceType.equals("5")){
                System.out.println("송금 서비스입니다.");
                System.out.println("본인의 계좌번호, 송금 받을 상대 계좌번호, 송금하실 금액을 입력하세요:");

                String[] transferInput = br.readLine().split(" ");
                String from = transferInput[0];
                String target = transferInput[1];
                long transferAmount = Long.parseLong(transferInput[2]);

                BankAccount sender = null;
                BankAccount receiver = null;

                for (BankAccount t : bankAccountList) {
                    if (t.getAccountNumber().equals(from)) {
                        sender = t;
                    }
                    if (t.getAccountNumber().equals(target)) {
                        receiver = t;
                    }
                }

                if (sender.getMoney() >= transferAmount){
                    sender.transfer(receiver, transferAmount);
                    System.out.println("\n***********************************************");
                    System.out.println(sender.getName() + "님이 " + receiver.getName() + "님에게 " + transferAmount + "원을 송금했습니다.");
                    System.out.println("송금 후 내 잔액: " + sender.getMoney() + "원 입니다.");
                    System.out.println("***********************************************\n");
                }
                else{
                    System.out.println("\n***********************************************");
                    System.out.println(sender.getName() + "님, 잔액이 부족합니다.");
                    System.out.println("***********************************************\n");
                }
                }
            }
    }
}

class BankAccount {
    private int id;
    private String name;
    private String accountNumber;
    private long money;

    static int nextId = 1;

    /// getter 생성
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getMoney() {
        return money;
    }

    /// setter (명확하게 목적별로 명칭 설정)
    public void selectId(int id) {
        this.id = id;
    }

    public void selectName(String name) {
        this.name = name;
    }

    public void searchAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void depositBalance(long money) {
        this.money = money;
    }

    /// 기능
    /// 1. 계좌 개설
    public void registration(String name, String accountNumber, long money) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.money = money;
        this.id = nextId++;
    }

    /// 2. 입금
    public void deposit(long depositAmount) {
        this.money += depositAmount;
    }

    /// 3. 출금
    public boolean withdraw(long withdrawalAmount) {
        // 잔고가 있으면 차감 후 true 리턴
        if (money >= withdrawalAmount){
            money -= withdrawalAmount;
            return true;
        }
        else {
            return false;
        }
    }

    /// 4. 송금
    public void transfer(BankAccount targetAccount, long transferAmount) {
        if (money >= transferAmount) {  // 잔액 확인용
            money -= transferAmount;  // 내 계좌 출금 후...
            targetAccount.money += transferAmount; // 상대 계좌에 입금
        }
    }
}