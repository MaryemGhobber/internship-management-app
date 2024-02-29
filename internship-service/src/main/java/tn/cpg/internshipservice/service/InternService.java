package tn.cpg.internshipservice.service;

import org.springframework.stereotype.Service;
import tn.cpg.internshipservice.dto.InternDto;
import tn.cpg.internshipservice.entities.Intern;
import tn.cpg.internshipservice.mapper.InternMapper;
import tn.cpg.internshipservice.repository.InternRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InternService implements CrudService<InternDto> {
    private final InternRepository internRepository;

    public InternService(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    @Override
    public List<InternDto> findAll() {
        List<InternDto> internDtoList = new ArrayList<>();
        internRepository.findAll().forEach(intern -> internDtoList.add(InternMapper.INSTANCE.internToDto(intern)));
        return internDtoList;
    }

    @Override
    public Optional<InternDto> findById(Long id) {
        Optional<Intern> internOptional = internRepository.findById(id);
        return internOptional.map(InternMapper.INSTANCE::internToDto);
    }

    @Override
    public InternDto save(InternDto dto) {
        Intern intern = InternMapper.INSTANCE.dtoToIntern(dto);
        return InternMapper.INSTANCE.internToDto(internRepository.save(intern));
    }

    @Override
    public void delete(Long id) {
        internRepository.deleteById(id);
    }

    @Override
    public InternDto update(Long id, InternDto dto) {
       Intern savedIntern = internRepository.findById(id).orElseThrow();
        Intern internToUpdate = InternMapper.INSTANCE.dtoToIntern(dto);
        savedIntern.setFirstname(internToUpdate.getFirstname());
        savedIntern.setLastname(internToUpdate.getLastname());
        savedIntern.setCin(internToUpdate.getCin());
        savedIntern.setMail(internToUpdate.getMail());
        savedIntern.setPhoneNumber(internToUpdate.getPhoneNumber());
        savedIntern.setBirthdate(internToUpdate.getBirthdate());
        savedIntern.setLevel(internToUpdate.getLevel());
        savedIntern.setClassLevel(internToUpdate.getClassLevel());
        savedIntern.setInternship(internToUpdate.getInternship());
        //savedIntern.setCandidacyList(internToUpdate.getCandidacyList());

        return InternMapper.INSTANCE.internToDto(internRepository.save(savedIntern));
    }
}
