package tn.cpg.internshipservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.cpg.internshipservice.dto.InternDto;
import tn.cpg.internshipservice.dto.InternshipDto;
import tn.cpg.internshipservice.entities.Internship;

@Mapper
public interface InternshipMapper {

    InternshipMapper INSTANCE = Mappers.getMapper(InternshipMapper.class);
    InternshipDto internshipToDto(Internship internship);
    Internship dtoToInternship(InternshipDto internshipDto);
}
