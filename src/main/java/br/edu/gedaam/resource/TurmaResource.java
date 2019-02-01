package br.edu.gedaam.resource;

import br.edu.gedaam.model.Aluno;
import br.edu.gedaam.model.Pessoa;
import br.edu.gedaam.model.Turma;
import br.edu.gedaam.repository.TurmaRepository;
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
public class TurmaResource {

    @Autowired
    TurmaRepository turmaRepository;

    @GetMapping("/turmas")
    public List<Turma> listaTurmas() {
        return turmaRepository.findAll();
    }


    @GetMapping("/turma/{id}")
    public Turma listaTurmaUnica(@PathVariable(value="id") long id) {
        return turmaRepository.findById(id);
    }

    @GetMapping("/turma/{id}/alunos")
    public List<Aluno> listaAlunosTurma(@PathVariable(value="id") long id) {
        Turma turma = turmaRepository.findById(id);
        return turma.getAlunos();
    }

    @GetMapping("/turma/{id}/coordenadores")
    public List<Pessoa> listaCoordenadoresTurma(@PathVariable(value="id") long id) {
        return turmaRepository.findById(id).getCoordenadores();
    }


    @PostMapping("/turma")
    public Turma salvaTurma(@RequestBody Turma turma)  {
        return turmaRepository.save(turma);
    }


    @PostMapping("/turma/{id}/aluno")
    public Turma adicionaPessoaComoAluno(@PathVariable(value="id") long id, @RequestBody Pessoa pessoa)  {
        Turma turma = turmaRepository.findById(id);
        turma.addStudent(pessoa);
        return turmaRepository.save(turma);
    }

    @PostMapping("/turma/{id}/coordenador")
    public Turma adicionaPessoaComoCoordenador(@PathVariable(value="id") long id, @RequestBody Pessoa pessoa)  {
        Turma turma = turmaRepository.findById(id);
        turma.addCoodinator(pessoa);
        return turmaRepository.save(turma);
    }

}
