package tn.cpg.internshipservice.service;

import org.springframework.stereotype.Service;
import tn.cpg.internshipservice.clients.SupervisorRestClient;
import tn.cpg.internshipservice.dto.InternshipDto;
import tn.cpg.internshipservice.entities.Internship;
import tn.cpg.internshipservice.mapper.InternshipMapper;
import tn.cpg.internshipservice.model.Supervisor;
import tn.cpg.internshipservice.repository.InternshipRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InternshipService implements CrudService<InternshipDto> {
    private final InternshipRepository internshipRepository;
    private final SupervisorRestClient supervisorRestClient;

    public InternshipService(InternshipRepository internshipRepository, SupervisorRestClient supervisorRestClient) {
        this.internshipRepository = internshipRepository;
        this.supervisorRestClient = supervisorRestClient;
    }

    @Override
    public List<InternshipDto> findAll() {

        // List<Internship> internships = internshipRepository.findAll();
        //  internships.forEach(internshipDto -> internshipDto.setSupervisor(supervisorRestClient.findSupervisorById(internshipDto.getSupervisorId())));

        List<InternshipDto> internshipDtoList = new ArrayList<>();
        internshipRepository.findAll().forEach(internship -> internshipDtoList.add(InternshipMapper.INSTANCE.internshipToDto(internship)));
        internshipDtoList.forEach(a -> a.setSupervisor(supervisorRestClient.findSupervisorById(a.getSupervisorId())));
        return internshipDtoList;
    }

    @Override
    public Optional<InternshipDto> findById(Long id) {
        Optional<Internship> internOptional = internshipRepository.findById(id);
        Supervisor supervisor = supervisorRestClient.findSupervisorById(internOptional.get().getSupervisorId());
        internOptional.orElseThrow().setSupervisor(supervisor);
        return internOptional.map(InternshipMapper.INSTANCE::internshipToDto);
    }

    @Override
    public InternshipDto save(InternshipDto dto) {
        Supervisor supervisor = supervisorRestClient.findSupervisorById(dto.getSupervisorId());
        dto.setSupervisor(supervisor);
        Internship internship = InternshipMapper.INSTANCE.dtoToInternship(dto);
        return InternshipMapper.INSTANCE.internshipToDto(internshipRepository.save(internship));
    }

    @Override
    public void delete(Long id) {
        internshipRepository.deleteById(id);
    }

    @Override
    public InternshipDto update(Long id, InternshipDto dto) {
        Internship savedInternship = internshipRepository.findById(id).orElseThrow();
        //Supervisor supervisor = supervisorRestClient.findSupervisorById(savedInternship.getSupervisorId());
        // savedInternship.setSupervisor(supervisor);
        Internship internshipToUpdate = InternshipMapper.INSTANCE.dtoToInternship(dto);
        savedInternship.setInternshipname(internshipToUpdate.getInternshipname());
        //  savedInternship.setInternList(internshipToUpdate.getInternList());
        savedInternship.setCandidacyList(internshipToUpdate.getCandidacyList());
        savedInternship.setSupervisorId(internshipToUpdate.getSupervisorId());
        return InternshipMapper.INSTANCE.internshipToDto(internshipRepository.save(savedInternship));
    }
}
