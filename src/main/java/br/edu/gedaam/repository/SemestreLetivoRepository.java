package br.edu.gedaam.repository;

import br.edu.gedaam.model.SemestreLetivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreLetivoRepository extends JpaRepository<SemestreLetivo, Long> {

    SemestreLetivo findById(long id);

}
