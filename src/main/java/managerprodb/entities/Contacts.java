package managerprodb.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    @Embedded
    private Address address = new Address();

    @Column(name = "contactPhone")
    private String contactPhone;

    @Column(name = "contactEmail")
    private String contactEmail;

    @Column(name = "gender", length = 1)
    private Character contactGender;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date contactBirthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId")
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

    @Column(name = "closed", nullable = false, columnDefinition = "boolean default false")
    private boolean isClosed;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
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
