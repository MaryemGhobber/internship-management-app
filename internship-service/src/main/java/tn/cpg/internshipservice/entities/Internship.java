package tn.cpg.internshipservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.cpg.internshipservice.model.Supervisor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//stage
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInternship;
    private String internshipname;

    @JsonIgnore
    @OneToMany(mappedBy = "internship")
    private List<Candidacy> candidacyList;
    @Transient
    private Supervisor supervisor;
    private Long supervisorId;
    @JsonIgnore
    @OneToMany(mappedBy = "internship")
    private List<Intern> internList;
}