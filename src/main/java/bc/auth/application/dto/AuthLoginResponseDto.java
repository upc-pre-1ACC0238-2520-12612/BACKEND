package bc.auth.application.dto;

public class AuthLoginResponseDto {

    private String token;
    private Long id;
    private String name;
    private String email;
    private String userType;

    public AuthLoginResponseDto() {
    }

    public AuthLoginResponseDto(String token,
                                Long id,
                                String name,
                                String email,
                                String userType) {
        this.token = token;
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
}
