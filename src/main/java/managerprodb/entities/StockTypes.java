package managerprodb.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "STOCK_TYPES")
public class StockTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stockId", nullable = false, unique = true)
    private Long stockId;

    @Column(name = "stockName", nullable = false)
    private String stockName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "stockTypes")
    private Set<Items> items;

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

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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


    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }
}
