package br.edu.gedaam.service;

import br.edu.gedaam.model.Group;
import br.edu.gedaam.model.Person;
import br.edu.gedaam.model.Semester;
import br.edu.gedaam.model.University;
import br.edu.gedaam.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Groups201901Service extends GroupService   {

    @Autowired
    private GroupRepository groupRepository;

    private Map<String, Group> groups = new HashMap<>();
    private Semester semester;

    Map<String, Group> load(Semester semester, Map<String, University> universities) {
        List<Person> coordinators = new ArrayList<>();
        this.semester = semester;


        coordinators.add(new Person("João Guilherme", 10, universities.get("UFMG")));
        coordinators.add(new Person("Gabriela", 6, universities.get("UFMG")));
        Group group = newGroup("Campus Estoril UniBH - Segunda-feira - 19:00-21:00 - João Guilherme (10°)  e Gabriela (6°)",
                "Campus Estoril UniBH - Segunda-feira - 19:00-21:00 - João Guilherme (10°)  e Gabriela (6°)",
                "Campus Estoril UniBH", true, false, false,
                false, false, "19:00", "21:00", coordinators, 10);
        groups.put("Campus Estoril UniBH - Segunda-feira - 19:00-21:00 - João Guilherme (10°)  e Gabriela (6°)", group);

        coordinators.add(new Person("Raquel Penido", 6, universities.get("UFMG")));
        coordinators.add(new Person("Maria Clara", 6, universities.get("UFMG")));
        group = newGroup("Campus Estoril UniBH - Sexta-feira - 19:00-21:00 - Raquel Penido (6°)  e Maria Clara",
                "Campus Estoril UniBH - Sexta-feira - 19:00-21:00 - Raquel Penido (6°)  e Maria Clara",
                "Campus Estoril UniBH", false, false, false,
                false, true, "19:00", "21:00", coordinators, 12);
        groups.put("Campus Estoril UniBH - Sexta-feira - 19:00-21:00 - Raquel Penido (6°)  e Maria Clara", group);

        coordinators.add(new Person("Rodrigo Espindula", 2, universities.get("UFMG")));
        coordinators.add(new Person("Thierry Rossine", 3, universities.get("UFMG")));
        group = newGroup("Campus Pampulha UFMG - Segunda-feira - 18:30 - 20:00 - Rodrigo Espindula (2°)  e Thierry Rossine (3°)",
                "Campus Pampulha UFMG - Segunda-feira - 18:30 - 20:00 - Rodrigo Espindula (2°)  e Thierry Rossine (3°)", "Campus Pampulha UFMG", true, false, false,
                false, false, "18:30", "20:00", coordinators, 10);
        groups.put("Campus Pampulha UFMG - Segunda-feira - 18:30 - 20:00 - Rodrigo Espindula (2°)  e Thierry Rossine (3°)", group);

        coordinators.add(new Person("Cecilia Andrade", 4, universities.get("UFMG")));
        coordinators.add(new Person("Letícia Bitencourt", 4, universities.get("UFMG")));
        group = newGroup("Campus Pampulha UFMG - Sexta-feira - 12h30-14h00 - Cecília Andrade (4°)  e Letícia Bitencourt (4°)",
                "Campus Pampulha UFMG - Sexta-feira - 12h30-14h00 - Cecília Andrade (4°)  e Letícia Bitencourt (4°)",
                "Campus Pampulha UFMG", false, false, true,
                false, false, "10:30", "12:00", coordinators, 12);
        groups.put("Campus Pampulha UFMG - Sexta-feira - 12h30-14h00 - Cecília Andrade (4°)  e Letícia Bitencourt (4°)", group);

        coordinators.add(new Person("Isabella Reis", 9, universities.get("UFMG")));
        group = newGroup("Campus Unipam - Sexta-feira - 18h-20h - Isabella Reis (9°) | Turma para residência médica",
                "Campus Unipam - Sexta-feira - 18h-20h - Isabella Reis (9°) | Turma para residência médica",
                "Campus Unipam", false, false, false,
                false, true, "18:00", "20:00", coordinators, 10);
        groups.put("Campus Unipam - Sexta-feira - 18h-20h - Isabella Reis (9°) | Turma para residência médica", group);

        coordinators.add(new Person("Vinícius Antônio", 9, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Segunda-feira - 18:30-20:00 - Vinícius Antônio (9°)",
                "Campus Saúde UFMG - Segunda-feira - 18:30-20:00 - Vinícius Antônio (9°)", "Campus Saúde UFMG", true, false, false,
                false, false, "18:30", "20:00", coordinators, 16);
        groups.put("Campus Saúde UFMG - Segunda-feira - 18:30-20:00 - Vinícius Antônio (9°)", group);

        coordinators.add(new Person("Violeta Pereira", 8, universities.get("UFMG")));
        coordinators.add(new Person("Fabrícia Ferreira", 9, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Segunda-feira - 18h30~20h00 - Violeta Pereira (8°)  e Fabrícia Ferreira (9°)",
                "Campus Saúde UFMG - Segunda-feira - 18h30~20h00 - Violeta Pereira (8°)  e Fabrícia Ferreira (9°)", "Campus Saúde UFMG", true, false, false,
                false, false, "18:30", "20:00", coordinators, 12);
        groups.put("Campus Saúde UFMG - Segunda-feira - 18h30~20h00 - Violeta Pereira (8°)  e Fabrícia Ferreira (9°)", group);

        coordinators.add(new Person("José Augusto", 5, universities.get("UFMG")));
        coordinators.add(new Person("Cainan Gloria", 5, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Segunda-feira - 19:00-20:30 - José Augusto (5°)  e Cainan Gloria (5°)",
                "Campus Saúde UFMG - Segunda-feira - 19:00-20:30 - José Augusto (5°)  e Cainan Gloria (5°)", "Campus Saúde UFMG", true, false, false,
                false, false, "19:00", "20:30", coordinators, 10);
        groups.put("Campus Saúde UFMG - Segunda-feira - 19:00-20:30 - José Augusto (5°)  e Cainan Gloria (5°)", group);

        coordinators.add(new Person("Isabela Guedes", 6, universities.get("UFMG")));
        coordinators.add(new Person("Rafael Wendel", 6, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Terça-feira - 17h45-19h15 - Isabella Guedes (6°)  e Rafael Wendel (6°)",
                "Campus Saúde UFMG - Terça-feira - 17h45-19h15 - Isabella Guedes (6°)  e Rafael Wendel (6°)",
                "Campus Saúde UFMG", false, true, false,
                false, false, "17:45", "19:15", coordinators, 14);
        groups.put("Campus Saúde UFMG - Terça-feira - 17h45-19h15 - Isabella Guedes (6°)  e Rafael Wendel (6°)", group);

        coordinators.add(new Person("Gabriel Marques", 11, universities.get("UFMG")));
        coordinators.add(new Person("Julia Ribas", 6, universities.get("UFMG")));
        coordinators.add(new Person("Lídia Maria", 6, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Terça-feira - 18:00-20:00+ - Gabriel Marques (11°)  e Julia Ribas (6°)  e Lídia Maria (6°)",
                "Campus Saúde UFMG - Terça-feira - 18:00-20:00+ - Gabriel Marques (11°)  e Julia Ribas (6°)  e Lídia Maria (6°)",
                "Campus Saúde UFMG", false, true, false,
                false, false, "18:00", "20:00", coordinators, 12);
        groups.put("Campus Saúde UFMG - Terça-feira - 18:00-20:00+ - Gabriel Marques (11°)  e Julia Ribas (6°)  e Lídia Maria (6°)", group);

        coordinators.add(new Person("Iara dos Santos", 9, universities.get("UFMG")));
        coordinators.add(new Person("Fernanda Caroline", 9, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Terça-feira - 12h30-13h30 - Iara dos Santos (9°)  e Fernanda Caroline (9°)",
                "Campus Saúde UFMG - Terça-feira - 12h30-13h30 - Iara dos Santos (9°)  e Fernanda Caroline (9°)",
                "Campus Saúde UFMG", false, true, false,
                false, false, "12:30", "13:30", coordinators, 10);
        groups.put("Campus Saúde UFMG - Terça-feira - 12h30-13h30 - Iara dos Santos (9°)  e Fernanda Caroline (9°)", group);

        coordinators.add(new Person("Larissa Silva", 12, universities.get("UFMG")));
        coordinators.add(new Person("Isabella Maria", 10, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Terça-feira - 18h-19h30 - Larissa Silva (12°)  e Isabella Maria (10°)  | Turma para o USMLE",
                "Campus Saúde UFMG - Terça-feira - 18h-19h30 - Larissa Silva (12°)  e Isabella Maria (10°)  | Turma para o USMLE",
                "Campus Saúde UFMG", false, true, false,
                false, false, "18:00", "19:30", coordinators, 10);
        groups.put("Campus Saúde UFMG - Terça-feira - 18h-19h30 - Larissa Silva (12°)  e Isabella Maria (10°)  | Turma para o USMLE", group);

        coordinators.add(new Person("Natália Dilella", 4, universities.get("UFMG")));
        coordinators.add(new Person("Thais Oliveira", 10, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Terça-feira - 19:00-20:30 - Natália Dilella (4°)  e Thais Oliveira",
                "Campus Saúde UFMG - Terça-feira - 19:00-20:30 - Natália Dilella (4°)  e Thais Oliveira",
                "Campus Saúde UFMG", false, true, false,
                false, false, "19:00", "20:30", coordinators, 8);
        groups.put("Campus Saúde UFMG - Terça-feira - 19:00-20:30 - Natália Dilella (4°)  e Thais Oliveira", group);

        coordinators.add(new Person("Felipe Henrique", 6, universities.get("UFMG")));
        coordinators.add(new Person("Vinícius Nogueira", 10, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Terça-feira - 19:00-21:00 - Felipe Henrique (6°)  e Vinícius Nogueira",
                "Campus Saúde UFMG - Terça-feira - 19:00-21:00 - Felipe Henrique (6°)  e Vinícius Nogueira",
                "Campus Saúde UFMG", false, true, false,
                false, false, "19:00", "21:00", coordinators, 12);
        groups.put("Campus Saúde UFMG - Terça-feira - 19:00-21:00 - Felipe Henrique (6°)  e Vinícius Nogueira", group);

        coordinators.add(new Person("Eduardo de Aquino", 9, universities.get("UFMG")));
        coordinators.add(new Person("Raíssa Eda", 8, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Quarta-Feira - 11:30-13:00 - Eduardo de Aquino (9°)  e Raíssa Eda (8°)",
                "Campus Saúde UFMG - Quarta-Feira - 11:30-13:00 - Eduardo de Aquino (9°)  e Raíssa Eda (8°)",
                "Campus Saúde UFMG", false, false, true,
                false, false, "11:30", "13:00", coordinators, 8);
        groups.put("Campus Saúde UFMG - Quarta-Feira - 11:30-13:00 - Eduardo de Aquino (9°)  e Raíssa Eda (8°)", group);

        coordinators.add(new Person("Eduardo de", 6, universities.get("UFMG")));
        coordinators.add(new Person("Larissa Gonçalves", 6, universities.get("UFMG")));
        coordinators.add(new Person("Gabriela Luisa", 4, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Quarta-feira - 12-13:30 - Eduardo de (6°)  e Larissa Gonçalves (6°)  e Gabriela Luisa (4°)",
                "Campus Saúde UFMG - Quarta-feira - 12-13:30 - Eduardo de (6°)  e Larissa Gonçalves (6°)  e Gabriela Luisa (4°)",
                "Campus Saúde UFMG", false, false, true,
                false, false, "12:00", "13:30", coordinators, 12);
        groups.put("Campus Saúde UFMG - Quarta-feira - 12-13:30 - Eduardo de (6°)  e Larissa Gonçalves (6°)  e Gabriela Luisa (4°)", group);

        coordinators.add(new Person("Lidia Duarte", 5, universities.get("UFMG")));
        coordinators.add(new Person("Tifany Rafaely", 8, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Quarta-feira - 12h00-13h30 - Lídia Duarte (5°)  e Tifany Rafaely",
                "Campus Saúde UFMG - Quarta-feira - 12h00-13h30 - Lídia Duarte (5°)  e Tifany Rafaely",
                "Campus Saúde UFMG", false, false, true,
                false, false, "12:00", "13:30", coordinators, 14);
        groups.put("Campus Saúde UFMG - Quarta-feira - 12h00-13h30 - Lídia Duarte (5°)  e Tifany Rafaely", group);

        coordinators.add(new Person("Tainara Lelis", 6, universities.get("UFMG")));
        coordinators.add(new Person("Hugo Couto", 8, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Quinta-Feira - 18:00-20:00 - Tainara Lelis (6°)  e Hugo Couto",
                "Campus Saúde UFMG - Quinta-Feira - 18:00-20:00 - Tainara Lelis (6°)  e Hugo Couto",
                "Campus Saúde UFMG", false, false, false,
                true, false, "18:00", "20:00", coordinators, 8);
        groups.put("Campus Saúde UFMG - Quinta-Feira - 18:00-20:00 - Tainara Lelis (6°)  e Hugo Couto", group);

        coordinators.add(new Person("Rafael Nogueira", 10, universities.get("UFMG")));
        coordinators.add(new Person("Letícia Utsch", 8, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Quinta-feira - 18:45-20:15 - Rafael Nogueira (10°)  e Letícia Utsch | Turma em inglês",
                "Campus Saúde UFMG - Quinta-feira - 18:45-20:15 - Rafael Nogueira (10°)  e Letícia Utsch | Turma em inglês",
                "Campus Saúde UFMG", false, false, false,
                true, false, "18:45", "20:15", coordinators, 14);
        groups.put("Campus Saúde UFMG - Quinta-feira - 18:45-20:15 - Rafael Nogueira (10°)  e Letícia Utsch | Turma em inglês", group);

        coordinators.add(new Person("Gustavo Vargas", 7, universities.get("UFMG")));
        coordinators.add(new Person("Brígida Macial", 7, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Sexta-Feira - 12:00-13:30 - Gustavo Vargas (7°)  e Brígida Maciel (7°)",
                "Campus Saúde UFMG - Sexta-Feira - 12:00-13:30 - Gustavo Vargas (7°)  e Brígida Maciel (7°)",
                "Campus Saúde UFMG", false, false, false,
                false, true, "12:00", "13:30", coordinators, 10);
        groups.put("Campus Saúde UFMG - Sexta-Feira - 12:00-13:30 - Gustavo Vargas (7°)  e Brígida Maciel (7°)", group);

        coordinators.add(new Person("Gustavo Domingo", 5, universities.get("UFMG")));
        coordinators.add(new Person("Jamille Vanessa", 5, universities.get("UFMG")));
        coordinators.add(new Person("Gabriel Antonino", 5, universities.get("UFMG")));
        coordinators.add(new Person("Mateus Lima Veras", 5, universities.get("UFMG")));
        coordinators.add(new Person("Cris Ribeiro", 5, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Quinta-Feira - 18h30-20h30 - Gustavo Domingos (5°)  e Jamille Vanessa, Gabriel Antonino, Mateus Lima Veras, Cris Ribeiro",
                "Campus Saúde UFMG - Quinta-Feira - 18h30-20h30 - Gustavo Domingos (5°)  e Jamille Vanessa, Gabriel Antonino, Mateus Lima Veras, Cris Ribeiro",
                "Campus Saúde UFMG", false, false, false,
                true, false, "18:30", "20:30", coordinators, 14);
        groups.put("Campus Saúde UFMG - Quinta-Feira - 18h30-20h30 - Gustavo Domingos (5°)  e Jamille Vanessa, Gabriel Antonino, Mateus Lima Veras, Cris Ribeiro", group);

        coordinators.add(new Person("Rafael Ageu", 10, universities.get("UFMG")));
        coordinators.add(new Person("Rafaela Galvão", 8, universities.get("UFMG")));
        coordinators.add(new Person("Eduarda de Carvalho", 5, universities.get("UFMG")));
        group = newGroup("Campus Saúde UFMG - Sexta-feira - 17h-19:00h - Rafael Ageu (11°)  e Rafaela Galvão e Eduarda de Carvalho (5°)",
                "Campus Saúde UFMG - Sexta-feira - 17h-19:00h - Rafael Ageu (11°)  e Rafaela Galvão e Eduarda de Carvalho (5°)", "Campus Saúde UFMG", false, false, false,
                false, true, "17:00", "19:00", coordinators, 12);
        groups.put("Campus Saúde UFMG - Sexta-feira - 17h-19:00h - Rafael Ageu (11°)  e Rafaela Galvão e Eduarda de Carvalho (5°)", group);

        return groups;
    }

}
