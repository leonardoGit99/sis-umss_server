package org.umss.sis_umss.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.umss.sis_umss.dtos.UniversityDTO;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class UniversityController {

    // Create
    @PostMapping("/universities")
    public UniversityDTO create(@RequestBody UniversityDTO university) {
        university.setUuid(UUID.randomUUID().toString());
        return university;
    }

    // Read
    @GetMapping("/universities")
    public List<UniversityDTO> getAll() {
        return Collections.singletonList(new UniversityDTO(UUID.randomUUID().toString(), "UMSS", "Universidad Mayor de San Simon"));
    }

    //Read One
    @GetMapping("/universities/{universityUuid}")
    public UniversityDTO getOne(@PathVariable String universityUuid) {
        return new UniversityDTO(universityUuid, "UMSS", "Universidad Mayor de San Simon");
    }

    // Update
    @PutMapping("/universities/{universityUuid}")
    public UniversityDTO update(@PathVariable String universityUuid, @RequestBody UniversityDTO university) {
        return new UniversityDTO(universityUuid, "UMSS", "Universidad Mayor de San Simon 2");
    }

    //Delete
    @DeleteMapping("/universities/{universityUuid}")
    public UniversityDTO delete(@PathVariable String universityUuid) {
        return new UniversityDTO(universityUuid, "UMSS", "Universidad Mayor de San Simon");
    }

}
