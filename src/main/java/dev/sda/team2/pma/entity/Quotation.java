package dev.sda.team2.pma.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "quotation")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quotationId", nullable = false, unique = true)
    private Long quotationId;

    @Column(name = "quotationTitle")
    private String quotationTitle;

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

    @Column(name = "confirmed", nullable = false, columnDefinition = "int default 0")
    private boolean isConfirmed;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "projectId")
    private Project project;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "quotationStatusId")
    private QuotationStatus quotationStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quotation", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ItemToQuotation> itemToQuotations;

    public Quotation() {
    }

    public Quotation(String quotationTitle, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate,
                     String createdBy, boolean isConfirmed, Project project, QuotationStatus quotationStatus,
                     List<ItemToQuotation> itemToQuotations) {
        this.quotationTitle = quotationTitle;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isConfirmed = isConfirmed;
        this.project = project;
        this.quotationStatus = quotationStatus;
        this.itemToQuotations = itemToQuotations;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    public String getQuotationTitle() {
        return quotationTitle;
    }

    public void setQuotationTitle(String quotationTitle) {
        this.quotationTitle = quotationTitle;
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

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public QuotationStatus getQuotationStatus() {
        return quotationStatus;
    }

    public void setQuotationStatus(QuotationStatus quotationStatus) {
        this.quotationStatus = quotationStatus;
    }

    public List<ItemToQuotation> getItemToQuotations() {
        return itemToQuotations;
    }

    public void setItemToQuotations(List<ItemToQuotation> itemToQuotations) {
        this.itemToQuotations = itemToQuotations;
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "quotationId=" + quotationId +
                ", quotationTitle='" + quotationTitle + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isConfirmed=" + isConfirmed +
                ", project=" + project +
                ", quotationStatus=" + quotationStatus +
                ", itemToQuotations=" + itemToQuotations +
                '}';
    }
}
