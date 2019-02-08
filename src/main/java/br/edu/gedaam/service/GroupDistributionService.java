package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Student;
import br.edu.gedaam.model.Subscription;
import br.edu.gedaam.repository.StudentRepository;
import br.edu.gedaam.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupDistributionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private StudentRepository studentRepository;


    public List<Subscription> makeIt() {

        Sort sortByTimeStamp = new Sort(Sort.Direction.DESC, "subscriptionTimeStamp");
        List<Subscription> subscriptions = subscriptionRepository.findAll(sortByTimeStamp);

        List<Subscription> surplus = new ArrayList<>();

        for (Subscription subscription : subscriptions) {

            if (subscription.getGroupOption1() != null) {
                Group group1 = subscription.getGroupOption1();

                if (group1.getStudents().size() < group1.getMaxOfStudents()) {
                    Student student = new Student(subscription.getPerson(), group1);
                    studentRepository.save(student);
                } else {
                    if ((subscription.getGroupOption2() != null))  {
                        Group group2 = subscription.getGroupOption2();
                        if (group2.getStudents().size() < group2.getMaxOfStudents()) {
                            Student student = new Student(subscription.getPerson(), group2);
                            studentRepository.save(student);
                        }
                        else {
                            surplus.add(subscription);
                        }

                    }
                    else {
                        surplus.add(subscription);
                    }
                }

            }
        }

        return surplus;
    }
}
