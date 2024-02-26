package tn.cpg.internshipservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import tn.cpg.internshipservice.dto.CandidacyDto;
import tn.cpg.internshipservice.dto.InternDto;
import tn.cpg.internshipservice.entities.Candidacy;
import tn.cpg.internshipservice.entities.Intern;

@Mapper
public interface CandidacyMapper {
    CandidacyMapper INSTANCE = Mappers.getMapper(CandidacyMapper.class);
    CandidacyDto candidacyToDto(Candidacy candidacy);
    Candidacy dtoToCandidacy(CandidacyDto candidacyDto);

    /*@Mapping(target = "idCandidacy", ignore = true)//ensure id is not updated
    void updateCandidacyFromDto(CandidacyDto candidacyDto, @MappingTarget Candidacy candidacy);*/

}
