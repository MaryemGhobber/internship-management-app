package tn.cpg.internshipservice.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tn.cpg.internshipservice.entities.Intern;
import tn.cpg.internshipservice.entities.Internship;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CandidacyDto {
    private Long idCandidacy;
    private LocalDate dateSubmission;
    @Builder.Default
    private Boolean status=false;
    private Intern intern;
    private Internship internship;
}
