package Practice01;

public class User {
    private static long staticId = 1L;

    private Long id;
    private String name;
    private String password;
    private String email;

    public User(String name, String password, String email) {
        this.id = staticId++;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public static long getStaticId() {
        return staticId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
