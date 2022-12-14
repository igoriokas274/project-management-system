package dev.sda.team2.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sda.team2.pma.auditing.Auditable;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
@EntityListeners(AuditingEntityListener.class)
public class Country extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryId", nullable = false)
    private Long countryId;

    @Column(name = "countryCode", nullable = false, unique = true, length = 2) // ISO 3166 ALPHA-2 code format
    private String countryCode;

    @Column(name = "countryName", nullable = false)
    private String countryName;

    @Column(name = "closed", nullable = false, columnDefinition = "int default 0")
    private boolean isClosed;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Customer> customers;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "country", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Supplier> suppliers;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "country", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<StockType> stockTypes;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Employee> employees;
}
