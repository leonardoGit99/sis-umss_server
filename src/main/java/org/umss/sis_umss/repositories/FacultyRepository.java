package org.umss.sis_umss.repositories;

import org.springframework.stereotype.Component;
import org.umss.sis_umss.models.Faculty;
import org.umss.sis_umss.models.University;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FacultyRepository {
    private static List<Faculty> facultyList = new ArrayList<>();
    private static int idCounter;

    static {
        idCounter = 300;
        facultyList.add(new Faculty(100, 1, UUID.randomUUID().toString(), "Facultad de Ciencias y Tecnologia", "FCYT", new Date()));
        facultyList.add(new Faculty(200, 1, UUID.randomUUID().toString(), "Facultad de Humanidades y Ciencias Sociales", "FHCS", new Date()));
        facultyList.add(new Faculty(1000, 2, UUID.randomUUID().toString(), "Facultad de Ciencias Exactas", "FCE", new Date()));
    }


    public List<Faculty> getByUniversityId(Integer universityId) {
        return facultyList
                .stream()
                .filter(faculty -> faculty.getUniversityId() == universityId)
                .collect(Collectors.toList());
    }
}
