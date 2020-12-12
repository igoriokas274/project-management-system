package dev.sda.team3.pma.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId", nullable = false, unique = true)
    private Long customerId;

    @OneToMany(mappedBy = "customers")
    private Set<Contacts> contacts;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "CUSTOMER_PROJECTS",
            joinColumns = {@JoinColumn(name = "customerId")},
            inverseJoinColumns = {@JoinColumn(name = "projectId")}
    )
    private Set<Projects> projects = new HashSet<Projects>();

    @ManyToOne
    @JoinColumn(name = "term")
    private PayTerms payTerms;

    @ManyToOne
    @JoinColumn(name = "currencyId")
    private Currencies currencies;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Countries countries;

    @Column(name = "customerName", nullable = false)
    private String customerName;

    @Column(name = "customerRegistrationNumber", nullable = false)
    private String customerRegistrationNumber;

    @Column(name = "customerVATNumber", nullable = false)
    private String customerVATNumber;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "customerPhone")
    private String contactPhone;

    @Column(name = "customerEmail")
    private String contactEmail;

    @Column(name = "SWIFT")
    private String swift;

    @Column(name = "bankCode", nullable = false)
    private String bankCode;

    @Column(name = "bankName", nullable = false)
    private String bankName;

    @Column(name = "bankAccount", nullable = false)
    private String bankAccount;

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

    public Customers() {}

    public Customers(String customerName, String customerRegistrationNumber,
                     String customerVATNumber, String addressLine1, String addressLine2, String city, String zipCode,
                     String contactPhone, String contactEmail, String swift, String bankCode, String bankName,
                     String bankAccount, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate, String createdBy,
                     boolean isClosed) {
        this.customerName = customerName;
        this.customerRegistrationNumber = customerRegistrationNumber;
        this.customerVATNumber = customerVATNumber;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Set<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contacts> contacts) {
        this.contacts = contacts;
    }

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
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

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerRegistrationNumber() {
        return customerRegistrationNumber;
    }

    public void setCustomerRegistrationNumber(String customerRegistrationNumber) {
        this.customerRegistrationNumber = customerRegistrationNumber;
    }

    public String getCustomerVATNumber() {
        return customerVATNumber;
    }

    public void setCustomerVATNumber(String customerVATNumber) {
        this.customerVATNumber = customerVATNumber;
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
        return "Customers{" +
                "customerId=" + customerId +
                ", contacts=" + contacts +
                ", projects=" + projects +
                ", payTerms=" + payTerms +
                ", currencies=" + currencies +
                ", countries=" + countries +
                ", customerName='" + customerName + '\'' +
                ", customerRegistrationNumber='" + customerRegistrationNumber + '\'' +
                ", customerVATNumber='" + customerVATNumber + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", swift='" + swift + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}
