package dev.sda.team2.pma.entity;

import dev.sda.team2.pma.auditing.Auditable;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pay_term")
@EntityListeners(AuditingEntityListener.class)
public class PayTerm extends Auditable {

    @Id
    @Column(name = "term", nullable = false, unique = true)
    private Long term;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payTerm", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Project> projects;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "payTerm", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Supplier> suppliers;

}
