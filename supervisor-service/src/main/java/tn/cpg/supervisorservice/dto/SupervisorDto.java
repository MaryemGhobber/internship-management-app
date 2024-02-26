package tn.cpg.supervisorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SupervisorDto {
    private Long idSupervisor;
    private int cin;
    private String password;
    private String firstname;
    private String lastname;
    private String mail;
    private int phoneNumber;
    private LocalDate birthdate;
}
