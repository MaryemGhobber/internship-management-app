package tn.cpg.internshipservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInternship;
    private String internshipname;
    /* @JsonIgnore
     @OneToMany(mappedBy = "internship")
     private List<Intern> internList;*/
    @JsonIgnore
    @OneToMany(mappedBy = "internship")
    private List<Candidacy> candidacyList;

}