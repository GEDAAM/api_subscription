package br.edu.gedaam.resource;

import br.edu.gedaam.model.Aluno;
import br.edu.gedaam.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class AlunoResource {

    @Autowired
    AlunoRepository alunoRepository;


    @GetMapping("/alunos")
    public List<Aluno> listaAlunos() {
        return alunoRepository.findAll();
    }


    @GetMapping("/aluno/{id}")
    public Aluno listaAlunoUnico(@PathVariable(value="id") long id) {
        return alunoRepository.findById(id);
    }

    @PostMapping("/aluno")
    public Aluno salvaAluno(@RequestBody Aluno aluno)  {
        return alunoRepository.save(aluno);
    }
}
