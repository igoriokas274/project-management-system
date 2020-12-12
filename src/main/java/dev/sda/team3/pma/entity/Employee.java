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

    public Employee(Contacts contacts, Date dateOfEmployment, EmployeeDepartments employeeDepartments,
                    Set<Projects> projects, String bankCode, String bankName, String bankAccount, Date lastUpdatedDate,
                    String lastUpdatedBy, Date createdDate, String createdBy, boolean isClosed) {
        this.contacts = contacts;
        this.dateOfEmployment = dateOfEmployment;
        this.employeeDepartments = employeeDepartments;
        this.projects = projects;
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
