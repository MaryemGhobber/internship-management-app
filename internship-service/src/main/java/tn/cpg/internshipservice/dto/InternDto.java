package tn.cpg.internshipservice.dto;


import lombok.*;
import lombok.experimental.SuperBuilder;
import tn.cpg.internshipservice.entities.Candidacy;
import tn.cpg.internshipservice.entities.Internship;
import tn.cpg.internshipservice.enums.ClassLevel;
import tn.cpg.internshipservice.enums.Level;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link tn.cpg.internshipservice.entities.Intern}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InternDto {
    private Long idIntern;
    private int cin;
    private String firstname;
    private String lastname;
    private String mail;
    private int phoneNumber;
    private LocalDate birthdate;
    private Level level;
    private ClassLevel classLevel;

    //  private  Internship internship;
    private Candidacy candidacy;
}