package dev.sda.team2.pma.entity;

import dev.sda.team2.pma.auditing.Auditable;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId", nullable = false, unique = true)
    private Long customerId;

    @Column(name = "customerName", nullable = false)
    private String customerName;

    @Column(name = "customerRegistrationNumber", nullable = false)
    private String customerRegistrationNumber;

    @Column(name = "customerVATNumber", nullable = false)
    private String customerVATNumber;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "customerPhone")
    private String contactPhone;

    @Column(name = "customerEmail")
    private String contactEmail;

    @Column(name = "SWIFT")
    private String swift;

    @Column(name = "bankCode", nullable = false)
    private String bankCode;

    @Column(name = "bankName", nullable = false)
    private String bankName;

    @Column(name = "bankAccount", nullable = false)
    private String bankAccount;

    @Column(name = "closed", nullable = false, columnDefinition = "int default 0")
    private boolean isClosed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Project> projects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Contact> contacts;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "countryId")
    private Country country;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "currencyId")
    private Currency currency;

}
