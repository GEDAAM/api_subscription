package br.edu.gedaam.service;

import br.edu.gedaam.model.University;
import br.edu.gedaam.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
class UniversitiesService {

    @Autowired
    private UniversityRepository faculdadeRepository;

    private Map<String, University> faculdades = new HashMap<>();

    Map<String, University> load() {
        newUniversity("UFMG");
        newUniversity("UniBH");
        newUniversity("FAMINAS");
        newUniversity("FASEH");
        newUniversity("PUC-MG");
        return faculdades;
    }

    private void newUniversity(String nome) {
        University faculdade = new University(nome);
        University newUniversity = faculdadeRepository.save(faculdade);
        faculdades.put(nome, newUniversity);
    }

}
