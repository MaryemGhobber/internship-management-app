package tn.cpg.internshipservice.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tn.cpg.internshipservice.entities.Intern;
import tn.cpg.internshipservice.entities.Internship;
import tn.cpg.internshipservice.enums.ClassLevel;
import tn.cpg.internshipservice.enums.Level;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link tn.cpg.internshipservice.entities.Internship}
 */

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class InternshipDto {
    private Long idInternship;
    private String internshipname;
    private List<Intern> internList;
}