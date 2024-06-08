package org.umss.sis_umss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.umss.sis_umss.dtos.FacultyDTO;
import org.umss.sis_umss.dtos.UniversityDTO;
import org.umss.sis_umss.models.University;
import org.umss.sis_umss.services.UniversityService;

import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<UniversityDTO> create(@RequestBody UniversityDTO university) throws URISyntaxException {
    UniversityDTO universityDTO = universityService.saveUniversity(university);
//        return new ResponseEntity(universityDTO, HttpStatus.CREATED); // Wrap the response with code 201 CREATED

        URI uri = new URI("/universities/" + universityDTO.getUuid()); // Use this to send a location when the client doesn't knows the context of API
        return ResponseEntity
                .created(uri)
                .body(universityDTO);
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
        List<FacultyDTO> facultyDTOList = this.universityService.getFaculties(universityUuid);
//        return Collections.singletonList(new FacultyDTO(UUID.randomUUID().toString(), "FCYT", "Facultad de Ciencias y Tecnologia"));
        return facultyDTOList;
    }
}
