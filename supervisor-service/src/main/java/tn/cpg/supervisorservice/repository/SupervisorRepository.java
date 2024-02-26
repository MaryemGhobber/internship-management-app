package tn.cpg.supervisorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.cpg.supervisorservice.entities.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
