package tn.cpg.internshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.cpg.internshipservice.entities.Candidacy;

public interface CandidacyRepository extends JpaRepository<Candidacy, Long> {
}
