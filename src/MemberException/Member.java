package MemberException;

public class Member {
    private static Long staticId = 1L; // 시작값을 1로
    private Long id;
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        this.id = staticId++;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public static Long getStaticId() {
        return staticId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("[회원번호: %d, 이름: %s, 이메일: %s]", id, name, email);
    }
}
