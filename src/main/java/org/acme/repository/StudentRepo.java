package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Student;

@ApplicationScoped
public class StudentRepo implements PanacheRepository<Student> {
    public Student findById(Long id) {
        return find("id", id).firstResult();
    }

    public void delete(Long id) {
        delete("id", id);
    }

    public void saveStudent(Student student) {
        persist(student);
    }
}
