package dev.sda.team3.pma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
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

    public Currencies(String currencyId, Set<Suppliers> suppliers, Set<Customers> customers, Date lastUpdatedDate,
                      String lastUpdatedBy, Date createdDate, String createdBy, boolean isClosed) {
        this.currencyId = currencyId;
        this.suppliers = suppliers;
        this.customers = customers;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
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
