package br.edu.gedaam.repository;

import br.edu.gedaam.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findById(long id);

    Person findByRegistrationNumber(String registrationNumber);
}
