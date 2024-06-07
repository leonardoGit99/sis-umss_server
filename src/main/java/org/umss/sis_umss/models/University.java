package org.umss.sis_umss.models;

import java.util.Date;

public class University {
    private Integer id;
    private String uuid;
    private String name;
    private String code;
    private Date createDate;

    public University() {

    }

    public University(Integer id, String uuid, String name, String code, Date createDate) {
        this.id = id;
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
