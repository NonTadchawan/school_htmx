package org.acme.controller;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.model.Student;
import org.acme.repository.StudentRepo;
import org.jboss.resteasy.reactive.RestForm;

import java.util.List;

@Path("/student")
public class StudentController extends HxController {
    @Inject
    StudentRepo studentRepo;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance student(List<Student> students);
        public static native TemplateInstance student$list(List<Student> students);
        public static native TemplateInstance modal();
    }

    @Path("/")
    @Blocking
    public TemplateInstance student() {
        if(isHxRequest()){
            return Templates.student$list(studentRepo.listAll());
        }
        return Templates.student(studentRepo.listAll());
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

}

