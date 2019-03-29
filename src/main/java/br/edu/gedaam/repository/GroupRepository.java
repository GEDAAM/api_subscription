package br.edu.gedaam.repository;

import br.edu.gedaam.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findById(long id);
    Group findByTheme(String theme);
}
