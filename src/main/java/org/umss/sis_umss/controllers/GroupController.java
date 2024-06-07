package org.umss.sis_umss.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.umss.sis_umss.dtos.GroupDTO;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    // Delete group
    @DeleteMapping("/{groupUuid}")
    public GroupDTO delete(@PathVariable String groupUuid) {
        return new GroupDTO(groupUuid, "Grupo-1A-CODE", "1A");
    }
}
