package org.acme.controller;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.StudentDto;
import org.acme.mapper.StudentMapper;
import org.acme.model.Student;
import org.acme.repository.StudentRepo;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

import java.util.List;

@Path("/student")
public class StudentController extends HxController {
    @Inject
    StudentRepo studentRepo;
    @Inject
    StudentMapper mapper;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance student(List<Student> students);

        public static native TemplateInstance student$list(List<Student> students);

        public static native TemplateInstance modal(Student student, String mode);
    }

    @Path("/")
    @Blocking
    public TemplateInstance student() {
        if (isHxRequest()) {
            return Templates.student$list(studentRepo.listAll());
        }
        return Templates.student(studentRepo.listAll());
    }

    @GET
    @Path("/modal")
    public TemplateInstance modal() {
        return Templates.modal(null, "create");
    }

    @GET
    @Path("view/{id}")
    @Blocking
    public TemplateInstance view(Long id) {
        return Templates.modal(studentRepo.findById(id), "view");
    }

    @GET
    @Path("update/{id}")
    @Blocking
    public TemplateInstance update(Long id) {
        return Templates.modal(studentRepo.findById(id), "update");
    }

    /*   @POST
       @Path("/")
       @Transactional
       public void saveStudent(@RestForm("fName") String fName, @RestForm("lName") String lName, @RestForm("age") Integer age, @RestForm("degree") String degree) {
           Student student = new Student();
           student.setfName(fName);
           student.setlName(lName);
           student.setAge(age);
           student.setDegree(degree);
           studentRepo.persist(student);
       }*/
    @POST
    @Path("/")
    @Transactional
    public void saveStudent(@BeanParam StudentDto student) {
        studentRepo.persist(mapper.toEntity(student));
    }

    @DELETE
    @Path("/{id}")
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

}

