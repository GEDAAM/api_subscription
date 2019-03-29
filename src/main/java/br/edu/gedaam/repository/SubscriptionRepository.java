package br.edu.gedaam.repository;

import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Subscription findById(long id);

    Subscription findBySemesterAndPerson(Semester semester, Person person);

    List<Subscription> findBySemesterOrderById(Semester semester);

    List<Subscription> findAllByOrderById();

}
