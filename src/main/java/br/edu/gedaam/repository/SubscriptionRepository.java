package br.edu.gedaam.repository;

import br.edu.gedaam.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Subscription findById(long id);

}
