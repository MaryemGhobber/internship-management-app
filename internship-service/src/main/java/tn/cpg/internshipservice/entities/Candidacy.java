package tn.cpg.internshipservice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Candidacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidacy;
    private LocalDate dateSoumission;
    @ManyToOne
    private Intern intern;

    @ManyToOne
    private Internship internship;
}
