package managerprodb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "CONTACTS")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactId", nullable = false, unique = true)
    private Long contactId;

    @Column(name = "fullName", nullable = false)
    private String contactFullName;

    @Column(name = "title")
    private String title;

    @Column(name = "department")
    private String contactDepartment;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "contactPhone")
    private String contactPhone;

    @Column(name = "contactEmail")
    private String contactEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date contactBirthdate;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Countries countries;

    @OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Suppliers suppliers;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customers customers;

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

    @Column(name = "closed", nullable = false, columnDefinition = "int default 0")
    private boolean isClosed;

    public Contacts() {}

    public Contacts(String contactFullName, String title, String contactDepartment, String addressLine1,
                    String addressLine2, String city, String zipCode, String contactPhone, String contactEmail,
                    Gender gender, Date contactBirthdate, Countries countries, Employee employee, Suppliers suppliers,
                    Customers customers, Date lastUpdatedDate, String lastUpdatedBy, Date createdDate, String createdBy,
                    boolean isClosed) {
        this.contactFullName = contactFullName;
        this.title = title;
        this.contactDepartment = contactDepartment;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zipCode = zipCode;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.gender = gender;
        this.contactBirthdate = contactBirthdate;
        this.countries = countries;
        this.employee = employee;
        this.suppliers = suppliers;
        this.customers = customers;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contactId=" + contactId +
                ", contactFullName='" + contactFullName + '\'' +
                ", title='" + title + '\'' +
                ", contactDepartment='" + contactDepartment + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", gender=" + gender +
                ", contactBirthdate=" + contactBirthdate +
                ", countries=" + countries +
                ", employee=" + employee +
                ", suppliers=" + suppliers +
                ", customers=" + customers +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}
