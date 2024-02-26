package tn.cpg.internshipservice.service;

import org.springframework.stereotype.Service;
import tn.cpg.internshipservice.dto.InternshipDto;
import tn.cpg.internshipservice.entities.Intern;
import tn.cpg.internshipservice.entities.Internship;
import tn.cpg.internshipservice.mapper.InternMapper;
import tn.cpg.internshipservice.mapper.InternshipMapper;
import tn.cpg.internshipservice.repository.InternshipRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InternshipService implements CrudService<InternshipDto> {
    private final InternshipRepository internshipRepository;

    public InternshipService(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    @Override
    public List<InternshipDto> findAll() {
        List<InternshipDto> internshipDtoList = new ArrayList<>();
        internshipRepository.findAll().forEach(internship -> internshipDtoList.add(InternshipMapper.INSTANCE.internshipToDto(internship)));
        return internshipDtoList;
    }

    @Override
    public Optional<InternshipDto> findById(Long id) {
        Optional<Internship> internOptional = internshipRepository.findById(id);
        return internOptional.map(InternshipMapper.INSTANCE::internshipToDto);
    }

    @Override
    public InternshipDto save(InternshipDto dto) {
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
        Internship internshipToUpdate = InternshipMapper.INSTANCE.dtoToInternship(dto);
        savedInternship.setInternshipname(internshipToUpdate.getInternshipname());
      //  savedInternship.setInternList(internshipToUpdate.getInternList());
        savedInternship.setCandidacyList(internshipToUpdate.getCandidacyList());
        return InternshipMapper.INSTANCE.internshipToDto(internshipRepository.save(savedInternship));
    }
}
