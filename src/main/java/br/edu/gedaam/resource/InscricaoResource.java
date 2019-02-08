package br.edu.gedaam.resource;

import br.edu.gedaam.model.Inscricao;
import br.edu.gedaam.repository.InscricaoRepository;
import br.edu.gedaam.service.EmailService;
import br.edu.gedaam.service.InscricaoService;
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
public class InscricaoResource {

    @Autowired
    InscricaoRepository inscricaoRepository;

    @Autowired
    InscricaoService inscricaoService;

    String mailSubject = "Solicitação de Inscrição no GEDAAM";
    String mailText = "<html>Solicitação de Inscrição efetivada com sucesso. Aguarde os próximos contatos.</html>";


    @Autowired
    EmailService emailService;

    @GetMapping("/inscricoes")
    public List<Inscricao> listaInscricoes() {
        return inscricaoRepository.findAll();
    }


    @GetMapping("/inscricao/{id}")
    public Inscricao listaInscricaoUnica(@PathVariable(value="id") long id) {
        return inscricaoRepository.findById(id);
    }

    @PostMapping("/inscricao")
    public Inscricao salvaInscricao(@RequestBody Inscricao inscricao)  {
        Inscricao inscricao1 = inscricaoRepository.save(inscricao);
        /*emailService.sendEmail(inscricao.getPessoa().getNome(),
                inscricao.getPessoa().getEmail(),
                mailSubject, mailText);*/
        return inscricao1;
    }

    @PutMapping("/inscricoes/importacao")
    public void importaInscricoes() {
        inscricaoService.importFile();

    }



}
