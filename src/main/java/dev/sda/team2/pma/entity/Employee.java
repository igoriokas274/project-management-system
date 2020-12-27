package dev.sda.team2.pma.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId", nullable = false, unique = true)
    private Long employeeId;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfEmployment", nullable = false)
    private Date dateOfEmployment;

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

    @Column(name = "closed", nullable = false, columnDefinition = "int default 0")
    private boolean isClosed;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "employee_project",
            joinColumns = {@JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "projectId")}
    )
    private Set<Project> projects = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "departmentId")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactId")
    private Contact contact;

    @OneToOne(mappedBy = "employee", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private UserAccount userAccount;

    public Employee() {
    }

    public Employee(Date dateOfEmployment, String bankCode, String bankName, String bankAccount, Date lastUpdatedDate,
                    String lastUpdatedBy, Date createdDate, String createdBy, boolean isClosed, Set<Project> projects,
                    Department department, Contact contact, UserAccount userAccount) {
        this.dateOfEmployment = dateOfEmployment;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
        this.projects = projects;
        this.department = department;
        this.contact = contact;
        this.userAccount = userAccount;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", dateOfEmployment=" + dateOfEmployment +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isClosed=" + isClosed +
                ", projects=" + projects +
                ", department=" + department +
                ", contact=" + contact +
                ", userAccount=" + userAccount +
                '}';
    }
}
