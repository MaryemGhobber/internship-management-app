package tn.cpg.internshipservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter @Setter @ToString
public class Supervisor {
    private Long idSupervisor;
    private int cin;
    private String password;
    private String firstname;
    private String lastname;
    private String mail;
    private int phoneNumber;
    private LocalDate birthdate;
}
