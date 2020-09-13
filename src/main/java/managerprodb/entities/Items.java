package managerprodb.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    //TODO add average purchase price

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private Set<VATValues> vatValues = new HashSet<>();

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


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public StockTypes getStockTypes() {
        return stockTypes;
    }

    public void setStockTypes(StockTypes stockTypes) {
        this.stockTypes = stockTypes;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public Integer getMinStockLevel() {
        return minStockLevel;
    }

    public void setMinStockLevel(Integer minStockLevel) {
        this.minStockLevel = minStockLevel;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Set<VATValues> getVatValues() {
        return vatValues;
    }

    public void setVatValues(Set<VATValues> vatValues) {
        this.vatValues = vatValues;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
