package org.umss.sis_umss.dtos;

import org.springframework.stereotype.Component;
import org.umss.sis_umss.models.Faculty;

@Component
public class FacultyMapper {
    public FacultyDTO toDTO(Faculty faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setUuid(faculty.getUuid());
        facultyDTO.setCode(faculty.getCode());
        facultyDTO.setName(faculty.getName());
        return facultyDTO;
    }
}
