package br.edu.gedaam.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurmaTest {

    @Test
    public void addStudent() {
        Turma turma = new Turma();
        turma.setId(1);

        turma.addStudent(newPessoa());

        assertTrue(turma.getAlunos() != null);
        assertTrue(turma.getAlunos().get(0).getTurma().getId()==1);

    }

    private Pessoa newPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setAnoSemestreIngressoFaculdade("012018");
        pessoa.setCpf("05061478606");
        pessoa.setFaculdade(Faculdade.UFMG);
        pessoa.setEmail("raqlem@gmail.com");
        pessoa.setMatricula("2018123456");
        pessoa.setNome("Raquel Lemos");
        pessoa.setTelefone("31997871948");
        return pessoa;
    }
}