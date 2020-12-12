package dev.sda.team3.pma.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "PROJECT_TYPE")
public class ProjectType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectTypeId", nullable = false, unique = true)
    private Long projectTypeId;

    @Column(name = "projectTypeName")
    private String projectTypeName;

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

    public ProjectType() {}

    public ProjectType(String projectTypeName, Projects projects, Date lastUpdatedDate, String lastUpdatedBy,
                       Date createdDate, String createdBy) {
        this.projectTypeName = projectTypeName;
        this.projects = projects;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "ProjectType{" +
                "projectTypeId=" + projectTypeId +
                ", projectTypeName='" + projectTypeName + '\'' +
                ", projects=" + projects +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
