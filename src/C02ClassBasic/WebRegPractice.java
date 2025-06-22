package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WebRegPractice {
    public static void main(String[] args) throws IOException {
        /// 사용자로부터 회원 정보를 입력받아 Member 객체를 생성하고,
        /// 이를 List<Member>에 저장한 뒤, 전체 회원 정보를 출력하는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Members> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            String id = input[0];
            String pw = input[1];
            String name = input[2];
            String email = input[3];
            String mobile = input[4];
            String dob = input[5];
            String accType = input[6];
            boolean isPremium = false;

            if (accType.equals("프리미엄")){
                isPremium = true;
            }
            else if (accType.equals("일반")){
                isPremium = false;
            }

            Members m = new Members(id, pw, name, email, mobile, dob, isPremium);
            list.add(m);
        }

        for (Members answer : list){
            System.out.println(answer.toString());
        }

    }

    public static class Members{
        private String id;
        private String pw;
        private String name;
        private String email;
        private String mobile;
        private String dob;
        private boolean isPremium;

        public String getId() {
            return id;
        }

        public String getPw() {
            return pw;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getMobile() {
            return mobile;
        }

        public String getDob() {
            return dob;
        }

        public boolean isPremium() {
            return isPremium;
        }

        public Members (String id, String pw, String name, String email, String mobile, String dob, boolean isPremium){
            this.id = id;
            this.pw = pw;
            this.name = name;
            this.email = email;
            this.mobile = mobile;
            this.dob = dob;
            this.isPremium = isPremium;
        }

        @Override
        public String toString (){
            String result = "아이디 : " + this.id + "\n" +
                            "성명 : " + this.name + "\n" +
                            "비밀번호 : " + this.pw + "\n" +
                            "이메일 : " + this.email + "\n" +
                            "휴대폰번호 : " + this.mobile + "\n" +
                            "생년월일 : " + this.dob + "\n";

            if (isPremium) {
                result += "프리미엄 유저입니다.\n";
            } else {
                result += "일반 유저입니다.\n";
            }

            return result;
        }
    }
}
