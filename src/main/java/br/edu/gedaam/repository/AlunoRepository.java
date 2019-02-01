package br.edu.gedaam.repository;

import br.edu.gedaam.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository  extends JpaRepository<Aluno, Long> {
}
