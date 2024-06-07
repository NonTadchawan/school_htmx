package org.acme.dto;

import org.acme.model.Student;
import org.jboss.resteasy.reactive.RestForm;

import java.io.Serializable;

/**
 * DTO for {@link Student}
 */
public class StudentDto implements Serializable {
    private Long id;
    @RestForm("fName")
    private String fName;
    @RestForm("lName")
    private String lName;
    @RestForm
    private Integer age;
    @RestForm
    private String degree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}