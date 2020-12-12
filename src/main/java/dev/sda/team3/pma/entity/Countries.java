package dev.sda.team3.pma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
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

    public Countries(String countryId, Set<Contacts> contacts, Set<Customers> customers, Set<Suppliers> suppliers,
                     Set<StockTypes> stockTypes, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate,
                     String createdBy, boolean isClosed) {
        this.countryId = countryId;
        this.contacts = contacts;
        this.customers = customers;
        this.suppliers = suppliers;
        this.stockTypes = stockTypes;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
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
