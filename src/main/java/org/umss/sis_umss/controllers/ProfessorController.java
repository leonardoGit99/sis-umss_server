package org.umss.sis_umss.controllers;

import org.springframework.web.bind.annotation.*;
import org.umss.sis_umss.dtos.GroupDTO;
import org.umss.sis_umss.dtos.ProfessorDTO;
import org.umss.sis_umss.dtos.ScheduleDTO;
import org.umss.sis_umss.dtos.SubjectDTO;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    //Get all groups by a one professor
    @GetMapping("/{professorUuid}/groups")
    public List<GroupDTO> getAllGroups(@PathVariable String professorUuid) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setSubject(new SubjectDTO(UUID.randomUUID().toString(), "Intro a la programacion", "INTRO-CODE"));
        groupDTO.setSchedule(Collections.singletonList(new ScheduleDTO(DayOfWeek.MONDAY, "6:45", "8:15")));
        return Collections.singletonList(groupDTO);
    }

    //Get one professor
    @GetMapping("/{professorUuid}")
    public ProfessorDTO getOne(@PathVariable String professorUuid) {
        return new ProfessorDTO(professorUuid, "Juan Carlos", "Torres");
    }

    // Create professor
    @PostMapping
    public ProfessorDTO create(@RequestBody ProfessorDTO professor) {
        professor.setUuid(UUID.randomUUID().toString());
        return professor;
    }

    // Update professor
    @PutMapping("/{professorUuid}")
    public ProfessorDTO update(@PathVariable String professorUuid, @RequestBody ProfessorDTO professor) {
        return new ProfessorDTO(UUID.randomUUID().toString(),"Juan Carlos", "Perez");
    }

    // Delete professor
    @DeleteMapping("/{professorUuid}")
    public ProfessorDTO delete(@PathVariable String professorUuid) {
        //Logic: if professor doesn't belong a group
        return new ProfessorDTO(professorUuid,"Juan Carlos", "Torres");
    }
}
