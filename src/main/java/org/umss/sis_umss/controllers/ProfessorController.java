package org.umss.sis_umss.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.umss.sis_umss.dtos.GroupDTO;
import org.umss.sis_umss.dtos.ScheduleDTO;
import org.umss.sis_umss.dtos.SubjectDTO;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class ProfessorController {
    @GetMapping("/professors/{professorUuid}/groups")
    public List<GroupDTO> getAll(@PathVariable String professorUuid) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setSubject(new SubjectDTO(UUID.randomUUID().toString(), "Intro a la programacion", "INTRO-CODE"));
        groupDTO.setSchedule(Collections.singletonList(new ScheduleDTO(DayOfWeek.MONDAY, "6:45", "8:15")));
        return Collections.singletonList(groupDTO);
    }
}
