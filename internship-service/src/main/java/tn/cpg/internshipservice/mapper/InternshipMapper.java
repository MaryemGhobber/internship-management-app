package tn.cpg.internshipservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import tn.cpg.internshipservice.dto.InternDto;
import tn.cpg.internshipservice.dto.InternshipDto;
import tn.cpg.internshipservice.entities.Internship;

@Mapper
public interface InternshipMapper {

    InternshipMapper INSTANCE = Mappers.getMapper(InternshipMapper.class);
    InternshipDto internshipToDto(Internship internship);
    Internship dtoToInternship(InternshipDto internshipDto);
    //update the existing intern entity with data from InternDto
    /*@Mapping(target = "idInternship", ignore = true)//ensure id is not updated
    void updateInternshipFromDto(InternshipDto internshipDto, @MappingTarget Internship internship);*/
}
