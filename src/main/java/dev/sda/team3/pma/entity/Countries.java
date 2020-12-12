package dev.sda.team3.pma.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "COUNTRIES")
public class Countries {

    @Id
    @Column(name = "countryId", nullable = false, unique = true, length = 3)
    private String countryId;

    @OneToMany(mappedBy = "countries")
    private Set<Contacts> contacts;

    @OneToMany(mappedBy = "countries")
    private Set<Customers> customers;

    @OneToMany(mappedBy = "countries")
    private Set<Suppliers> suppliers;

    @OneToMany(mappedBy = "countries")
    private Set<StockTypes> stockTypes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastUpdatedDate", nullable = false)
    private Date lastUpdatedDate;

    @Column(name = "lastUpdatedBy", nullable = false)
    private String lastUpdatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate",nullable = false, updatable = false)
    private Date createdDate;

    @Column(name = "createdBy", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "closed", nullable = false, columnDefinition = "boolean default false")
    private boolean isClosed;

    public Countries() {}

    public Countries(String countryId, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate,
                     String createdBy, boolean isClosed) {
        this.countryId = countryId;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Set<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contacts> contacts) {
        this.contacts = contacts;
    }

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
    }

    public Set<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<StockTypes> getStockTypes() {
        return stockTypes;
    }

    public void setStockTypes(Set<StockTypes> stockTypes) {
        this.stockTypes = stockTypes;
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
        return "Countries{" +
                "countryId='" + countryId + '\'' +
                ", contacts=" + contacts +
                ", customers=" + customers +
                ", suppliers=" + suppliers +
                ", stockTypes=" + stockTypes +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}
