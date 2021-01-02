package dev.sda.team2.pma.entity;

import dev.sda.team2.pma.auditing.Auditable;
import dev.sda.team2.pma.enums.ItemType;
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
@Table(name = "item")
@EntityListeners(AuditingEntityListener.class)
public class Item extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId", nullable = false, unique = true)
    private Long itemId;

    @Column(name = "itemName", nullable = false)
    private String itemName;

    @Column(name = "itemDescription", columnDefinition="TEXT")
    private String itemDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "itemType", length = 20)
    private ItemType itemType;

    @Column(name = "minStockLevel")
    private Integer minStockLevel;

    @Column(name = "salesPrice", precision = 10, scale = 2)
    private BigDecimal salesPrice;

    @Column(name = "closed", nullable = false, columnDefinition = "int default 0")
    private boolean isClosed;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "stockId")
    private StockType stockType;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "vatId")
    private VATValue vatValue;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ItemToQuotation> itemToQuotations;

}
