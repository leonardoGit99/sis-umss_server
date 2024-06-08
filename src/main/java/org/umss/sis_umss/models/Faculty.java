package org.umss.sis_umss.models;

import java.util.Date;

public class Faculty {
    private Integer id;
    private Integer universityId;
    private String uuid;
    private String name;
    private String code;
    private Date createDate;

    public Faculty() {

    }

    public Faculty(Integer id, Integer universityId, String uuid, String name, String code, Date createDate) {
        this.id = id;
        this.universityId = universityId;
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
