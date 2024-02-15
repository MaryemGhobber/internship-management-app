package tn.cpg.internshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.cpg.internshipservice.entities.Internship;

public interface InternshipRepository extends JpaRepository<Internship, Long> {
}
