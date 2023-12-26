package entity;

public class User {
    public static int nbUser=0;
    private int id;
    private String email;
    private String password;
    private String password_hashed ;
    private Role role;

    public User(int id, String email, String password, String password_hashedn,Role role) {
        this.email = email;
        this.password = password;
        this.password_hashed = password_hashed;
        this.id=id;
        this.role=role;
    }

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_hashed() {
        return password_hashed;
    }

    public void setPassword_hashed(String passsword_hashed) {
        this.password_hashed = passsword_hashed;
    }
}
