package br.edu.gedaam.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="inscricoes")
@Getter
@Setter
public class Inscricao implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inscricao_sequence")
    @SequenceGenerator(name="inscricao_sequence", sequenceName="sq_inscricoes")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="aluno_id")
    private Aluno aluno;


    private String opcao1;

    private String opcao2;

}
