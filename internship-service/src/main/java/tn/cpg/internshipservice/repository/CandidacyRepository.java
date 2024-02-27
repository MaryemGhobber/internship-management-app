package tn.cpg.internshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.cpg.internshipservice.entities.Candidacy;
import tn.cpg.internshipservice.entities.Intern;
import tn.cpg.internshipservice.entities.Internship;

import java.util.List;
import java.util.Optional;


public interface CandidacyRepository extends JpaRepository<Candidacy, Long> {
    public Candidacy findCandidaciesByIntern(Intern intern);
    public List<Candidacy> findCandidaciesByInternship(Optional<Internship> internship);
}
