package br.edu.gedaam.repository;

import br.edu.gedaam.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

    Semester findById(long id);

}
