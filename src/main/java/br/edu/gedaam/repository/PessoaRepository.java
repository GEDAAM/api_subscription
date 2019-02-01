package br.edu.gedaam.repository;

import br.edu.gedaam.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findById(long id);
}
