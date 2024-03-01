package tn.cpg.internshipservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.cpg.internshipservice.clients.SupervisorRestClient;
import tn.cpg.internshipservice.dto.InternshipDto;
import tn.cpg.internshipservice.entities.Internship;
import tn.cpg.internshipservice.model.Supervisor;
import tn.cpg.internshipservice.service.InternshipService;

import java.util.List;
import java.util.Optional;

@RestController
public class InternshipRestController {
    private final InternshipService internshipService;


    public InternshipRestController(InternshipService internshipService) {
        this.internshipService = internshipService;

    }

    @GetMapping("/internships")
    public ResponseEntity<List<InternshipDto>> findAll() {

        return new ResponseEntity<>(internshipService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/internships/{id}")
    public ResponseEntity<InternshipDto> findById(@PathVariable Long id) {
        Optional<InternshipDto> internshipDtoOptional = internshipService.findById(id);
        return internshipDtoOptional.map(internshipDto -> new ResponseEntity<>(internshipDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addInternship")
    public ResponseEntity<InternshipDto> save(@RequestBody InternshipDto dto) {

        return new ResponseEntity<>(internshipService.save(dto), HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteInternship/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        Optional<InternshipDto> internshipDto = internshipService.findById(id);
        internshipDto.ifPresent(n -> internshipService.delete(id));
        return internshipDto.map(n ->
                        new ResponseEntity<>("Object with id " + id + " was deleted.", HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));
    }


    @PutMapping("updateInternship/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody InternshipDto dto) {
        Optional<InternshipDto> optional = internshipService.findById(id);
        optional.ifPresent(n -> internshipService.update(id, dto));

        return optional.map(n ->
                        new ResponseEntity<>("Object with id " + id + " was updated.", HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));
    }
}
