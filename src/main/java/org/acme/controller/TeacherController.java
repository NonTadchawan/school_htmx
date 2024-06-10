package org.acme.controller;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.acme.repository.TeacherRepo;

@Path("/teacher")
public class TeacherController extends HxController {
    @Inject
    TeacherRepo teacherRepo;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance teacher();

        public static native TemplateInstance registerTeacher();
       // public static native TemplateInstance modal();
    }

    @GET
    @Path("/")
    public TemplateInstance teacher() {
        return Templates.teacher();
    }

    @GET
    @Path("/new")
    public TemplateInstance newTeacher() {
        return Templates.registerTeacher();
    }
}
