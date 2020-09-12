package managerpro.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CONTACTS")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactId")
    private Long contactId;

    @Column(name = "fullName")
    private String contactFullName;

    @Column(name = "title")
    private String title;

    @Column(name = "department")
    private String contactDepartment;

    @Column(name = "address")
    private String contactAddress;

    @Column(name = "city")
    private String contactCity;

    @Column(name = "countryId")
    private Long countryId;

    @Column(name = "contactPhone")
    private String contactPhone;

    @Column(name = "contactEmail")
    private String contactEmail;

    @Column(name = "gender")
    private Character contactGender;

    @Column(name = "birthdate")
    private Date contactBirthdate;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "supplierId")
    private Long supplierId;

    @Column(name = "lastUpdatedDate")
    private Date lastUpdatedDate;

    @Column(name = "lastUpdatedBy")
    private String lastUpdatedBy;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "closed")
    private Boolean isClosed;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactFullName() {
        return contactFullName;
    }

    public void setContactFullName(String contactFullName) {
        this.contactFullName = contactFullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContactDepartment() {
        return contactDepartment;
    }

    public void setContactDepartment(String contactDepartment) {
        this.contactDepartment = contactDepartment;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = contactCity;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Character getContactGender() {
        return contactGender;
    }

    public void setContactGender(Character contactGender) {
        this.contactGender = contactGender;
    }

    public Date getContactBirthdate() {
        return contactBirthdate;
    }

    public void setContactBirthdate(Date contactBirthdate) {
        this.contactBirthdate = contactBirthdate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }
}
