package org.umss.sis_umss.dtos;

public class SubjectDTO {
    private String uuid;
    private String name;
    private String code;

    public SubjectDTO() {

    }

    public SubjectDTO(String uuid, String name, String code) {
        this.uuid = uuid;
        this.name = name;
        this.code = code;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
