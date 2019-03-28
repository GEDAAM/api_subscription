package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.Student;
import br.edu.gedaam.repository.GroupRepository;
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

    static void writeGroupFile(Group group) {
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(FileLocation.CAMINHO_ARQUIVO
                    + group.getTheme() + ".csv", true);
            OutputStreamWriter osr = new OutputStreamWriter(outputStream);
            BufferedWriter bw = new BufferedWriter(osr);

            bw.write(group.getTheme());
            bw.newLine();

            bw.write("Matrícula,Nome");

            for (Student student : group.getStudents()) {
                bw.newLine();
                bw.write(student.getPerson().getRegistrationNumber() + "," + student.getPerson().getName());
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
        groupDistributionService.makeIt(semester);

        List<Group> groups = groupRepository.findAll();
        for (Group group:
                groups) {
            writeGroupFile(group);
        }
    }
}