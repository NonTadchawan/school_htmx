package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Teacher;

@ApplicationScoped
public class TeacherRepo implements PanacheRepository<Teacher> {
    public Teacher findById(Long id) {
        return find("id", id).firstResult();
    }

    public void delete(Long id) {
        delete("id", id);
    }

    public void saveTeacher(Teacher teacher) {
        persist(teacher);
    }
}
