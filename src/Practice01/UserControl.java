package Practice01;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserControl {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n이용하실 서비스 번호를 입력하세요.");
            System.out.println("1번 - 회원가입");
            System.out.println("2번 - 회원 상세조회");
            System.out.println("3번 - 회원 전체조회");
            System.out.println("4번 - 로그인");
            System.out.println("0번 - 프로그램 종료");
            System.out.print("선택 : ");

            String input = sc.nextLine();
            if (input.equals("1")){
                System.out.println("\n***회원가입***\n");
                System.out.print("성명 : ");
                String name = sc.nextLine();
                System.out.print("이메일 : ");
                String email = sc.nextLine();
                System.out.print("비밀번호 : ");
                String password = sc.nextLine();

                try {
                    userService.registration(name, email, password);
                    System.out.println("환영합니다! 회원가입이 완료되었습니다.");
                }
                catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }
            else if (input.equals("2")){
                System.out.println("\n***회원 상세조회***\n");
                System.out.println("상세 조회 방식을 선택해주세요.");
                System.out.println("1번 - 회원 ID로 조회");
                System.out.println("2번 - 회원 Email로 조회");
                System.out.print("선택 : ");
                String searchType = sc.nextLine();

                if (searchType.equals("1")){
                    System.out.print("\n조회하실 회원의 ID를 입력하세요 : ");
                    String targetId = sc.nextLine();

                    try {
                        Long id = Long.parseLong(targetId);
                        User user = userService.searchById(id);
                        System.out.println("회원정보 : " + user);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if (searchType.equals("2")){
                    System.out.println("\n조회하실 회원의 Email을 입력하세요 : ");
                    String targetEmail = sc.nextLine();

                    try {
                        String email = targetEmail;
                        User user = userService.searchByEmail(email);
                        System.out.println("회원정보 : " + user);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if (input.equals("3")){
                System.out.println("\n전체 회원정보입니다 : \n");
                List<User> userList = userService.searchAll();

                if (userList.isEmpty()){
                    System.out.println("등록된 회원이 없습니다.");
                }
                else {
                    for (User u : userList) {
                        System.out.println(u);
                    }
                }
            }
            else if (input.equals("4")){
                System.out.println("\n로그인 페이지입니다.\n");
                System.out.print("E-mail : ");
                String loginEmail = sc.nextLine();

                System.out.print("Password : ");
                String loginPw = sc.nextLine();

                try {
                    User loggedInUser = userService.login(loginEmail, loginPw);
                    System.out.println(loggedInUser.getName() + "님" + " 로그인에 성공하였습니다.");
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (input.equals("0")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}

