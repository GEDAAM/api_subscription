package br.edu.gedaam.resource;

import br.edu.gedaam.model.Inscricao;
import br.edu.gedaam.repository.InscricaoRepository;
import br.edu.gedaam.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        emailService.sendEmail();
        return inscricaoRepository.save(inscricao);
    }



}
