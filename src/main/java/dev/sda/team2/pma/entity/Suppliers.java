package dev.sda.team2.pma.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "SUPPLIERS")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierId", nullable = false, unique = true)
    private Long supplierId;

    @OneToMany(mappedBy = "suppliers")
    private Set<Contacts> contacts;

    @Column(name = "supplierName", nullable = false)
    private String supplierName;

    @Column(name = "supplierRegistrationNumber", nullable = false)
    private String supplierRegistrationNumber;

    @Column(name = "supplierVATNumber", nullable = false)
    private String supplierVATNumber;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "zipCode")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Countries countries;

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

    @ManyToOne
    @JoinColumn(name = "term")
    private PayTerms payTerms;

    @ManyToOne
    @JoinColumn(name = "currencyId")
    private Currencies currencies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suppliers")
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

    @Column(name = "closed", nullable = false, columnDefinition = "boolean default false")
    private boolean isClosed;

    public Suppliers() {}

    public Suppliers(String supplierName, String supplierRegistrationNumber, String supplierVATNumber,
                     String addressLine1, String addressLine2, String city, String zipCode,
                     String contactPhone, String contactEmail, String swift, String bankCode,
                     String bankName, String bankAccount,
                     Date lastUpdatedDate, String lastUpdatedBy, Date createdDate, String createdBy, boolean isClosed) {
        this.supplierName = supplierName;
        this.supplierRegistrationNumber = supplierRegistrationNumber;
        this.supplierVATNumber = supplierVATNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zipCode = zipCode;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.swift = swift;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Set<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contacts> contacts) {
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
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

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public PayTerms getPayTerms() {
        return payTerms;
    }

    public void setPayTerms(PayTerms payTerms) {
        this.payTerms = payTerms;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
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

    @Override
    public String toString() {
        return "Suppliers{" +
                "supplierId=" + supplierId +
                ", contacts=" + contacts +
                ", supplierName='" + supplierName + '\'' +
                ", supplierRegistrationNumber='" + supplierRegistrationNumber + '\'' +
                ", supplierVATNumber='" + supplierVATNumber + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", countries=" + countries +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", swift='" + swift + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", payTerms=" + payTerms +
                ", currencies=" + currencies +
                ", items=" + items +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}
