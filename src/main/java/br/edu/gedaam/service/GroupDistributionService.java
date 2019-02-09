package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Student;
import br.edu.gedaam.model.Subscription;
import br.edu.gedaam.model.enums.SubscriptionStatus;
import br.edu.gedaam.repository.GroupRepository;
import br.edu.gedaam.repository.StudentRepository;
import br.edu.gedaam.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupDistributionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;


    public List<Subscription> makeIt() {

        Sort sortByTimeStamp = new Sort(Sort.Direction.DESC, "subscriptionTimeStamp");
        List<Subscription> subscriptions = subscriptionRepository.findAll(sortByTimeStamp);
        // TODO: filtrar por status somente as que precisam ser processadas e filtrar por semestre
        // TODO: ordenar por frequencia e por presença no simpósio


        for (Subscription subscription : subscriptions) {

            if (null != subscription.getGroupOption1()) {
                Group group1 = groupRepository.findById(subscription.getGroupOption1().getId());

                if (!group1.isFull()) {
                    Student student = new Student(subscription.getPerson(), group1);
                    studentRepository.saveAndFlush(student);
                    subscription.setStatus(SubscriptionStatus.GOT_FIRST_OPTION);
                } else {
                    if ((null != subscription.getGroupOption2()))  {
                        Group group2 = groupRepository.findById(subscription.getGroupOption2().getId());
                        System.out.println("Group: " + group1.getId() + " Status: " + group1.isFull());
                        if (!group2.isFull()) {
                            Student student = new Student(subscription.getPerson(), group2);
                            studentRepository.saveAndFlush(student);
                            subscription.setStatus(SubscriptionStatus.GOT_SECOND_OPTION);
                        }
                        else {
                            subscription.setStatus(SubscriptionStatus.SURPLUS);
                        }

                    }
                    else {
                        subscription.setStatus(SubscriptionStatus.SURPLUS);
                    }
                }

            } else  {
                subscription.setStatus(SubscriptionStatus.NO_OPTION_CHOSEN);
            }
            subscriptionRepository.saveAndFlush(subscription);
        }
        return subscriptionRepository.findAll();
    }
}
