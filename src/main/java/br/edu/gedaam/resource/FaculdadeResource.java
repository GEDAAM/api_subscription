package br.edu.gedaam.resource;

import br.edu.gedaam.model.Faculdade;
import br.edu.gedaam.model.Pessoa;
import br.edu.gedaam.repository.FaculdadeRepository;
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
public class FaculdadeResource {

    @Autowired
    FaculdadeRepository faculdadeRepository;

    @GetMapping("/faculdades")
    public List<Faculdade> listaFaculdades() {
        return faculdadeRepository.findAll();
    }

    @GetMapping("/faculdade/{id}")
    public Faculdade listaFaculdadeUnica(@PathVariable(value="id") long id) {
        return faculdadeRepository.findById(id);
    }

    @PostMapping("/faculdade")
    public Faculdade salvaFaculdade(@RequestBody Faculdade faculdade)  {
        return faculdadeRepository.save(faculdade);
    }

}
