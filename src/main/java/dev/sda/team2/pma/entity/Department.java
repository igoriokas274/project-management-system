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
@Table(name = "department")
@EntityListeners(AuditingEntityListener.class)
public class Department extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId", nullable = false, unique = true)
    private Long departmentId;

    @Column(name = "departmentName")
    private String departmentName;

    @Column(name = "closed", nullable = false, columnDefinition = "int default 0")
    private boolean isClosed;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Employee> employees;

}
