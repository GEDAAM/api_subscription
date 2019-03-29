package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.Student;
import br.edu.gedaam.model.Subscription;
import br.edu.gedaam.repository.GroupRepository;
import br.edu.gedaam.repository.PersonRepository;
import br.edu.gedaam.repository.SubscriptionRepository;
import br.edu.gedaam.util.FileLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionServiceServiceTest {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    GroupDistributionService groupDistributionService;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    ReplaceGroupService replaceGroupService;

    void writeGroupFile(Group group) {
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(FileLocation.CAMINHO_ARQUIVO.getPath()
                    + group.getTheme() + ".csv", true);
            OutputStreamWriter osr = new OutputStreamWriter(outputStream);
            BufferedWriter bw = new BufferedWriter(osr);

            bw.write(group.getTheme());
            bw.newLine();

            bw.write("Matrícula,Nome,Telefone,E-Mail");

            for (Student student : group.getStudents()) {
                bw.newLine();
                Person person = personRepository.findById(student.getPerson().getId());
                bw.write(person.getRegistrationNumber() + "," + person.getName() +","
                        +person.getPhone() +"," +person.getEmail());
            }
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeAllGroupsFile() {
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(FileLocation.CAMINHO_ARQUIVO.getPath()
                     + "todos_os_grupos.csv", true);
            OutputStreamWriter osr = new OutputStreamWriter(outputStream);
            BufferedWriter bw = new BufferedWriter(osr);

            List<Group> groups = groupRepository.findAll();
            for (Group group: groups) {

                bw.newLine();
                bw.newLine();

                bw.write(group.getTheme());
                bw.newLine();

                bw.write("Matrícula,Nome,Telefone,E-Mail");

                for (Student student : group.getStudents()) {
                    bw.newLine();
                    Person person = personRepository.findById(student.getPerson().getId());
                    bw.write(person.getRegistrationNumber() + "," + person.getName() + ","
                            + person.getPhone() + "," + person.getEmail());
                }
            }
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void importFile() {
        Semester semester = subscriptionService.importFile();
        replaceGroupService.replace(semester);
        groupDistributionService.makeIt(semester);

        List<Group> groups = groupRepository.findAll();
        for (Group group:
                groups) {
            writeGroupFile(group);
        }

        writeAllGroupsFile();
        writeSubscriptionFile();
    }

    void writeSubscriptionFile() {
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(FileLocation.CAMINHO_ARQUIVO.getPath()
                    + "processamento_final_201901.csv", true);
            OutputStreamWriter osr = new OutputStreamWriter(outputStream);
            BufferedWriter bw = new BufferedWriter(osr);

            bw.write("Matrícula,Nome,Telefone,E-Mail,Opcao1, Opcao2, Resultado");
            bw.newLine();


            List<Subscription> subscriptions = subscriptionRepository.findAllByOrderById();
            for (Subscription subscription:
                    subscriptions) {
                Person person = personRepository.findById(subscription.getPerson().getId());
                String group1Theme = "";
                if (null!=subscription.getGroupOption1()) {
                    Group group1 = groupRepository.findById(subscription.getGroupOption1().getId());
                    group1Theme = group1.getTheme();
                }
                String group2Theme = "";
                if (null!=subscription.getGroupOption2()) {
                    Group group2 = groupRepository.findById(subscription.getGroupOption2().getId());
                    group2Theme = group2.getTheme();
                }
                bw.write(person.getRegistrationNumber() + "," + person.getName() +","
                        +person.getPhone() +"," +person.getEmail()+","
                        +group1Theme+","
                        +group2Theme+","
                        +subscription.getStatus());
                bw.newLine();

            }
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}