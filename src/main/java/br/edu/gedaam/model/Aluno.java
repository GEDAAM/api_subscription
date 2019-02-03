package br.edu.gedaam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="alunos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="alunos_sequence")
    @SequenceGenerator(name="alunos_sequence", sequenceName="sq_alunos")
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_pessoa", referencedColumnName = "id")
    private Pessoa pessoa;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_turma", referencedColumnName = "id")
    @JsonIgnore
    private Turma turma;

    private boolean frequente;


    public Aluno(Pessoa p, Turma t) {
        this.pessoa = p;
        this.turma = t;
        this.frequente = true;
    }
}
