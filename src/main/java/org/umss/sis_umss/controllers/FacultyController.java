package org.umss.sis_umss.controllers;

import org.springframework.web.bind.annotation.*;
import org.umss.sis_umss.dtos.DepartmentDTO;
import org.umss.sis_umss.dtos.FacultyDTO;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    // Get One Faculty
    @GetMapping("/{facultyUuid}")
    public FacultyDTO getOne(@PathVariable String facultyUuid) {
        return new FacultyDTO(facultyUuid, "FCYT", "Facultad de Ciencias y Tecnología");
    }

    // Create a faculty
    @PostMapping
    public FacultyDTO create(@RequestBody FacultyDTO faculty) {
        faculty.setUuid(UUID.randomUUID().toString());
        return faculty;
    }

    // Update a faculty
    @PutMapping("/{facultyUuid}")
    public FacultyDTO update(@PathVariable String facultyUuid, @RequestBody FacultyDTO faculty){
        return new FacultyDTO(facultyUuid, "FCYT", "Facultad de Ciencias y Tecnología 2");
    }

    // Delete a faculty
    @DeleteMapping("/{facultyUuid}")
    public FacultyDTO delete(@PathVariable  String facultyUuid) {
        return new FacultyDTO(facultyUuid, "FCYT", "Facultad de Ciencias y Tecnología");
    }

    // Get all Departments by one faculty
    @GetMapping("/{facultyUuid}/departments")
    public List<DepartmentDTO> getDepartmentsByFaculty(@PathVariable String facultyUuid) {
        return Collections.singletonList(new DepartmentDTO(UUID.randomUUID().toString(), "Inf-Sis", "Informatica y Sistemas"));
    }

}

