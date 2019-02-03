package br.edu.gedaam.repository;

import br.edu.gedaam.model.Faculdade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaculdadeRepository  extends JpaRepository<Faculdade, Long> {

    Faculdade findById(long id);
}
