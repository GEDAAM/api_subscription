package br.edu.gedaam.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="inscricoes")
@Data
public class Inscricao implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inscricao_sequence")
    @SequenceGenerator(name="inscricao_sequence", sequenceName="sq_inscricoes")
    private long id;

    //@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="aluno_id")
    //private Aluno aluno;


    private String opcao1;

    private String opcao2;

}
