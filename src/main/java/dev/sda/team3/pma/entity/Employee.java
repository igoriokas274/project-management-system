package dev.sda.team3.pma.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId", nullable = false, unique = true)
    private Long employeeId;

    @OneToOne(targetEntity = Contacts.class)
    private Contacts contacts;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfEmployment", nullable = false)
    private Date dateOfEmployment;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private EmployeeDepartments employeeDepartments;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "EMPLOYEE_PROJECTS",
            joinColumns = {@JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "projectId")}
    )
    private Set<Projects> projects = new HashSet<Projects>();

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
    @Column(name = "createdDate", nullable = false, updatable = false)
    private Date createdDate;

    @Column(name = "createdBy", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "closed", nullable = false, columnDefinition = "boolean default false")
    private boolean isClosed;

    public Employee() {}

    public Employee(Date dateOfEmployment, String bankCode, String bankName, String bankAccount, Date lastUpdatedDate,
                    String lastUpdatedBy, Date createdDate, String createdBy, boolean isClosed) {
        this.dateOfEmployment = dateOfEmployment;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public EmployeeDepartments getEmployeeDepartments() {
        return employeeDepartments;
    }

    public void setEmployeeDepartments(EmployeeDepartments employeeDepartments) {
        this.employeeDepartments = employeeDepartments;
    }

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
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
        return "Employee{" +
                "employeeId=" + employeeId +
                ", contacts=" + contacts +
                ", dateOfEmployment=" + dateOfEmployment +
                ", employeeDepartments=" + employeeDepartments +
                ", projects=" + projects +
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
