package bc.auth.domain.model;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String userType;

    public User(Long id, String name, String email, String password, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public static User newUser(String name, String email, String password, String userType) {
        return new User(null, name, email, password, userType);
    }

    public void update(String name, String userType) {
        this.name = name;
        this.userType = userType;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getUserType() { return userType; }
}
