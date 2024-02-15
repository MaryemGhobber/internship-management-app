package tn.cpg.internshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.cpg.internshipservice.entities.Intern;

public interface InternRepository extends JpaRepository<Intern, Long> {
}
