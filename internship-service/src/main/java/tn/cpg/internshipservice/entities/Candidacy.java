package tn.cpg.internshipservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candidacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidacy;
    private LocalDate dateSubmission;
    @ManyToOne
    //@JoinColumn(name = "intern_id")
    private Intern intern;

    @ManyToOne
   // @JoinColumn(name = "internship_id")
    private Internship internship;
}
