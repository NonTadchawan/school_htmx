package org.acme.controller;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import org.acme.repository.StudentRepo;

@Path("/student")
public class StudentController extends HxController {
    @Inject
    StudentRepo studentRepo;
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance student();
    }
    @Path("/")
    public TemplateInstance student(){
        return Templates.student();
    }
}
