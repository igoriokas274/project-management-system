package managerprodb.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SUPPLIERS")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierId", nullable = false, unique = true)
    private Long supplierId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplierId")
    List<Contacts> contacts = new ArrayList<>();

    @Column(name = "supplierName", nullable = false)
    private String supplierName;

    @Column(name = "supplierRegistrationNumber", nullable = false)
    private String supplierRegistrationNumber;

    @Column(name = "supplierVATNumber", nullable = false)
    private String supplierVATNumber;

    @Embedded
    private Address address = new Address();

    @Column(name = "supplierPhone")
    private String contactPhone;

    @Column(name = "supplierEmail")
    private String contactEmail;

    @Column(name = "SWIFT")
    private String swift;

    @Column(name = "bankCode", nullable = false)
    private String bankCode;

    @Column(name = "bankName", nullable = false)
    private String bankName;

    @Column(name = "bankAccount", nullable = false)
    private String bankAccount;

    @Embedded
    private PayTerms payTerms = new PayTerms();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "currencyId")
    List<Contacts> currencyId = new ArrayList<>();

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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierRegistrationNumber() {
        return supplierRegistrationNumber;
    }

    public void setSupplierRegistrationNumber(String supplierRegistrationNumber) {
        this.supplierRegistrationNumber = supplierRegistrationNumber;
    }

    public String getSupplierVATNumber() {
        return supplierVATNumber;
    }

    public void setSupplierVATNumber(String supplierVATNumber) {
        this.supplierVATNumber = supplierVATNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public PayTerms getPayTerms() {
        return payTerms;
    }

    public void setPayTerms(PayTerms payTerms) {
        this.payTerms = payTerms;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Contacts> getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(List<Contacts> currencyId) {
        this.currencyId = currencyId;
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

}
