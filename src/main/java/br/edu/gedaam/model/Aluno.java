package br.edu.gedaam.model;

//import lombok.*;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="alunos")
@Data
public class Aluno  implements Serializable {

    private static final long serialVersionUID = -5627354148312027848L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aluno_sequence")
    @SequenceGenerator(name="aluno_sequence", sequenceName="sq_alunos")
    private long id;

    private String nome;

    private String faculdade;

    private String matricula;

    private String cpf;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}