package org.umss.sis_umss.controllers;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.umss.sis_umss.dtos.GroupDTO;
import org.umss.sis_umss.dtos.ProfessorDTO;
import org.umss.sis_umss.dtos.ScheduleDTO;
import org.umss.sis_umss.dtos.SubjectDTO;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class SubjectController {

    @GetMapping("/subjects/{subjectUuid}/groups")
    public List<GroupDTO> getAll() {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setProfessor(new ProfessorDTO(UUID.randomUUID().toString(), "Juan Carlos", "Garcia"));
        groupDTO.setSchedule(Collections.singletonList(new ScheduleDTO(DayOfWeek.MONDAY, "6:45", "8:15")));
        return Collections.singletonList(groupDTO);
    }

    @PostMapping("/subjects/{subjectUuid}/groups")
    public GroupDTO create(@PathVariable String subjectUuid, @RequestBody GroupDTO group) {
        group.setUuid(UUID.randomUUID().toString());
        group.setProfessor(new ProfessorDTO(group.getProfessor().getUuid(), "Juan Carlos", "Garcia"));
        group.setSubject(new SubjectDTO(group.getSubject().getUuid(), "Intro a la programacion", "INTRO-CODE"));
        return group;
    }

    @GetMapping("/subjects/{subjectUuid}/groups/{groupUuid}")
    public GroupDTO getOne(@PathVariable String subjectUuid, @PathVariable String groupUuid){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setProfessor(new ProfessorDTO(UUID.randomUUID().toString(), "Juan Carlos", "Garcia"));
        groupDTO.setSchedule(Collections.singletonList(new ScheduleDTO(DayOfWeek.MONDAY, "6:45", "8:15")));
        return groupDTO;
    }
}
