package dev.sda.team2.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "project_type")
@EntityListeners(AuditingEntityListener.class)
public class ProjectType extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectTypeId", nullable = false, unique = true)
    private Long projectTypeId;

    @Column(name = "projectTypeName")
    private String projectTypeName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectType", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Project> projects;

}
