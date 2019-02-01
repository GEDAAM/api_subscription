package br.edu.gedaam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="alunos_sequence")
    @SequenceGenerator(name="alunos_sequence", sequenceName="sq_alunos")
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_turma")
    private Turma turma;

    private boolean frequente;

    public Aluno(Pessoa pessoa, Turma turma)  {
        this.pessoa = pessoa;
        this.turma = turma;
        this.frequente = true;
    }

}
