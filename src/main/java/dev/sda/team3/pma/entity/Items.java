package dev.sda.team3.pma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "ITEMS")
public class Items {

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

    @ManyToOne
    @JoinColumn(name = "stockId")
    private StockTypes stockTypes;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Suppliers suppliers;

    @Column(name = "minStockLevel")
    private Integer minStockLevel;

    @Column(name = "salesPrice", precision = 10, scale = 2)
    private BigDecimal salesPrice;

    @ManyToOne
    @JoinColumn(name = "vatId")
    private VATValues vatValues;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastUpdatedDate", nullable = false)
    private Date lastUpdatedDate;

    @Column(name = "lastUpdatedBy", nullable = false)
    private String lastUpdatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate",nullable = false, updatable = false)
    private Date createdDate;

    @Column(name = "createdBy",nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "closed", nullable = false, columnDefinition = "boolean default false")
    private boolean isClosed;

    public Items() {}

    public Items(String itemName, String itemDescription, ItemType itemType, StockTypes stockTypes, Suppliers suppliers,
                 Integer minStockLevel, BigDecimal salesPrice, VATValues vatValues, Date lastUpdatedDate,
                 String lastUpdatedBy, Date createdDate, String createdBy, boolean isClosed) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.stockTypes = stockTypes;
        this.suppliers = suppliers;
        this.minStockLevel = minStockLevel;
        this.salesPrice = salesPrice;
        this.vatValues = vatValues;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemType=" + itemType +
                ", stockTypes=" + stockTypes +
                ", suppliers=" + suppliers +
                ", minStockLevel=" + minStockLevel +
                ", salesPrice=" + salesPrice +
                ", vatValues=" + vatValues +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}
