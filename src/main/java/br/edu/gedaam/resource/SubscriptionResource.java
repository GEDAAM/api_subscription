package br.edu.gedaam.resource;

import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.Subscription;
import br.edu.gedaam.repository.SubscriptionRepository;
import br.edu.gedaam.service.EmailService;
import br.edu.gedaam.service.GroupDistributionService;
import br.edu.gedaam.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class SubscriptionResource {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    GroupDistributionService groupDistributionService;


    String mailSubject = "Solicitação de Inscrição no GEDAAM";
    String mailText = "<html>Solicitação de Inscrição efetivada com sucesso. Aguarde os próximos contatos.</html>";


    @Autowired
    EmailService emailService;

    @GetMapping("/inscricoes")
    public List<Subscription> listaInscricoes() {
        return subscriptionRepository.findAll();
    }


    @GetMapping("/inscricao/{id}")
    public Subscription listaInscricaoUnica(@PathVariable(value="id") long id) {
        return subscriptionRepository.findById(id);
    }

    @PostMapping("/inscricao")
    public Subscription salvaInscricao(@RequestBody Subscription subscription)  {
        Subscription subscription1 = subscriptionRepository.save(subscription);
        /*emailService.sendEmail(inscricao.getPerson().getName(),
                inscricao.getPerson().getEmail(),
                mailSubject, mailText);*/
        return subscription;
    }

    @PutMapping("/inscricoes/importar")
    public void importaInscricoes() {
        subscriptionService.importFile();
    }

    @GetMapping("/inscricao/faztudo")
    public List<Subscription> distributeGroup()  {
        Semester semester = subscriptionService.importFile();
        return groupDistributionService.makeIt(semester);
    }




}
