package dev.sda.team3.pma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "VAT_VALUES")
public class VATValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vatId", nullable = false, unique = true)
    private Long vatId;

    @Column(name = "description")
    private String description;

    @Column(name = "vatValue", nullable = false, precision = 3, scale = 2)
    private BigDecimal vatValue;

    @OneToMany(mappedBy = "vatValues")
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

    public VATValues() {}

    public VATValues(String description, BigDecimal vatValue, Set<Items> items, Date lastUpdatedDate,
                     String lastUpdatedBy, Date createdDate, String createdBy) {
        this.description = description;
        this.vatValue = vatValue;
        this.items = items;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "VATValues{" +
                "vatId=" + vatId +
                ", description='" + description + '\'' +
                ", vatValue=" + vatValue +
                ", items=" + items +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
