package dev.sda.team2.pma.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vat_value")
public class VATValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vatId", nullable = false, unique = true)
    private Long vatId;

    @Column(name = "description")
    private String description;

    @Column(name = "vatValue", nullable = false, precision = 3, scale = 2)
    private BigDecimal vatValue;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vatValue", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Item> items;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vatValue", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ItemToQuotation> itemToQuotations;

    public VATValue() {
    }

    public VATValue(String description, BigDecimal vatValue, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate,
                    String createdBy, List<Item> items, List<ItemToQuotation> itemToQuotations) {
        this.description = description;
        this.vatValue = vatValue;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.items = items;
        this.itemToQuotations = itemToQuotations;
    }

    public Long getVatId() {
        return vatId;
    }

    public void setVatId(Long vatId) {
        this.vatId = vatId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getVatValue() {
        return vatValue;
    }

    public void setVatValue(BigDecimal vatValue) {
        this.vatValue = vatValue;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<ItemToQuotation> getItemToQuotations() {
        return itemToQuotations;
    }

    public void setItemToQuotations(List<ItemToQuotation> itemToQuotations) {
        this.itemToQuotations = itemToQuotations;
    }

    @Override
    public String toString() {
        return "VATValue{" +
                "vatId=" + vatId +
                ", description='" + description + '\'' +
                ", vatValue=" + vatValue +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", items=" + items +
                ", itemToQuotations=" + itemToQuotations +
                '}';
    }
}
