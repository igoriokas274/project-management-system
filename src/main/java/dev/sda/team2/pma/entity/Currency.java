package dev.sda.team2.pma.entity;

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
@Table(name = "currency")
@EntityListeners(AuditingEntityListener.class)
public class Currency extends Auditable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "currencyId", nullable = false)
    private Long currencyId;

    @Column(name = "currencyCode", nullable = false, unique = true, length =3)
    private String currencyCode;

    @Column(name = "currencyName", nullable = false)
    private String currencyName;

    @Column(name = "closed", nullable = false, columnDefinition = "int default 0")
    private boolean isClosed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "currency", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Customer> customers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "currency", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Supplier> suppliers;

}
