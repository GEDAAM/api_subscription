package br.edu.gedaam.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="alunos")
@Getter
@Setter
public class Aluno  implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aluno_sequence")
    @SequenceGenerator(name="aluno_sequence", sequenceName="sq_alunos")
    private Long id;

    private String nome;

    private String faculdade;

    private String matricula;

    @Column(unique = true, length = 11)
    private String cpf;

    @OneToMany(mappedBy = "aluno")
    private List<Inscricao> inscricoes;
}