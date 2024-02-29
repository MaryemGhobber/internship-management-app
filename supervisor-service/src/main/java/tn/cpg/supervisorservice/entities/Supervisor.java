package tn.cpg.supervisorservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Supervisor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSupervisor;
    private int cin;
    private String password;
    private String firstname;
    private String lastname;
    private String mail;
    private int phoneNumber;
    private LocalDate birthdate;

}
