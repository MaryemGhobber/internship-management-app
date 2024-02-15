package tn.cpg.internshipservice.service;

import org.springframework.stereotype.Service;
import tn.cpg.internshipservice.dto.InternDto;
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
        List<InternDto> internDtoList =new ArrayList<>();
        internRepository.findAll().forEach(intern -> internDtoList.add(InternMapper.INSTANCE.internToDto(intern)));
        return internDtoList;
    }

    @Override
    public Optional<InternDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public InternDto save(InternDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public InternDto update(Long id, InternDto dto) {
        return null;
    }
}
