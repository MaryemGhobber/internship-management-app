package tn.cpg.internshipservice.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;
import tn.cpg.internshipservice.dto.InternDto;
import tn.cpg.internshipservice.entities.Intern;

@Mapper
public interface InternMapper {
    InternMapper INSTANCE = Mappers.getMapper(InternMapper.class);

    InternDto internToDto(Intern intern);

    Intern dtoToIntern(InternDto internDto);
  /*  //update the existing intern entity with data from InterDto
    @Mapping(target = "id", ignore = true)//ensure id is not updated
    void updateInternFromDto(InternDto internDto, @MappingTarget Intern intern);*/


}
