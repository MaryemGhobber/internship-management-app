package tn.cpg.internshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.cpg.internshipservice.entities.Intern;

import java.util.Optional;

public interface InternRepository extends JpaRepository<Intern, Long> {
    public Intern findByCin(int cin);

}
