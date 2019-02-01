package br.edu.gedaam.model;

import br.edu.gedaam.model.enums.StatusTurma;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="turmas")
@Data
public class Turma implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="turmas_sequence")
    @SequenceGenerator(name="turmas_sequence", sequenceName="sq_turmas")
    private long id;

    private String tema;
    private StatusTurma statusTurma;

    private Date dtInicio;
    private Date dtFim;
    private Time horario;

    // Desnormalizado para melhoria de performance
    private Byte segunda_feira;
    private Byte terca_feira;
    private Byte quarta_feira;
    private Byte quinta_feira;
    private Byte sexta_feira;
    private Byte sabado;


    @OneToMany(mappedBy = "turma", targetEntity = Aluno.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Aluno> alunos;

    @OneToMany(targetEntity = Pessoa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pessoa> coordenadores;

    //TODO: adicionar semestre letivo
    //TODO: adicionar horário de fim e início

    public List<Aluno> getAlunos() {
        if (this.alunos == null) {
            this.alunos = new ArrayList<Aluno>();
        }
        return alunos;
    }

    public List<Pessoa> getCoordenadores() {
        if (this.coordenadores == null) {
            this.coordenadores = new ArrayList<Pessoa>();
        }
        return coordenadores;
    }

    public Turma addStudent(Pessoa pessoa)  {
        getAlunos().add(new Aluno(pessoa, this));
        return this;
    }

    public Turma addCoodinator(Pessoa pessoa)  {
        getCoordenadores().add(pessoa);
        return this;
    }

}
