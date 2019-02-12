package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.University;
import br.edu.gedaam.model.enums.SubscriptionStatus;
import br.edu.gedaam.repository.PersonRepository;
import br.edu.gedaam.repository.SemesterRepository;
import br.edu.gedaam.repository.SubscriptionRepository;
import br.edu.gedaam.util.DateTimeConverter;
import br.edu.gedaam.util.FileLocation;
import br.edu.gedaam.util.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    Groups201802Service groups201802Service;

    @Autowired
    SimposiumService simposiumService;

    @Autowired
    FrequencyService frequencyService;


    private Map<String, University> universities = new HashMap<>();
    private Map<String, Group> groups = new HashMap<>();
    private Set<String> simposiumPresentSet;
    private Set<String> infrequentSet;
    private Semester semester;

    public Semester importFile() {

        semester = createSemester();
        universities = universitiesService.load();
        groups = groups201802Service.load(semester, universities);

        simposiumPresentSet = simposiumService.importData();
        infrequentSet = frequencyService.importData();

        readFile(FileLocation.SUBSCRIPTION.getPath());

        return semester;
    }

    protected void processLine(String line) {
        String[] lineArray = line.split(",");

        Person person = new Person();
        person.setName(lineArray[1].trim());
        person.setPhone(lineArray[5].trim());
        person.setUniversity(universityLookup(lineArray[2].trim()));
        person.setRegistrationNumber(lineArray[3].trim());
        person.setEmail(lineArray[6].trim());
        person.setPeriod(Integer.getInteger(lineArray[4].trim()));

        personRepository.saveAndFlush(person);

        String opcao1Processada = (!lineArray[8].trim().isEmpty()) ? lineArray[8].trim() : lineArray[10].trim();
        opcao1Processada = (!opcao1Processada.isEmpty()) ? opcao1Processada : lineArray[12].trim();

        String opcao2Processada = (!lineArray[9].trim().isEmpty()) ? lineArray[9].trim() : lineArray[11].trim();
        opcao2Processada = (!opcao2Processada.isEmpty()) ? opcao2Processada : lineArray[13].trim();

        br.edu.gedaam.model.Subscription subscription = new br.edu.gedaam.model.Subscription();
        subscription.setPerson(person);
        subscription.setGroupOption1(groupLookUp(opcao1Processada));
        subscription.setGroupOption2(groupLookUp(opcao2Processada));
        subscription.setSubscriptionTimeStamp(DateTimeConverter.formatDateTime(lineArray[0].trim()));
        subscription.setSemester(semester);
        subscription.setStatus(SubscriptionStatus.TO_BE_PROCESSED);
        subscription.setSimposiumPresent(simposiumPresentSet.contains(person.getEmail()));
        subscription.setFrequentLastSemester(!infrequentSet.contains(person.getEmail()));

        subscriptionRepository.saveAndFlush(subscription);
    }

    private Semester createSemester() {
        Semester semester = new Semester();
        semester.setActive(true);
        semester.setNumber(2);
        semester.setYear(2018);
        return semesterRepository.saveAndFlush(semester);
    }

    private Group groupLookUp(String descricaoTurma) {
        return groups.get(descricaoTurma);
    }

    private University universityLookup(String universityName) {
        return universities.get(universityName);
    }
}
