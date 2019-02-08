package br.edu.gedaam.service;

import br.edu.gedaam.model.Faculdade;
import br.edu.gedaam.model.Pessoa;
import br.edu.gedaam.model.Turma;
import br.edu.gedaam.repository.FaculdadeRepository;
import br.edu.gedaam.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
class CargaService {


    @Autowired
    private FaculdadeRepository faculdadeRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    private Map<String, Faculdade> faculdades = new HashMap<>();
    private Map<String, Turma> turmas = new HashMap<>();


    Map<String, Faculdade> criaListaFaculdades() {
        newUniversity("UFMG");
        newUniversity("UniBH");
        newUniversity("FAMINAS");
        newUniversity("FASEH");
        newUniversity("PUC-MG");
        return faculdades;
    }

    Map<String, Turma> criaListaTurmas()  {
        List<Pessoa> coodenadores = new ArrayList<>();

        coodenadores.add(new Pessoa("Luana", 9, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Peu", 9, faculdadeLookup("UFMG")));
        newGroup("INGLÊS | Luana (9°) e Peu (9°) - Campus UFMG Saúde - Segunda-feira: 18h30-20h30",
                "Inglês", "Campus UFMG Saúde", true, false, false,
                false, false, "18:30", "20:30", coodenadores);


        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Isabella Miranda", 5, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Wendel", 5, faculdadeLookup("UFMG")));
        newGroup("INGLÊS | Isabella Miranda (5°) e Wendel (5°) - Campus UFMG Saúde - Quarta-feira: 18h00-20h00",
                "Inglês", "Campus UFMG Saúde", false, false, true,
                false, false, "18:00", "20:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Nina", 5, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Maíra", 5, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Rafael Nicolas", 5, faculdadeLookup("UFMG")));
        newGroup("LIBRAS | Nina (5°) e Maíra (5°) e Rafael Nicolas (5°) - Campus UFMG Saúde - Terça-feira: 18h30-20h00",
                "Libras", "Campus UFMG Saúde", false, true, false,
                false, false, "18:30", "20:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Léo Padre", 9, faculdadeLookup("UFMG")));
        newGroup("RESIDÊNCIA MÉDICA | Léo Padre (9°) - Campus UFMG Saúde - Segunda-feira: 13h00-14h00",
                "Residência Médica", "Campus UFMG Saúde", true, false, false,
                false, false, "13:00", "14:00", coodenadores);


        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Isabella Faria", 9, faculdadeLookup("UFMG")));
        newGroup("RESIDÊNCIA EUA (INGLÊS) | Isabella Faria (9°) - Campus UFMG Saúde - Quinta-feira: 17h30-19h00",
                "Residência EUA (Inglês)", "Campus UFMG Saúde", false, false, false,
                true, false, "17:30", "19:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Thassi", 5, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Júlia Casali", 5, faculdadeLookup("UFMG")));
        newGroup("TURMA PARA CALOUROS | Thassi (5°) e Júlia Casali (5°) - Campus UFMG Saúde - Terça-feira: 12h00-13h00",
                "Turma para Calouros", "Campus UFMG Saúde", false, true, false,
                false, false, "12:00", "13:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Fernanda", 8, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Lorhayne", 8, faculdadeLookup("UFMG")));
        newGroup("Fernanda (8°) e Lorhayne (8°) - Campus UFMG Saúde - Segunda-feira: 18h00-19h30",
                "", "Campus UFMG Saúde", true, false, false,
                false, false, "18:00", "19:30", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Rafael Ageu", 10, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Gabriel Marques", 10, faculdadeLookup("UFMG")));
        newGroup("Rafael Ageu (10°) e Gabriel Marques (10°) - Campus UFMG Saúde - Segunda-feira: 18h00-20h00",
                "", "Campus UFMG Saúde", true, false, false,
                false, false, "18:00", "20:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Natalia", 7, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Violeta", 7, faculdadeLookup("UFMG")));
        newGroup("Natalia (7°) e Violeta (7°) - Campus UFMG Saúde - Terça-feira: 18h00-20h00",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:00", "20:00", coodenadores);


        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Gustavo", 6, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Brígida", 6, faculdadeLookup("UFMG")));
        newGroup("Gustavo (6°) e Brígida (6°) - Campus UFMG Saúde - Terça-feira: 18h10-19h40",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:10", "19:40", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Vinícius Antunes", 8, faculdadeLookup("UFMG")));
        newGroup("Vinícius Antunes (8°) - Campus UFMG Saúde - Terça-feira: 18h15-20h00",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:15", "20:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Larissa", 5, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Vitor", 5, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Médici", 5, faculdadeLookup("UFMG")));
        newGroup("Larissa (5°) e Vitor (5°) e Médici (5°) - Campus UFMG Saúde - Terça-feira: 18h30-20h30",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:30", "20:30", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Thales", 9, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Jaqueline", 9, faculdadeLookup("UFMG")));
        newGroup( "Thales (9°) e Jaqueline (9°) - Campus UFMG Saúde - Terça-feira: 18h30-20h30",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:30", "20:30", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Nogueira", 4, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Garcez", 4, faculdadeLookup("UFMG")));
        newGroup( "Nogueira (4°) e Garcez (4°) - Campus UFMG Saúde - Quarta-feira: 19h00-21h00",
                "", "Campus UFMG Saúde", false, false, true,
                false, false, "19:00", "21:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Lucas Macedo", 5, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Óliver", 5, faculdadeLookup("UFMG")));
        newGroup( "Lucas Macedo (5°) e Óliver (5°) - Campus UFMG Saúde - Quinta-feira: 12h30-14h00",
                "", "Campus UFMG Saúde", false, false, false,
                true, false, "12:30", "14:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Álvaro", 5, faculdadeLookup("UFMG")));
        coodenadores.add(new Pessoa("Rayan", 5, faculdadeLookup("UFMG")));
        newGroup( "Álvaro (5°) e Rayan (5°) - Campus UFMG Saúde - Quinta-feira: 18h20-20h00",
                "", "Campus UFMG Saúde", false, false, false,
                true, false, "18:20", "20:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Gabriela", 3, faculdadeLookup("UniBH")));
        coodenadores.add(new Pessoa("Lara", 6, faculdadeLookup("UniBH")));
        coodenadores.add(new Pessoa("Manuela", 5, faculdadeLookup("UniBH")));
        newGroup( "Gabriela (3°) e Lara (6°) e Manuela (5°) - Campus UniBH Estoril - Segunda-feira: 17h00-19h00",
                "", "Campus UniBH Estoril", true, false, false,
                false, false, "17:00", "19:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Carolina", 4, faculdadeLookup("UniBH")));
        coodenadores.add(new Pessoa("João", 9, faculdadeLookup("UniBH")));
        newGroup( "Carolina (4°) e João (9°) - Campus UniBH Estoril - Segunda-feira: 18h00-19h00",
                "", "Campus UniBH Estoril", true, false, false,
                false, false, "18:00", "19:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Ana Paula", 8, faculdadeLookup("UniBH")));
        coodenadores.add(new Pessoa("Yan", 5, faculdadeLookup("UniBH")));
        newGroup( "Ana Paula (8°) e Yan (5°) - Campus UniBH Estoril - Segunda-feira: 19h00-21h00",
                "", "Campus UniBH Estoril", true, false, false,
                false, false, "19:00", "21:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Julia", 5, faculdadeLookup("UniBH")));
        coodenadores.add(new Pessoa("André", 9, faculdadeLookup("UniBH")));
        newGroup( "Julia (5°) e André (9°) - Campus UniBH Estoril - Quarta-feira: 18h00-20h00",
                "", "Campus UniBH Estoril", false, false, true,
                false, false, "18:00", "20:00", coodenadores);

        coodenadores = new ArrayList<>();
        coodenadores.add(new Pessoa("Tifany Rafaely", 4, faculdadeLookup("UFMG")));
        newGroup( "Tifany Rafaely (4°) - Campus UFMG Pampulha - Sexta-feira: 12h30-13h50",
                "", "Campus UFMG Pampulha", false, false, false,
                false, true, "12:30", "13:50", coodenadores);

        return turmas;
    }


    private void newUniversity(String nome) {
        Faculdade faculdade = new Faculdade(nome);
        Faculdade newUniversity = faculdadeRepository.save(faculdade);
        faculdades.put(nome, newUniversity);
    }


    private void newGroup(String key, String desc, String local,
                          boolean segunda, boolean terca, boolean quarta, boolean quinta, boolean sexta,
                          String horaInicio, String horaFim, List<Pessoa> coordenadores) {

        Turma turma = new Turma(desc, local, segunda,terca,quarta,quinta,sexta,
                DateTimeService.formatTime(horaInicio+":00"),
                DateTimeService.formatTime(horaFim+":00"));
        turma.setCoordenadores(coordenadores);
        turmaRepository.save(turma);
        turmas.put(key, turma);
    }

    private Faculdade faculdadeLookup(String nomeFaculdade)  {
        return faculdades.get(nomeFaculdade);
    }

}
