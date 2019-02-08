package br.edu.gedaam.resource;

import br.edu.gedaam.model.Semester;
import br.edu.gedaam.repository.SemesterRepository;
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
public class SemesterResource {

    @Autowired
    SemesterRepository semesterRepository;

    @GetMapping("/semestresletivos")
    public List<Semester> listaSemestres() {
        return semesterRepository.findAll();
    }


    @GetMapping("/semestreletivo/{id}")
    public Semester listaSemestreUnico(@PathVariable(value="id") long id) {
        return semesterRepository.findById(id);
    }

    @PostMapping("/semestreletivo")
    public Semester salvaSemestreLetivo(@RequestBody Semester semester)  {
        return semesterRepository.save(semester);
    }

}
