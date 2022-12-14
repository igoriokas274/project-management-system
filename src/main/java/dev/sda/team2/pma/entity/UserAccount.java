package dev.sda.team2.pma.entity;

import dev.sda.team2.pma.auditing.Auditable;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_accounts")
@EntityListeners(AuditingEntityListener.class)
public class UserAccount extends Auditable {

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
    private boolean enabled = true;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employeeId")
    private Employee employee;

}
