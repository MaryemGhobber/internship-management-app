package tn.cpg.supervisorservice.service;

import org.springframework.stereotype.Service;
import tn.cpg.supervisorservice.dto.SupervisorDto;
import tn.cpg.supervisorservice.entities.Supervisor;
import tn.cpg.supervisorservice.mapper.SupervisorMapper;
import tn.cpg.supervisorservice.repository.SupervisorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService implements CrudService<SupervisorDto>{
    private final SupervisorRepository supervisorRepository;

    public SupervisorService(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public List<SupervisorDto> findAll() {
        List<SupervisorDto> supervisorDtoList = new ArrayList<>();
        supervisorRepository.findAll().forEach(supervisor -> supervisorDtoList.add(SupervisorMapper.INSTANCE.supervisorToDto(supervisor)));
        return supervisorDtoList;
    }

    @Override
    public Optional<SupervisorDto> findById(Long id) {
        Optional<Supervisor> supervisorOptional = supervisorRepository.findById(id);
        return supervisorOptional.map(SupervisorMapper.INSTANCE::supervisorToDto);
    }

    @Override
    public SupervisorDto save(SupervisorDto dto) {
        Supervisor supervisor = SupervisorMapper.INSTANCE.dtoToSupervisor(dto);
        return SupervisorMapper.INSTANCE.supervisorToDto(supervisorRepository.save(supervisor));
    }

    @Override
    public void delete(Long id) {
       supervisorRepository.deleteById(id);
    }

    @Override
    public SupervisorDto update(Long id, SupervisorDto dto) {
        Supervisor savedSupervisor = supervisorRepository.findById(id).orElseThrow();
        Supervisor supervisorToUpdate = SupervisorMapper.INSTANCE.dtoToSupervisor(dto);
        savedSupervisor.setFirstname(supervisorToUpdate.getFirstname());
        savedSupervisor.setLastname(supervisorToUpdate.getLastname());
        savedSupervisor.setCin(supervisorToUpdate.getCin());
        savedSupervisor.setPassword(supervisorToUpdate.getPassword());
        savedSupervisor.setMail(supervisorToUpdate.getMail());
        savedSupervisor.setPhoneNumber(supervisorToUpdate.getPhoneNumber());
        savedSupervisor.setBirthdate(supervisorToUpdate.getBirthdate());


        return SupervisorMapper.INSTANCE.supervisorToDto(supervisorRepository.save(savedSupervisor));
    }

}
