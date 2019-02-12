package br.edu.gedaam.repository;

import br.edu.gedaam.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
    
    University findById(long id);
}
