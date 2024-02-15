package tn.cpg.internshipservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import tn.cpg.internshipservice.entities.Intern;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link tn.cpg.internshipservice.entities.Internship}
 */
@Getter @Setter
public record InternshipDto(Long idInternship, List<Intern> internList) implements Serializable {
}