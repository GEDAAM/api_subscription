package br.edu.gedaam.resource;

import br.edu.gedaam.model.University;
import br.edu.gedaam.repository.UniversityRepository;
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
public class UniversityResource {

    @Autowired
    UniversityRepository faculdadeRepository;

    @GetMapping("/faculdades")
    public List<University> listaFaculdades() {
        return faculdadeRepository.findAll();
    }

    @GetMapping("/faculdade/{id}")
    public University listaFaculdadeUnica(@PathVariable(value="id") long id) {
        return faculdadeRepository.findById(id);
    }

    @PostMapping("/faculdade")
    public University salvaFaculdade(@RequestBody University faculdade)  {
        return faculdadeRepository.save(faculdade);
    }

}
