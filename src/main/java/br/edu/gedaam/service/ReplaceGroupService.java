package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.Subscription;
import br.edu.gedaam.model.University;
import br.edu.gedaam.model.enums.SubscriptionStatus;
import br.edu.gedaam.repository.GroupRepository;
import br.edu.gedaam.repository.PersonRepository;
import br.edu.gedaam.repository.SubscriptionRepository;
import br.edu.gedaam.util.FileLocation;
import br.edu.gedaam.util.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReplaceGroupService extends FileReader {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    GroupRepository groupRepository;


    private Map<String, University> universities = new HashMap<>();
    private Semester semester;

    public Semester replace(Semester semester) {
        this.semester = semester;
        readFile(FileLocation.REPLACE.getPath());
        return semester;
    }

    protected void processLine(String line) {
        String[] lineArray = line.split(",");

        Person person = personRepository.findByRegistrationNumber(lineArray[2]);
        Subscription subscription = subscriptionRepository.findBySemesterAndPerson(semester, person);
        subscription.setGroupOption1(groupLookUp(lineArray[4]));
        if (lineArray.length>5) {
            subscription.setGroupOption2(groupLookUp(lineArray[5]));
        }
        else {
            subscription.setGroupOption2(null);
        }
        subscription.setStatus(SubscriptionStatus.SUBSCRIPTION_CHANGED);
        subscriptionRepository.saveAndFlush(subscription);
    }

    private Group groupLookUp(String descricaoTurma) {
        Group group = groupRepository.findByTheme(descricaoTurma);
        if ((null==group) && (null!=descricaoTurma)) {
            System.out.println("Turma não encontrada:" + descricaoTurma);
        }

        return group;
    }

}
