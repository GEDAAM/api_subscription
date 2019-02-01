package br.edu.gedaam.repository;

import br.edu.gedaam.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository  extends JpaRepository<Turma, Long> {

    Turma findById(long id);
}
