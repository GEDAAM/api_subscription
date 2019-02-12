package br.edu.gedaam.service;

import br.edu.gedaam.model.Semester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionServiceServiceTest {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    GroupDistributionService groupDistributionService;

    @Test
    public void importFile() {
        Semester semester = subscriptionService.importFile();
        groupDistributionService.makeIt(semester);
    }

}