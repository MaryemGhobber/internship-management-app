package tn.cpg.internshipservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.cpg.internshipservice.dto.InternDto;
import tn.cpg.internshipservice.service.InternService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/interns/{id}")
    public ResponseEntity<InternDto> findById(@PathVariable Long id) {
        Optional<InternDto> internDtoOptional = internService.findById(id);

        return internDtoOptional.map(internDto -> new ResponseEntity<>(internDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addIntern")
    public ResponseEntity<InternDto> save(@RequestBody InternDto dto) {
        return new ResponseEntity<>(internService.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteIntern/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        Optional<InternDto> internDto = internService.findById(id);
        internDto.ifPresent(n -> internService.delete(id));
        return internDto.map(n ->
                        new ResponseEntity<>("Object with id " + id + " was deleted.", HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));

    /*    if (internDto.isPresent()) {
            internService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("The intern with the id:" + id + "was deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No intern with the id:" + id);
        }*/


    }

    @PutMapping("updateIntern/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody InternDto dto) {
        Optional<InternDto> optional = internService.findById(id);
        optional.ifPresent(n -> internService.update(id, dto));

        return optional.map(n ->
                        new ResponseEntity<>("Object with id " + id + " was updated.", HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));
    }

}
