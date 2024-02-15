package tn.cpg.internshipservice.dto;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import tn.cpg.internshipservice.entities.Internship;
import tn.cpg.internshipservice.enums.ClassLevel;
import tn.cpg.internshipservice.enums.Level;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link tn.cpg.internshipservice.entities.Intern}
 */

public record InternDto(Long idIntern, int cin, String firstname, String lastname, String mail, int phoneNumber,
                        LocalDate birthdate, Level level, ClassLevel classLevel,
                        Internship internship) implements Serializable {
}