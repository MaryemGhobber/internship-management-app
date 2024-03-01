package tn.cpg.internshipservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.cpg.internshipservice.model.Supervisor;

import java.util.List;

@FeignClient(name = "SUPERVISOR-SERVICE")
public interface SupervisorRestClient {
    @GetMapping("/supervisors/{id}")
    Supervisor findSupervisorById(@PathVariable Long id);

    @GetMapping("/supervisors")
    List<Supervisor> allSupervisors();
}
