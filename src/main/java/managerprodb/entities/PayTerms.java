package managerprodb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PAY_TERMS")
public class PayTerms {

    @Id
    @Column(name = "term", nullable = false, unique = true, precision = 3, scale = 2)
    private BigDecimal term;

    @OneToMany(mappedBy = "payTerms")
    private Set<Customers> customers;

    @OneToMany(mappedBy = "payTerms")
    private Set<Suppliers> suppliers;

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

    public PayTerms() {}

    public PayTerms(BigDecimal term, Set<Customers> customers, Set<Suppliers> suppliers, Date lastUpdatedDate,
                    String lastUpdatedBy, Date createdDate, String createdBy) {
        this.term = term;
        this.customers = customers;
        this.suppliers = suppliers;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "PayTerms{" +
                "term=" + term +
                ", customers=" + customers +
                ", suppliers=" + suppliers +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
