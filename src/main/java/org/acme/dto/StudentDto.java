package org.acme.dto;

import org.acme.model.Student;
import org.jboss.resteasy.reactive.RestForm;

import java.io.Serializable;

/**
 * DTO for {@link Student}
 */
public class StudentDto implements Serializable {
    private Long id;
    @RestForm
    private String firstName;
    @RestForm
    private String lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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