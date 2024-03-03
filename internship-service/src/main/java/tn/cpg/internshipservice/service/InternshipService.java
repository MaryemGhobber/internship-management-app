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
    private SupervisorRestClient supervisorRestClient;

    public InternshipService(InternshipRepository internshipRepository, SupervisorRestClient supervisorRestClient) {
        this.internshipRepository = internshipRepository;
        this.supervisorRestClient = supervisorRestClient;
    }

    @Override
    public List<InternshipDto> findAll() {
       /* List<InternshipDto> supervisorDtoList = new ArrayList<>();
        internshipRepository.findAll().forEach(internship -> supervisorDtoList.add(InternshipMapper.INSTANCE.internshipToDto(internship)));
        return supervisorDtoList;*/
        List<Internship> internships = internshipRepository.findAll();
        List<InternshipDto> internshipDtos = new ArrayList<>();

        for (Internship internship : internships) {
            Supervisor supervisor = supervisorRestClient.findSupervisorById(internship.getSupervisorId());
            internship.setSupervisor(supervisor);
            internshipDtos.add(InternshipMapper.INSTANCE.internshipToDto(internship));
        }

        return internshipDtos;
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
        //Long supervisorId=supervisorRestClient.findSupervisorById(dto.getSupervisorId()).getIdSupervisor();
        Supervisor supervisor = supervisorRestClient.findSupervisorById(savedInternship.getSupervisorId());
        // dto.setSupervisor(supervisor);
        Internship internshipToUpdate = InternshipMapper.INSTANCE.dtoToInternship(dto);

        savedInternship.setInternshipname(internshipToUpdate.getInternshipname());
        //  savedInternship.setInternList(internshipToUpdate.getInternList());
        savedInternship.setCandidacyList(internshipToUpdate.getCandidacyList());
        savedInternship.setSupervisorId(internshipToUpdate.getSupervisorId());
        savedInternship.setSupervisor(internshipToUpdate.getSupervisor());
        return InternshipMapper.INSTANCE.internshipToDto(internshipRepository.save(savedInternship));
    }

    public List<InternshipDto> findAllInternshipsBySupervisorId(Long supervisorId) {

        // Vérifier si le superviseur existe
        supervisorRestClient.findSupervisorById(supervisorId);

        // Récupérer la liste des internships du superviseur
        List<Internship> internships = internshipRepository.findAllInternshipsBySupervisorId(supervisorId);
        Supervisor supervisor = supervisorRestClient.findSupervisorById(supervisorId);

        // Mapper les internships en DTOs
        List<InternshipDto> internshipDtos = new ArrayList<>();
        for (Internship internship : internships) {
            internship.setSupervisor(supervisor);
            internshipDtos.add(InternshipMapper.INSTANCE.internshipToDto(internship));
        }

        return internshipDtos;
    }
}
