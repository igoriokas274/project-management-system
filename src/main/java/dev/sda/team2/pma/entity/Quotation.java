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
@Table(name = "quotation")
@EntityListeners(AuditingEntityListener.class)
public class Quotation extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quotationId", nullable = false, unique = true)
    private Long quotationId;

    @Column(name = "quotationTitle")
    private String quotationTitle;

    @Column(name = "confirmed", nullable = false, columnDefinition = "int default 0")
    private boolean isConfirmed;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "projectId")
    private Project project;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "quotationStatusId")
    private QuotationStatus quotationStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quotation", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ItemToQuotation> itemToQuotations;

}
