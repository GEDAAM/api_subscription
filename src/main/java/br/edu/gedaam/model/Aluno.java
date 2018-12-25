package br.edu.gedaam.model;

//import lombok.*;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="alunos")
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}