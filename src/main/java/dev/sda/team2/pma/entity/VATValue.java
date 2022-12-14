package dev.sda.team2.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sda.team2.pma.auditing.Auditable;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vat_value")
@EntityListeners(AuditingEntityListener.class)
public class VATValue extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vatId", nullable = false, unique = true)
    private Long vatId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "vatValue", nullable = false)
    @Digits(integer=3, fraction=2)
    private BigDecimal vatValue;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vatValue", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Item> items;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vatValue", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ItemToQuotation> itemToQuotations;

}
