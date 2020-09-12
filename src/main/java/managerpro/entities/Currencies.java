package managerpro.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CURRENCIES")
public class Currencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currencyId", nullable = false, unique = true)
    private Long currencyId;

    @Column(name = "currencyCode", nullable = false, length = 3)
    private String currencyCode;

    @Column(name = "lastUpdatedDate")
    private Date lastUpdatedDate;

    @Column(name = "lastUpdatedBy")
    private String lastUpdatedBy;

    @Column(name = "createdDate", updatable = false)
    private Date createdDate;

    @Column(name = "createdBy", updatable = false)
    private String createdBy;

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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
}
