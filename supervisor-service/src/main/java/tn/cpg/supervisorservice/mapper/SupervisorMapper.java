package tn.cpg.supervisorservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.cpg.supervisorservice.dto.SupervisorDto;
import tn.cpg.supervisorservice.entities.Supervisor;

@Mapper
public interface SupervisorMapper {
    SupervisorMapper INSTANCE = Mappers.getMapper(SupervisorMapper.class);

    SupervisorDto supervisorToDto(Supervisor supervisor);

    Supervisor dtoToSupervisor(SupervisorDto supervisorDto);
}
