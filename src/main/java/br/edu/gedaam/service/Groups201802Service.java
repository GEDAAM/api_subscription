package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.University;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Groups201802Service extends GroupService {

    Map<String, Group> load(Semester semester, Map<String, University> universities)  {
        List<Person> coordinators = new ArrayList<>();
        this.semester = semester;

        coordinators.add(new Person("Luana", 9, universities.get("UFMG")));
        coordinators.add(new Person("Peu", 9, universities.get("UFMG")));
        Group group = newGroup("INGLÊS | Luana (9°) e Peu (9°) - Campus UFMG Saúde - Segunda-feira: 18h30-20h30",
                "Inglês", "Campus UFMG Saúde", true, false, false,
                false, false, "18:30", "20:30", coordinators, 12);
        groups.put("Luana (9°) e Peu (9°) - Campus UFMG Saúde - Segunda-feira: 18h30-20h30",group);


        coordinators = new ArrayList<>();
        coordinators.add(new Person("Isabella Miranda", 5, universities.get("UFMG")));
        coordinators.add(new Person("Wendel", 5, universities.get("UFMG")));
        group = newGroup("Isabella Miranda (5°) e Wendel (5°) - Campus UFMG Saúde - Quarta-feira: 18h00-20h00",
                "Inglês", "Campus UFMG Saúde", false, false, true,
                false, false, "18:00", "20:00", coordinators, 12);
        groups.put("INGLÊS | Isabella Miranda (5°) e Wendel (5°) - Campus UFMG Saúde - Quarta-feira: 18h00-20h00", group);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Nina", 5, universities.get("UFMG")));
        coordinators.add(new Person("Maíra", 5, universities.get("UFMG")));
        coordinators.add(new Person("Rafael Nicolas", 5, universities.get("UFMG")));
        newGroup("LIBRAS | Nina (5°) e Maíra (5°) e Rafael Nicolas (5°) - Campus UFMG Saúde - Terça-feira: 18h30-20h00",
                "Libras", "Campus UFMG Saúde", false, true, false,
                false, false, "18:30", "20:00", coordinators, 12);


        coordinators = new ArrayList<>();
        coordinators.add(new Person("Léo Padre", 9, universities.get("UFMG")));
        newGroup("RESIDÊNCIA MÉDICA | Léo Padre (9°) - Campus UFMG Saúde - Segunda-feira: 12h00-14h00",
                "Residência Médica", "Campus UFMG Saúde", true, false, false,
                false, false, "12:00", "14:00", coordinators, 12);


        coordinators = new ArrayList<>();
        coordinators.add(new Person("Isabella Faria", 9, universities.get("UFMG")));
        newGroup("RESIDÊNCIA EUA (INGLÊS) | Isabella Faria (9°) - Campus UFMG Saúde - Quinta-feira: 17h30-19h00",
                "Residência EUA (Inglês)", "Campus UFMG Saúde", false, false, false,
                true, false, "17:30", "19:00", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Thassi", 5, universities.get("UFMG")));
        coordinators.add(new Person("Júlia Casali", 5, universities.get("UFMG")));
        group = newGroup("Thassi (5°) e Júlia Casali (5°) - Campus UFMG Saúde - Terça-feira: 12h00-13h00 | Turma para Calouros",
                "Group para Calouros", "Campus UFMG Saúde", false, true, false,
                false, false, "12:00", "13:00", coordinators, 12);
        groups.put("Thassi (5°) e Júlia Casali (5°) - Campus UFMG Saúde - Terça-feira: 12h00-14h00 | Turma para Calouros", group);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Fernanda", 8, universities.get("UFMG")));
        coordinators.add(new Person("Lorhayne", 8, universities.get("UFMG")));
        newGroup("Fernanda (8°) e Lorhayne (8°) - Campus UFMG Saúde - Segunda-feira: 18h00-19h30",
                "", "Campus UFMG Saúde", true, false, false,
                false, false, "18:00", "19:30", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Rafael Ageu", 10, universities.get("UFMG")));
        coordinators.add(new Person("Gabriel Marques", 10, universities.get("UFMG")));
        newGroup("Rafael Ageu (10°) e Gabriel Marques (10°) - Campus UFMG Saúde - Segunda-feira: 18h00-20h00",
                "", "Campus UFMG Saúde", true, false, false,
                false, false, "18:00", "20:00", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Natalia", 7, universities.get("UFMG")));
        coordinators.add(new Person("Violeta", 7, universities.get("UFMG")));
        newGroup("Natalia (7°) e Violeta (7°) - Campus UFMG Saúde - Terça-feira: 18h00-20h00",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:00", "20:00", coordinators, 12);


        coordinators = new ArrayList<>();
        coordinators.add(new Person("Gustavo", 6, universities.get("UFMG")));
        coordinators.add(new Person("Brígida", 6, universities.get("UFMG")));
        newGroup("Gustavo (6°) e Brígida (6°) - Campus UFMG Saúde - Terça-feira: 18h10-19h40",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:10", "19:40", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Vinícius Antunes", 8, universities.get("UFMG")));
        newGroup("Vinícius Antunes (8°) - Campus UFMG Saúde - Terça-feira: 18h15-20h00",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:15", "20:00", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Larissa", 5, universities.get("UFMG")));
        coordinators.add(new Person("Vitor", 5, universities.get("UFMG")));
        coordinators.add(new Person("Médici", 5, universities.get("UFMG")));
        newGroup("Larissa (5°) e Vitor (5°) e Médici (5°) - Campus UFMG Saúde - Terça-feira: 18h30-20h30",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:30", "20:30", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Thales", 9, universities.get("UFMG")));
        coordinators.add(new Person("Jaqueline", 9, universities.get("UFMG")));
        newGroup( "Thales (9°) e Jaqueline (9°) - Campus UFMG Saúde - Terça-feira: 18h30-20h30",
                "", "Campus UFMG Saúde", false, true, false,
                false, false, "18:30", "20:30", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Nogueira", 4, universities.get("UFMG")));
        coordinators.add(new Person("Garcez", 4, universities.get("UFMG")));
        newGroup( "Nogueira (4°) e Garcez (4°) - Campus UFMG Saúde - Quarta-feira: 19h00-21h00",
                "", "Campus UFMG Saúde", false, false, true,
                false, false, "19:00", "21:00", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Lucas Macedo", 5, universities.get("UFMG")));
        coordinators.add(new Person("Óliver", 5, universities.get("UFMG")));
        newGroup( "Lucas Macedo (5°) e Óliver (5°) - Campus UFMG Saúde - Quinta-feira: 12h30-14h00",
                "", "Campus UFMG Saúde", false, false, false,
                true, false, "12:30", "14:00", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Álvaro", 5, universities.get("UFMG")));
        coordinators.add(new Person("Rayan", 5, universities.get("UFMG")));
        newGroup( "Álvaro (5°) e Rayan (5°) - Campus UFMG Saúde - Quinta-feira: 18h20-20h00",
                "", "Campus UFMG Saúde", false, false, false,
                true, false, "18:20", "20:00", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Lara", 5, universities.get("UniBH")));
        coordinators.add(new Person("Manuela", 5, universities.get("UniBH")));
        newGroup( "Lara (5°) e Manuela (5°) - Campus UniBH Estoril - Sexta-feira: 19h00-20h30",
                "", "Campus UniBH Estoril", false, false, false,
                false, true, "19:00", "20:30", coordinators, 12);


        coordinators = new ArrayList<>();
        coordinators.add(new Person("Gabriela", 3, universities.get("UniBH")));
        coordinators.add(new Person("Marília", 6, universities.get("UniBH")));
        group = newGroup( "Gabriela (3°) e Marília (6°) - Campus UniBH Estoril - Segunda-feira: 17h00-19h00",
                "", "Campus UniBH Estoril", true, false, false,
                false, false, "17:00", "19:00", coordinators, 12);
        groups.put("Gabriela (3°), Lara (6°) e Manuela (5°) - Campus UniBH Estoril - Segunda-feira: 17h00-19h00", group);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Carolina", 4, universities.get("UniBH")));
        coordinators.add(new Person("João", 9, universities.get("UniBH")));
        newGroup( "Carolina (4°) e João (9°) - Campus UniBH Estoril - Segunda-feira: 18h00-19h00",
                "", "Campus UniBH Estoril", true, false, false,
                false, false, "18:00", "19:00", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Ana Paula", 8, universities.get("UniBH")));
        coordinators.add(new Person("Yan", 5, universities.get("UniBH")));
        newGroup( "Ana Paula (8°) e Yan (5°) - Campus UniBH Estoril - Segunda-feira: 19h00-21h00",
                "", "Campus UniBH Estoril", true, false, false,
                false, false, "19:00", "21:00", coordinators, 12);

        coordinators = new ArrayList<>();
        coordinators.add(new Person("Julia", 5, universities.get("UniBH")));
        coordinators.add(new Person("André", 9, universities.get("UniBH")));
        group = newGroup( "Julia (5°) e André (9°) - Campus UniBH Estoril - Terça-feira: 18h00-20h00",
                "", "Campus UniBH Estoril", false, true, false,
                false, false, "18:00", "20:00", coordinators,12);
        groups.put("Julia (5°) e André (9°) - Campus UniBH Estoril - Quarta-feira: 18h00-20h00", group);



        coordinators = new ArrayList<>();
        coordinators.add(new Person("Tifany Rafaely", 4, universities.get("UFMG")));
        newGroup( "Tifany Rafaely (4°) - Campus UFMG Pampulha - Sexta-feira: 12h30-13h50",
                "", "Campus UFMG Pampulha", false, false, false,
                false, true, "12:30", "13:50", coordinators, 12);

        return groups;
    }

}
