package org.umss.sis_umss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.umss.sis_umss.dtos.FacultyDTO;
import org.umss.sis_umss.dtos.UniversityDTO;
import org.umss.sis_umss.services.UniversityService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    // Get all universities
    @GetMapping
    public List<UniversityDTO> getAll() {
       return universityService.getAllUniversities();
    }

    // Create university
    @PostMapping
    public UniversityDTO create(@RequestBody UniversityDTO university) {
        return universityService.saveUniversity(university);
    }

    //Get one univesity
    @GetMapping("/{universityUuid}")
    public UniversityDTO getOne(@PathVariable String universityUuid) {
       return universityService.getUniversity(universityUuid);
    }

    // Update univesity
    @PutMapping("/{universityUuid}")
    public UniversityDTO update(@PathVariable String universityUuid, @RequestBody UniversityDTO university) {
        return new UniversityDTO(UUID.randomUUID().toString(), "UMSS", "Universidad Mayor de San Simon 2");
    }

    //Delete university
    @DeleteMapping("/{universityUuid}")
    public UniversityDTO delete(@PathVariable String universityUuid) {
        return new UniversityDTO(universityUuid, "UMSS", "Universidad Mayor de San Simon");
    }

    //Get falculties by one univesity
    @GetMapping("/{universityUuid}/faculties")
    public List<FacultyDTO> getAllFaculties(@PathVariable String universityUuid){
        return Collections.singletonList(new FacultyDTO(UUID.randomUUID().toString(), "FCYT", "Facultad de Ciencias y Tecnologia"));
    }
}
