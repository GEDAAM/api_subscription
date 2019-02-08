package br.edu.gedaam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="pessoas")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pessoas_sequence")
    @SequenceGenerator(name="pessoas_sequence", sequenceName="sq_pessoas")
    private long id;

    String nome;
    String cpf;

    String matricula;
    String email;
    String telefone;
    String anoSemestreIngressoFaculdade;
    Integer periodo;


    @OneToMany(mappedBy="pessoa")
    @JsonIgnore
    private List<Aluno> alunos;

    @ManyToOne
    Faculdade faculdade;


    public String getEmail() {
        return email;
    }

    public String getNome()  {
        return nome;
    }

    public Pessoa(String nome, Integer periodo, Faculdade faculdade)  {
        this.nome = nome;
        this.periodo = periodo;
        this.faculdade = faculdade;
    }
}
