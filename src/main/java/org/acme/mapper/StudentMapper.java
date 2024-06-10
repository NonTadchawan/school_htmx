package org.acme.mapper;

import org.acme.dto.StudentDto;
import org.acme.model.Student;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.CDI)
public interface StudentMapper {
    Student toEntity(StudentDto studentDto);
}