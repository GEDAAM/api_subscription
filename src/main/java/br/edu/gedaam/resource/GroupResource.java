package br.edu.gedaam.resource;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Student;
import br.edu.gedaam.repository.GroupRepository;
import br.edu.gedaam.repository.StudentRepository;
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
public class GroupResource {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/turmas")
    public List<Group> listaTurmas() {
        return groupRepository.findAll();
    }


    @GetMapping("/turma/{id}")
    public Group listaTurmaUnica(@PathVariable(value="id") long id) {
        return groupRepository.findById(id);
    }

    @GetMapping("/turma/{id}/alunos")
    public List<Student> listaAlunosTurma(@PathVariable(value="id") long id) {
        Group group = groupRepository.findById(id);
        return group.getStudents();
    }

    @GetMapping("/turma/{id}/coordinators")
    public List<Person> listaCoordenadoresTurma(@PathVariable(value="id") long id) {
        return groupRepository.findById(id).getCoordinators();
    }


    @PostMapping("/turma")
    public Group salvaTurma(@RequestBody Group turma)  {
        return groupRepository.save(turma);
    }

    @PostMapping("/turma/{id}/aluno")
    public Group adicionaPessoaComoAluno(@PathVariable(value="id") long id, @RequestBody Person person)  {
        Group group = groupRepository.findById(id);
        Student student = new Student(person, group);
        studentRepository.save(student);
        return groupRepository.findById(id);
    }

    @PostMapping("/turma/{id}/coordenador")
    public Group adicionaPessoaComoCoordenador(@PathVariable(value="id") long id, @RequestBody Person person)  {
        Group group = groupRepository.findById(id);
        group.addCoodinator(person);
        return groupRepository.save(group);
    }

}
