package tn.cpg.internshipservice.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInternship;
    @OneToMany(mappedBy = "internship")
    private List<Intern> internList;


}
