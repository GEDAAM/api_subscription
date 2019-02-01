package br.edu.gedaam.model;

import br.edu.gedaam.model.enums.Faculdade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="pessoas")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pessoa implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pessoas_sequence")
    @SequenceGenerator(name="pessoas_sequence", sequenceName="sq_pessoas")
    private long id;

    String nome;
    String cpf;
    Faculdade faculdade;
    String matricula;
    String email;
    String telefone;
    String anoSemestreIngressoFaculdade;


    @OneToMany(mappedBy="pessoa")
    @JsonIgnore
    private List<Aluno> alunos;
}
