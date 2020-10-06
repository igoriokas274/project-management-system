package managerprodb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "PROJECT_STATUS")
public class ProjectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectStatusId", nullable = false, unique = true)
    private Long projectStatusId;

    @Column(name = "projectStatusName")
    private String projectStatusName;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Projects projects;

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

   public ProjectStatus() {}

    public ProjectStatus(String projectStatusName, Projects projects, Date lastUpdatedDate, String lastUpdatedBy,
                         Date createdDate, String createdBy) {
        this.projectStatusName = projectStatusName;
        this.projects = projects;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "ProjectStatus{" +
                "projectStatusId=" + projectStatusId +
                ", projectStatusName='" + projectStatusName + '\'' +
                ", projects=" + projects +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
