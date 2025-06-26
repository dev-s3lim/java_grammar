package MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MemberController {
    public static void main(String[] args) {
        MemberService service = new MemberService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. 회원가입 | 2. 회원 상세조회 | 3. 회원 목록 | 4. 로그인 | 0. 종료");
            System.out.print("선택 >> ");
            String input = sc.nextLine();

            if (input.equals("1")) {
                System.out.print("이름: ");
                String name = sc.nextLine();
                System.out.print("이메일: ");
                String email = sc.nextLine();
                System.out.print("비밀번호: ");
                String password = sc.nextLine();
                try {
                    service.register(name, email, password);
                    System.out.println("회원가입 완료");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input.equals("2")) {
                System.out.print("조회할 회원 ID: ");
                try {
                    Long id = Long.parseLong(sc.nextLine());
                    Member member = service.findById(id);
                    System.out.println("회원 정보: " + member);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (input.equals("3")) {
                List<Member> members = service.findAll();
                if (members.isEmpty()) {
                    System.out.println("등록된 회원이 없습니다.");
                } else {
                    for (Member m : members) {
                        System.out.println(m);
                    }
                }

            } else if (input.equals("4")) {
                System.out.print("이메일: ");
                String loginEmail = sc.nextLine();
                System.out.print("비밀번호: ");
                String loginPassword = sc.nextLine();
                try {
                    service.login(loginEmail, loginPassword);
                    System.out.println("로그인 성공");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input.equals("0")) {
                System.out.println("프로그램 종료");
                sc.close();
                return;

            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
