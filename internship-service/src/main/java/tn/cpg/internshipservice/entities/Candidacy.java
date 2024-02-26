package tn.cpg.internshipservice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Candidacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidacy;
    private LocalDate dateSubmission;
    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    private Internship internship;
}
