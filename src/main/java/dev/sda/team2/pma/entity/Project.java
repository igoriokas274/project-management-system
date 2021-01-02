package dev.sda.team2.pma.entity;

import dev.sda.team2.pma.auditing.Auditable;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
@EntityListeners(AuditingEntityListener.class)
public class Project extends Auditable {

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
    @Column(name = "projectEndDate")
    private Date projectEndDate;

    @Column(name = "projectMemo1", columnDefinition="TEXT")
    private String projectMemo1;

    @Column(name = "projectMemo2", columnDefinition="TEXT")
    private String projectMemo2;

    @Column(name = "closed", nullable = false, columnDefinition = "int default 0")
    private boolean isClosed;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "projectStatusId")
    private ProjectStatus projectStatus;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "projectTypeId")
    private ProjectType projectType;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Employee> employees = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "term")
    private PayTerm payTerm;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Quotation> quotations;

}
