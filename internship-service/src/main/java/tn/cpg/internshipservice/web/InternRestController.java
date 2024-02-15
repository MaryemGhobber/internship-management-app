package tn.cpg.internshipservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.cpg.internshipservice.dto.InternDto;
import tn.cpg.internshipservice.service.InternService;

import java.util.List;

@RestController
public class InternRestController {
    private final InternService internService;

    public InternRestController(InternService internService) {
        this.internService = internService;
    }

    @GetMapping("/interns")
    public ResponseEntity<List<InternDto>> findAll() {

        return new ResponseEntity<>(internService.findAll(), HttpStatus.OK);
    }

}
