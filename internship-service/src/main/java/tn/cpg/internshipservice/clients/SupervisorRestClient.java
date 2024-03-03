package tn.cpg.internshipservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.cpg.internshipservice.model.Supervisor;

import java.util.List;

@FeignClient(name = "SUPERVISOR-SERVICE")
public interface SupervisorRestClient {
    @GetMapping("/supervisors/{id}")
    @CircuitBreaker(name = "supervisorService", fallbackMethod = "getDefaultSupervisors")
    Supervisor findSupervisorById(@PathVariable Long id);

    @GetMapping("/supervisors")
    List<Supervisor> allSupervisors();

    default Supervisor getDefaultSupervisors(Long id, Exception exception) {
        Supervisor supervisor = new Supervisor();

        supervisor.setIdSupervisor(id);
        supervisor.setFirstname("Not Available");
        supervisor.setLastname("Not Available");
        supervisor.setMail("Not Available");
        return supervisor;
    }
}
