package br.edu.gedaam.resource;

import br.edu.gedaam.model.Inscricao;
import br.edu.gedaam.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/inscricao/{id}")
    public Inscricao listaInscricaoUnica(@PathVariable(value="id") long id) {
        return inscricaoRepository.findById(id);
    }

    @PostMapping("/inscricao")
    public Inscricao salvaInscricao(@RequestBody Inscricao inscricao)  {
        return inscricaoRepository.save(inscricao);
    }



}
