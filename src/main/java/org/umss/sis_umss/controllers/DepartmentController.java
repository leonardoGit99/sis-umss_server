package org.umss.sis_umss.controllers;

import org.springframework.web.bind.annotation.*;
import org.umss.sis_umss.dtos.DepartmentDTO;
import org.umss.sis_umss.dtos.FacultyDTO;
import org.umss.sis_umss.dtos.SubjectDTO;

import java.util.Collections;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    // Get one department
    @GetMapping("/{departmentUuid}")
    public DepartmentDTO getOne(@PathVariable String departmentUuid) {
        return new DepartmentDTO(departmentUuid, "Inf-Sis", "Informatica y Sistemas");
    }

    // Create department
    @PostMapping
    public DepartmentDTO create(@RequestBody DepartmentDTO department) {
        department.setUuid(UUID.randomUUID().toString());
        return department;
    }

    // Update department
    @PutMapping("{departmentUuid}")
    public DepartmentDTO update(@PathVariable String departmentUuid, @RequestBody DepartmentDTO department) {
        return new DepartmentDTO(UUID.randomUUID().toString(), "Inf-Sis","Informatica y Sistemas 2");
    }

    // Delete department
    @DeleteMapping("{departmentUuid}")
    public DepartmentDTO delete(@PathVariable String departmentUuid) {
        return new DepartmentDTO(departmentUuid, "Inf-Sis","Informatica y Sistemas");
    }

    // Get all subjects by one department
    @GetMapping("/{departmentUuid}/subjects")
    public List<SubjectDTO> getAllSubjectsByDepartment(){
        return Collections.singletonList(new SubjectDTO(UUID.randomUUID().toString(), "Intro a la programacion", "INTRO-CODE"));
    }
}
