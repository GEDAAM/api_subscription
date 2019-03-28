package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.University;
import br.edu.gedaam.model.enums.SubscriptionStatus;
import br.edu.gedaam.repository.PersonRepository;
import br.edu.gedaam.repository.SemesterRepository;
import br.edu.gedaam.repository.SubscriptionRepository;
import br.edu.gedaam.util.FileLocation;
import br.edu.gedaam.util.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SubscriptionService extends FileReader {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    UniversitiesService universitiesService;

    @Autowired
    Groups201901Service groups201901Service;

    private Map<String, University> universities = new HashMap<>();
    private Map<String, Group> groups = new HashMap<>();
    private Semester semester;

    public Semester importFile() {

        semester = createSemester();
        universities = universitiesService.load();

        groups = groups201901Service.load(semester,universities);

        readFile(FileLocation.SUBSCRIPTION.getPath());

        return semester;
    }

    protected void processLine(String line) {
        String[] lineArray = line.split(",");

        Person person = new Person();
        person.setRegistrationNumber(lineArray[0].trim());
        person.setName(lineArray[1].trim());
        person.setUniversity(universityLookup(lineArray[2].trim()));
        if (lineArray[3].length()>0) {
            person.setPeriod(Integer.getInteger(lineArray[3].substring(0, lineArray[3].length() - 2)));
        }
        person.setPhone(lineArray[4].trim());
        person.setEmail(lineArray[5].trim());

        personRepository.saveAndFlush(person);

        br.edu.gedaam.model.Subscription subscription = new br.edu.gedaam.model.Subscription();
        subscription.setPerson(person);
        subscription.setGroupOption1(groupLookUp(lineArray[6]));
        subscription.setGroupOption2(groupLookUp(lineArray[7]));
        //subscription.setSubscriptionTimeStamp(DateTimeConverter.formatDateTime(lineArray[0].trim()));
        subscription.setSemester(semester);
        subscription.setStatus(SubscriptionStatus.TO_BE_PROCESSED);
        subscription.setSimposiumPresent(true);
        subscription.setFrequentLastSemester(true);

        subscriptionRepository.saveAndFlush(subscription);
    }

    private Semester createSemester() {
        Semester semester = new Semester();
        semester.setActive(true);
        semester.setNumber(1);
        semester.setYear(2019);
        return semesterRepository.saveAndFlush(semester);
    }

    private Group groupLookUp(String descricaoTurma) {
        if ((groups.get(descricaoTurma)==null) && (null!=descricaoTurma)) {
            System.out.println("Turma nâo encontrada:" + descricaoTurma);
        }
        return groups.get(descricaoTurma);
    }

    private University universityLookup(String universityName) {
        return universities.get(universityName);
    }
}
