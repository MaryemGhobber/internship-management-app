package tn.cpg.internshipservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.cpg.internshipservice.dto.CandidacyDto;
import tn.cpg.internshipservice.service.CandidacyService;

import java.util.List;
import java.util.Optional;

@RestController
public class CandidacyRestController {
    private final CandidacyService candidacyService;


    public CandidacyRestController(CandidacyService candidacyService) {
        this.candidacyService = candidacyService;
    }
    @GetMapping("/candidacies")
    public ResponseEntity<List<CandidacyDto>> findAll() {

        return new ResponseEntity<>(candidacyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/candidacies/{id}")
    public ResponseEntity<CandidacyDto> findById(@PathVariable Long id) {
        Optional<CandidacyDto> candidacyDtoOptional = candidacyService.findById(id);

        return candidacyDtoOptional.map(candidacyDto -> new ResponseEntity<>(candidacyDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addCandidacy")
    public ResponseEntity<CandidacyDto> save(@RequestBody CandidacyDto dto) {
        return new ResponseEntity<>(candidacyService.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCandidacy/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        Optional<CandidacyDto> candidacyDto = candidacyService.findById(id);
        candidacyDto.ifPresent(n -> candidacyService.delete(id));
        return candidacyDto.map(n ->
                        new ResponseEntity<>("Object with id " + id + " was deleted.", HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));

    /*    if (internDto.isPresent()) {
            internService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("The intern with the id:" + id + "was deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No intern with the id:" + id);
        }*/


    }

    @PutMapping("updateCandidacy/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CandidacyDto dto) {
        Optional<CandidacyDto> optional = candidacyService.findById(id);
        optional.ifPresent(n -> candidacyService.update(id, dto));

        return optional.map(n ->
                        new ResponseEntity<>("Object with id " + id + " was updated.", HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));
    }
}
