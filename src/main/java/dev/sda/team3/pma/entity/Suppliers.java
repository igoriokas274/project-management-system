package dev.sda.team3.pma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
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

    public Suppliers(Set<Contacts> contacts, String supplierName, String supplierRegistrationNumber,
                     String supplierVATNumber, String addressLine1, String addressLine2, String city, String zipCode,
                     Countries countries, String contactPhone, String contactEmail, String swift, String bankCode,
                     String bankName, String bankAccount, PayTerms payTerms, Currencies currencies, Set<Items> items,
                     Date lastUpdatedDate, String lastUpdatedBy, Date createdDate, String createdBy, boolean isClosed) {
        this.contacts = contacts;
        this.supplierName = supplierName;
        this.supplierRegistrationNumber = supplierRegistrationNumber;
        this.supplierVATNumber = supplierVATNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zipCode = zipCode;
        this.countries = countries;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.swift = swift;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.payTerms = payTerms;
        this.currencies = currencies;
        this.items = items;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
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
