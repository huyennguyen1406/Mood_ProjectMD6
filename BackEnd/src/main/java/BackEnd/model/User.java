package BackEnd.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Not blank!")
    private String name;
    @NotNull(message = "Not blank!")
    private String address;
    @NotNull(message = "Not blank!")
    private String phone;
    private String avatarURL;
    @NotNull(message = "Not blank!")
    private String username;
    @NotNull(message = "Not blank!")
    private String password;
    @NotNull(message = "Please enter your email!")
    @Email(message = "Email not valid!")
    private String email;
    private Boolean statusActive = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String name, String address, String phone, String avatarURL, String username, String email, String password, Set<Role> roles) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.avatarURL = avatarURL;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.password = password;

    }

    public User(String name, String address, String phone, String email, String username, String password) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(Boolean statusActive) {
        this.statusActive = statusActive;
    }
}
