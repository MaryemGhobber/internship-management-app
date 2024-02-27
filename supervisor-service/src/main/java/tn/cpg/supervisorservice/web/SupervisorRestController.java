package tn.cpg.supervisorservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.cpg.supervisorservice.dto.SupervisorDto;
import tn.cpg.supervisorservice.service.SupervisorService;

import java.util.List;
import java.util.Optional;

@RestController
public class SupervisorRestController {
    private final SupervisorService supervisorService;

    public SupervisorRestController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }


    @GetMapping("/supervisors")
    public ResponseEntity<List<SupervisorDto>> findAll() {

        return new ResponseEntity<>(supervisorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/supervisors/{id}")
    public ResponseEntity<SupervisorDto> findById(@PathVariable Long id) {
        Optional<SupervisorDto> supervisorDtoOptional = supervisorService.findById(id);

        return supervisorDtoOptional.map(supervisorDto -> new ResponseEntity<>(supervisorDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addSupervisor")
    public ResponseEntity<SupervisorDto> save(@RequestBody SupervisorDto dto) {
        return new ResponseEntity<>(supervisorService.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSupervisor/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        Optional<SupervisorDto> supervisorDto = supervisorService.findById(id);
        supervisorDto.ifPresent(n -> supervisorService.delete(id));
        return supervisorDto.map(n ->
                        new ResponseEntity<>("Object with id " + id + " was deleted.", HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));

    /*    if (internDto.isPresent()) {
            internService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("The intern with the id:" + id + "was deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No intern with the id:" + id);
        }*/


    }

    @PutMapping("updateSupervisor/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody SupervisorDto dto) {
        Optional<SupervisorDto> optional = supervisorService.findById(id);
        optional.ifPresent(n -> supervisorService.update(id, dto));

        return optional.map(n ->
                        new ResponseEntity<>("Object with id " + id + " was updated.", HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));
    }
}
