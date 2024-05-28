package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Student;

@ApplicationScoped
public class StudentRepo implements PanacheRepository<Student> {
    public void delete(Long id) {
        delete("id", id);
    }
}
