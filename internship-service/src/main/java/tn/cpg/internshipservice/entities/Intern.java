package tn.cpg.internshipservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.cpg.internshipservice.enums.ClassLevel;
import tn.cpg.internshipservice.enums.Level;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//stagiaire
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntern;
    private int cin;
    private String password;
    private String firstname;
    private String lastname;
    private String mail;
    private int phoneNumber;
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Enumerated(EnumType.STRING)
    private ClassLevel classLevel;

  /*  @JsonIgnore
    @OneToMany(mappedBy = "intern")
    private List<Candidacy> candidacyList;*/
  @ManyToOne
  private Internship internship;

}
