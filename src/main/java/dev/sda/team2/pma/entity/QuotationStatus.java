package dev.sda.team2.pma.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "quotation_status")
public class QuotationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quotationStatusId", nullable = false, unique = true)
    private Long quotationStatusId;

    @Column(name = "quotationStatusName")
    private String quotationStatusName;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quotationStatus", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Quotation> quotations;

    public QuotationStatus() {
    }

    public QuotationStatus(String quotationStatusName, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate,
                           String createdBy, List<Quotation> quotations) {
        this.quotationStatusName = quotationStatusName;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.quotations = quotations;
    }

    public Long getQuotationStatusId() {
        return quotationStatusId;
    }

    public void setQuotationStatusId(Long quotationStatusId) {
        this.quotationStatusId = quotationStatusId;
    }

    public String getQuotationStatusName() {
        return quotationStatusName;
    }

    public void setQuotationStatusName(String quotationStatusName) {
        this.quotationStatusName = quotationStatusName;
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

    public List<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
    }

    @Override
    public String toString() {
        return "QuotationStatus{" +
                "quotationStatusId=" + quotationStatusId +
                ", quotationStatusName='" + quotationStatusName + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", quotations=" + quotations +
                '}';
    }
}
