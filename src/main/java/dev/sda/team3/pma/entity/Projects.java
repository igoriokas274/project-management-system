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

   public Projects() {}

    public Projects(Set<ProjectStatus> projectStatuses, Set<ProjectType> projectTypes, Set<Employee> employees,
                    Set<Customers> customers, String projectName, Date projectStartDate, Date projectEndDate,
                    String projectMemo1, String projectMemo2, Date lastUpdatedDate, String lastUpdatedBy,
                    Date createdDate, String createdBy, boolean isClosed) {
        this.projectStatuses = projectStatuses;
        this.projectTypes = projectTypes;
        this.employees = employees;
        this.customers = customers;
        this.projectName = projectName;
        this.projectStartDate = projectStartDate;
        ProjectEndDate = projectEndDate;
        this.projectMemo1 = projectMemo1;
        this.projectMemo2 = projectMemo2;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.isClosed = isClosed;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projectId=" + projectId +
                ", projectStatuses=" + projectStatuses +
                ", projectTypes=" + projectTypes +
                ", employees=" + employees +
                ", customers=" + customers +
                ", projectName='" + projectName + '\'' +
                ", projectStartDate=" + projectStartDate +
                ", ProjectEndDate=" + ProjectEndDate +
                ", projectMemo1='" + projectMemo1 + '\'' +
                ", projectMemo2='" + projectMemo2 + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}
