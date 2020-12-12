package dev.sda.team3.pma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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
    private String supplierName;

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

    public Customers(Set<Contacts> contacts, Set<Projects> projects, PayTerms payTerms, Currencies currencies,
                     Countries countries, String supplierName, String customerRegistrationNumber,
                     String customerVATNumber, String addressLine1, String addressLine2, String city, String zipCode,
                     String contactPhone, String contactEmail, String swift, String bankCode, String bankName,
                     String bankAccount, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate, String createdBy,
                     boolean isClosed) {
        this.contacts = contacts;
        this.projects = projects;
        this.payTerms = payTerms;
        this.currencies = currencies;
        this.countries = countries;
        this.supplierName = supplierName;
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

    @Override
    public String toString() {
        return "Customers{" +
                "customerId=" + customerId +
                ", contacts=" + contacts +
                ", projects=" + projects +
                ", payTerms=" + payTerms +
                ", currencies=" + currencies +
                ", countries=" + countries +
                ", supplierName='" + supplierName + '\'' +
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
