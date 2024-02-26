package tn.cpg.internshipservice.service;

import org.springframework.stereotype.Service;
import tn.cpg.internshipservice.dto.CandidacyDto;
import tn.cpg.internshipservice.dto.InternDto;
import tn.cpg.internshipservice.entities.Candidacy;
import tn.cpg.internshipservice.entities.Intern;
import tn.cpg.internshipservice.mapper.CandidacyMapper;
import tn.cpg.internshipservice.mapper.InternMapper;
import tn.cpg.internshipservice.repository.CandidacyRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidacyService implements CrudService<CandidacyDto> {
    private final CandidacyRepository candidacyRepository;

    public CandidacyService(CandidacyRepository candidacyRepository) {
        this.candidacyRepository = candidacyRepository;
    }

    @Override
    public List<CandidacyDto> findAll() {
        List<CandidacyDto> candidacyDtoList = new ArrayList<>();
        candidacyRepository.findAll().forEach(candidacy -> candidacyDtoList.add(CandidacyMapper.INSTANCE.candidacyToDto(candidacy)));
        return candidacyDtoList;
    }

    @Override
    public Optional<CandidacyDto> findById(Long id) {
        Optional<Candidacy> candidacyOptional = candidacyRepository.findById(id);
        return candidacyOptional.map(CandidacyMapper.INSTANCE::candidacyToDto);
    }

    @Override
    public CandidacyDto save(CandidacyDto dto) {
        dto.setDateSubmission(LocalDate.now());
        Candidacy candidacy = CandidacyMapper.INSTANCE.dtoToCandidacy(dto);

        return CandidacyMapper.INSTANCE.candidacyToDto(candidacyRepository.save(candidacy));
    }

    @Override
    public void delete(Long id) {
        candidacyRepository.deleteById(id);
    }

    //pas d'update
    @Override
    public CandidacyDto update(Long id, CandidacyDto dto) {
        dto.setDateSubmission(LocalDate.now());
        Candidacy savedCandidacy = candidacyRepository.findById(id).orElseThrow();
        Candidacy candidacyToUpdate = CandidacyMapper.INSTANCE.dtoToCandidacy(dto);
        savedCandidacy.setIntern(candidacyToUpdate.getIntern());
        savedCandidacy.setInternship(candidacyToUpdate.getInternship());


        return CandidacyMapper.INSTANCE.candidacyToDto(candidacyRepository.save(savedCandidacy));
    }
}
