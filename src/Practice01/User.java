package Practice01;

public class User {
    private static Long staticId = 1L;
    private Long id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.id = staticId++;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Long getStaticId() {
        return staticId;
    }

    public Long getId() {
        return id;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
