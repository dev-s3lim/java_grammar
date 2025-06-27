package C10Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C02Validation {
    public static void main(String[] args) {
        List<Member> memberList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("성명");
            String name = sc.nextLine();
            System.out.println("이메일");
            String email = sc.nextLine();

            Member member = new Member(name, email);

            try {
                validate(member);  // 👈 유효성 검사 추가
                memberList.add(member);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                System.out.println("❌ 입력 오류: " + e.getMessage());
            }

            System.out.println(memberList);
        }
    }

    /// COMPILE (리플렉션은 기본적으로 런타임에 동작하므로, 어노테이션을 사용시에 RUNTIME 세팅 필요)
    static void validate(Object object) throws IllegalAccessException {
        /// 어떤 값이 들어올지 모르니 RUNTIME
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f : fields){
            if(f.isAnnotationPresent(NotEmpty.class)){
                f.setAccessible(true);
                String value = (String)f.get(object);
                if (value == null || value.isEmpty()){
                    NotEmpty n1 = f.getAnnotation(NotEmpty.class);
                    throw new IllegalArgumentException(n1.message());
                }
            }
        }
    }
}

class Member {
    private String name;

    @NotEmpty
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Member(){
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

/// Annotation은 선언적 표시이고, 어떠한 기능도 수행하지 않음
@Retention(RetentionPolicy.RUNTIME) /// Annotation은 기본적으로 default는 컴파일 타임에 동작 -> 런타임 동작으로 변경
@interface NotEmpty{
    /// Annotation의 속성 정의 방식 (일종의 변수)
    String message () default "this field cannot be empty!";
}