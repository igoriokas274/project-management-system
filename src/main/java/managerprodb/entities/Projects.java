package managerprodb.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PROJECTS")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private Long projectId;

    @Column(name = "projectName")
    private String projectName;

    @Temporal(TemporalType.DATE)
    @Column(name = "projectStartDate")
    private Date projectStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "getProjectEndDate")
    private Date getProjectEndDate;

    @OneToMany(mappedBy = "projects") // Checked
    private Set<ProjectStatus> projectStatuses;

    @OneToMany(mappedBy = "projects") // Checked
    private Set<ProjectType> projectTypes;

    @ManyToMany // Checked
    @JoinTable(name = "EMPLOYEE_PROJECTS", joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns = @JoinColumn(name = "employeeId"))
    private Set<Employee> employees;

    @ManyToMany(cascade = CascadeType.ALL) // Checked
    @JoinTable(name = "CUSTOMER_PROJECTS", joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns = @JoinColumn(name = "customerId"))
    private Set<Customers> customers;

    @Column(name = "projectMemo1", columnDefinition="TEXT")
    private String projectMemo1;

    @Column(name = "projectMemo2", columnDefinition="TEXT")
    private String projectMemo2;

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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getGetProjectEndDate() {
        return getProjectEndDate;
    }

    public void setGetProjectEndDate(Date getProjectEndDate) {
        this.getProjectEndDate = getProjectEndDate;
    }

    public Set<ProjectStatus> getProjectStatuses() {
        return projectStatuses;
    }

    public void setProjectStatuses(Set<ProjectStatus> projectStatuses) {
        this.projectStatuses = projectStatuses;
    }

    public Set<ProjectType> getProjectTypes() {
        return projectTypes;
    }

    public void setProjectTypes(Set<ProjectType> projectTypes) {
        this.projectTypes = projectTypes;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getProjectMemo1() {
        return projectMemo1;
    }

    public void setProjectMemo1(String projectMemo1) {
        this.projectMemo1 = projectMemo1;
    }

    public String getProjectMemo2() {
        return projectMemo2;
    }

    public void setProjectMemo2(String projectMemo2) {
        this.projectMemo2 = projectMemo2;
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

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
    }
}
