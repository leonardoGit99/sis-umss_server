package org.umss.sis_umss.dtos;

import java.util.List;

public class GroupDTO {
    private String uuid; //Se expone al front para evitar SQL injection
    private String code;
    private String name;
    private ProfessorDTO professor;
    private List<ScheduleDTO> schedules;
    private SubjectDTO subject;
    /*
        Se tiene que crear un constructor vacio debido a que Jackson primero crea
        un json vacio y empieza a agregar propiedades mediante los getter y setters
    */
    public GroupDTO() {

    }

    public GroupDTO(String uuid, String code, String name) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public List<ScheduleDTO> getSchedules() {
        return schedules;
    }

    public void setSchedule(List<ScheduleDTO> schedules) {
        this.schedules = schedules;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }
}
