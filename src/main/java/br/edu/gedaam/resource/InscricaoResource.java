package br.edu.gedaam.resource;

import br.edu.gedaam.model.Inscricao;
import br.edu.gedaam.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class InscricaoResource {

    @Autowired
    InscricaoRepository inscricaoRepository;

    @GetMapping("/inscricoes")
    public List<Inscricao> listaInscricoes() {
        return inscricaoRepository.findAll();
    }



}
