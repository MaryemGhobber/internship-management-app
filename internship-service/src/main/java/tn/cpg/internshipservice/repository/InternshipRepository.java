package tn.cpg.internshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.cpg.internshipservice.entities.Internship;

import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship, Long> {
    public List<Internship>findAllInternshipsBySupervisorId(Long supervisorId);
}
