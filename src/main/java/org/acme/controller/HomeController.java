package org.acme.controller;

import io.quarkiverse.renarde.htmx.HxController;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HomeController extends HxController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance home();

        public static native TemplateInstance about();

        public static native TemplateInstance contact();
    }

    @Path("/")
    public TemplateInstance home() {
        return Templates.home();
    }

    public TemplateInstance about() {
        return Templates.about();
    }

    public TemplateInstance contact() {
        return Templates.contact();
    }
}
