package managerprodb.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROJECTS")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private Long projectId;

    @OneToMany(mappedBy = "projects")
    private Set<ProjectStatus> projectStatuses = new HashSet<ProjectStatus>();

    @OneToMany(mappedBy = "projects")
    private Set<ProjectType> projectTypes = new HashSet<ProjectType>();

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<Employee>();

    @ManyToMany(mappedBy = "projects")
    private Set<Customers> customers = new HashSet<Customers>();

    @Column(name = "projectName")
    private String projectName;

    @Temporal(TemporalType.DATE)
    @Column(name = "projectStartDate")
    private Date projectStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "ProjectEndDate")
    private Date ProjectEndDate;

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

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
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

    public Date getProjectEndDate() {
        return ProjectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        ProjectEndDate = projectEndDate;
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
}
