package br.edu.gedaam.repository;

import br.edu.gedaam.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
