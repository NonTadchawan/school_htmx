package org.acme.controller;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Student;
import org.acme.repository.StudentRepo;
import org.jboss.resteasy.reactive.RestForm;

@Path("/student")
public class StudentController extends HxController {
    @Inject
    StudentRepo studentRepo;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance student();

        public static native TemplateInstance modal();
    }

    @Path("/")
    public TemplateInstance student() {
        return Templates.student();
    }

    @GET
    @Path("/modal")
    public TemplateInstance modal() {
        return Templates.modal();
    }

    @POST
    @Path("/")
    public void saveStudent(@RestForm("fName") String fName, @RestForm("lName") String lName, @RestForm("age") Integer age, @RestForm("degree") String degree) {
        Student student = new Student();
        student.setfName(fName);
        student.setlName(lName);
        student.setAge(age);
        student.setDegree(degree);
        studentRepo.persist(student);
    }
/*    @POST
    @Path("/")
    public void saveStudent(Student student) {
        studentRepo.persist(student);
    }*/
}

