package br.edu.gedaam.resource;

import br.edu.gedaam.model.SemestreLetivo;
import br.edu.gedaam.repository.SemestreLetivoRepository;
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
public class SemestreLetivoResource {

    @Autowired
    SemestreLetivoRepository semestreLetivoRepository;

    @GetMapping("/semestresletivos")
    public List<SemestreLetivo> listaSemestres() {
        return semestreLetivoRepository.findAll();
    }


    @GetMapping("/semestreletivo/{id}")
    public SemestreLetivo listaSemestreUnico(@PathVariable(value="id") long id) {
        return semestreLetivoRepository.findById(id);
    }

    @PostMapping("/semestreletivo")
    public SemestreLetivo salvaSemestreLetivo(@RequestBody SemestreLetivo semestreLetivo)  {
        return semestreLetivoRepository.save(semestreLetivo);
    }

}
