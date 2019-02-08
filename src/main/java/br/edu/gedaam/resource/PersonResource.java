package br.edu.gedaam.resource;

import br.edu.gedaam.model.Person;
import br.edu.gedaam.repository.PersonRepository;
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
public class PersonResource {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/pessoas")
    public List<Person> listaPessoas() {
        return personRepository.findAll();
    }

    @GetMapping("/pessoa/{id}")
    public Person listaPessoaUnica(@PathVariable(value="id") long id) {
        return personRepository.findById(id);
    }

    @PostMapping("/pessoa")
    public Person salvaPessoa(@RequestBody Person pessoa)  {
        return personRepository.save(pessoa);
    }
}
