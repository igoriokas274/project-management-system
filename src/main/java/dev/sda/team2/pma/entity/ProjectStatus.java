package dev.sda.team2.pma.entity;

import dev.sda.team2.pma.auditing.Auditable;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_status")
@EntityListeners(AuditingEntityListener.class)
public class ProjectStatus extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectStatusId", nullable = false, unique = true)
    private Long projectStatusId;

    @Column(name = "projectStatusName")
    private String projectStatusName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectStatus", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Project> projects;

}
