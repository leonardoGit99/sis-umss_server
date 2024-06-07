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
@RequestMapping("/subjects")
public class SubjectController {

    //Get one subject
    @GetMapping("/{subjectUuid}")
    public SubjectDTO getOneSubject(@PathVariable String subjectUuid) {
        return new SubjectDTO(subjectUuid, "Intro a la programacion", "INTRO-CODE");
    }

    //Get all groups by one subject
    @GetMapping("/{subjectUuid}/groups")
    public List<GroupDTO> getAll() {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setProfessor(new ProfessorDTO(UUID.randomUUID().toString(), "Juan Carlos", "Garcia"));
        groupDTO.setSchedule(Collections.singletonList(new ScheduleDTO(DayOfWeek.MONDAY, "6:45", "8:15")));
        return Collections.singletonList(groupDTO);
    }


    // Get one group by one subject
    @GetMapping("/{subjectUuid}/groups/{groupUuid}")
    public GroupDTO getOne(@PathVariable String subjectUuid, @PathVariable String groupUuid){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setProfessor(new ProfessorDTO(UUID.randomUUID().toString(), "Juan Carlos", "Garcia"));
        groupDTO.setSchedule(Collections.singletonList(new ScheduleDTO(DayOfWeek.MONDAY, "6:45", "8:15")));
        return groupDTO;
    }

    //Create a group into one subject
    @PostMapping("/{subjectUuid}/groups")
    public GroupDTO createGroup(@PathVariable String subjectUuid, @RequestBody GroupDTO group) {
        group.setUuid(UUID.randomUUID().toString());
        group.setProfessor(new ProfessorDTO(group.getProfessor().getUuid(), "Juan Carlos", "Garcia"));
        group.setSubject(new SubjectDTO(group.getSubject().getUuid(), "Intro a la programacion", "INTRO-CODE"));
        return group;
    }

    //Create subject
    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO subject) {
        subject.setUuid(UUID.randomUUID().toString());
        return subject;
    }

    // Update subject
    @PutMapping("{subjectUuid}")
    public SubjectDTO updateSubject(@PathVariable String subjectUuid, @RequestBody SubjectDTO subject) {
        return new SubjectDTO(UUID.randomUUID().toString(), "Intro a la programacion 2", "INTRO-CODE");
    }

    // Delete subject
    @DeleteMapping("{subjectUuid}")
    public SubjectDTO deleteSubject(@PathVariable String subjectUuid) {
        //Logic: if subject doesn't belong  a group, so...
        return new SubjectDTO(subjectUuid, "Intro a la programacion ", "INTRO-CODE");
    }

    // Get all professors by subject
    @GetMapping("{subjectUuid}/professors")
    public List<ProfessorDTO> getAllProfessorsBySubject(@PathVariable String subjectUuid) {
        return Collections.singletonList(new ProfessorDTO(UUID.randomUUID().toString(), "Juan Carlos", "Torres"));
    }
}
