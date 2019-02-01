package br.edu.gedaam.resource;

import br.edu.gedaam.model.Pessoa;
import br.edu.gedaam.repository.PessoaRepository;
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
public class PessoaResource {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/pessoas")
    public List<Pessoa> listaPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa listaPessoaUnica(@PathVariable(value="id") long id) {
        return pessoaRepository.findById(id);
    }

    @PostMapping("/pessoa")
    public Pessoa salvaPessoa(@RequestBody Pessoa pessoa)  {
        return pessoaRepository.save(pessoa);
    }
}
