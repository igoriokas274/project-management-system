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
@Table(name = "quotation_status")
@EntityListeners(AuditingEntityListener.class)
public class QuotationStatus extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quotationStatusId", nullable = false, unique = true)
    private Long quotationStatusId;

    @Column(name = "quotationStatusName")
    private String quotationStatusName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quotationStatus", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Quotation> quotations;

}
