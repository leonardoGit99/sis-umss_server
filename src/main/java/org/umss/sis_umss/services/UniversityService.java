package org.umss.sis_umss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.umss.sis_umss.dtos.FacultyDTO;
import org.umss.sis_umss.dtos.FacultyMapper;
import org.umss.sis_umss.dtos.UniversityDTO;
import org.umss.sis_umss.dtos.UniversityMapper;
import org.umss.sis_umss.exceptions.NotFoundException;
import org.umss.sis_umss.models.Faculty;
import org.umss.sis_umss.models.University;
import org.umss.sis_umss.repositories.FacultyRepository;
import org.umss.sis_umss.repositories.UniversityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private UniversityMapper universityMapper;
    @Autowired
    private FacultyMapper facultyMapper;

    public List<UniversityDTO> getAllUniversities() {
        return universityRepository.findAll()
                .stream()
                .map(university -> universityMapper.toDTO(university))
                .collect(Collectors.toList());
    }

    public UniversityDTO getUniversity(String universityUuid) {
        University university = universityRepository.findOneByUuid(universityUuid);
        if (university == null) {
            throw new NotFoundException("University", universityUuid);
        }

        return universityMapper.toDTO(universityRepository.findOneByUuid(universityUuid));
    }

    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
        University university = universityMapper.getUniversity(universityDTO);
        return universityMapper.toDTO(universityRepository.save(university));
    }

    public List<FacultyDTO> getFaculties(String universityUuid) {
        University university = universityRepository.findOneByUuid(universityUuid);

        if (university == null) {
            throw new NotFoundException("University", universityUuid);
        }

        List<Faculty> faculties = facultyRepository.getByUniversityId(university.getId());
        return faculties
                .stream()
                .map(faculty -> facultyMapper.toDTO(faculty))
                .collect(Collectors.toList());
    }
}
