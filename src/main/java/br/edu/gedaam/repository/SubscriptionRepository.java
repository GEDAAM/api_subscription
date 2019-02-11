package br.edu.gedaam.repository;

import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Subscription findById(long id);

    List<Subscription> findBySemesterOrderByFrequentLastSemesterDescSimposiumPresentDescSubscriptionTimeStampDesc(Semester semester);
}
