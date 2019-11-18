package edu.project2.university.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "department_name")
    private DepartmentName name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_of_department_id")
    private Speaker headOfDepartment;

    @OneToMany(mappedBy = "speakerBelongsDepartment", cascade = CascadeType.PERSIST)
    private List<Speaker> speakerList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Speaker speaker;
}
