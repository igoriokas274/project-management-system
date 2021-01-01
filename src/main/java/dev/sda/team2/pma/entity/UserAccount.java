package dev.sda.team2.pma.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(strategy = GenerationType.SEQUENCE, generator = "user_accounts_seq")
    @Column(name = "userId", nullable = false)
    private long userId;

    @NotBlank
    @Column(name = "username", nullable = false, unique=true)
    private String userName;

    @NotBlank
    @Size(min = 8)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "enabled", nullable = false, columnDefinition = "int default 1")
    private boolean enabled;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employeeId")
    private Employee employee;

    public UserAccount() {
    }

    public UserAccount(String userName, String password, String role, boolean enabled, Employee employee) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.employee = employee;
    }

    public UserAccount(long userId, String userName, String password, String role, boolean enabled, Employee employee) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.employee = employee;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                ", employee=" + employee +
                '}';
    }
}
