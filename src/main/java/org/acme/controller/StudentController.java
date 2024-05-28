package org.acme.controller;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.model.Student;
import org.acme.repository.StudentRepo;

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
    public void saveStudent(Student student){
        studentRepo.saveStudent(student);
    }
}
