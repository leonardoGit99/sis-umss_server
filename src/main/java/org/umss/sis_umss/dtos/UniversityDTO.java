package org.umss.sis_umss.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UniversityDTO {

    @JsonIgnore
    private Long id; // Solo para relacionar tablas, por lo tanto, no exponemos esta prop  mediante la anotacion: jsonIgnore
    private String uuid; //Se expone al front para evitar SQL injection
    private String code;
    private String name;

    /*
        Se tiene que crear un constructor vacio debido a que Jackson primero crea
        un json vacio y empieza a agregar propiedades mediante los getter y setters
    */
    public UniversityDTO() {

    }

    public UniversityDTO(String uuid, String code, String name) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
