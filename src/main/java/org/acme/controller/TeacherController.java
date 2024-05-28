package org.acme.controller;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.acme.repository.TeacherRepo;

@Path("/teacher")
public class TeacherController {
    @Inject
    TeacherRepo teacherRepo;
    @Inject
    Template teacher;

    @GET
    public TemplateInstance teacher(){
        return teacher.instance();
    }
}
