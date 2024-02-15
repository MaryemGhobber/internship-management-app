package tn.cpg.internshipservice.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.cpg.internshipservice.enums.ClassLevel;
import tn.cpg.internshipservice.enums.Level;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntern;
    private int cin;
    private String firstname;
    private String lastname;
    private String mail;
    private int phoneNumber;
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Enumerated(EnumType.STRING)
    private ClassLevel classLevel;
    @ManyToOne
    @JoinColumn(name = "internship_id")
    private Internship internship;


}
