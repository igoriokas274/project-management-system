package dev.sda.team2.pma.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "CURRENCIES")
public class Currencies {

    @Id
    @Column(name = "currencyId", nullable = false, unique = true, length = 2)
    private String currencyId;

    @OneToMany(mappedBy = "currencies")
    private Set<Suppliers> suppliers;

    @OneToMany(mappedBy = "currencies")
    private Set<Customers> customers;

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

    public Currencies() {}

    public Currencies(String currencyId, Date lastUpdatedDate,
                      String lastUpdatedBy, Date createdDate, String createdBy, boolean isClosed) {
        this.currencyId = currencyId;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Set<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
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

    @Override
    public String toString() {
        return "Currencies{" +
                "currencyId='" + currencyId + '\'' +
                ", suppliers=" + suppliers +
                ", customers=" + customers +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}