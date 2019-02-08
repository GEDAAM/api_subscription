package br.edu.gedaam.model;

import br.edu.gedaam.model.enums.StatusTurma;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
public class Turma implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="turmas_sequence")
    @SequenceGenerator(name="turmas_sequence", sequenceName="sq_turmas")
    private long id;

    private String tema;
    private String local;
    private StatusTurma statusTurma;

    private Date dtInicio;
    private Date dtFim;
    private Time horaInicio;
    private Time horaFim;

    // Desnormalizado para melhoria de performance
    private Boolean segundaFeira;
    private Boolean tercaFeira;
    private Boolean quartaFeira;
    private Boolean quintaFeira;
    private Boolean sextaFeira;
    private Boolean sabado;

    private int numeroMaximoVagas;
    private int numeroMinimoInscritos;


    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    @OneToMany(targetEntity = Pessoa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pessoa> coordenadores;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_semestre")
    private SemestreLetivo semestre;


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

    public Turma addCoodinator(Pessoa pessoa)  {
        getCoordenadores().add(pessoa);
        return this;
    }

    public Turma(String tema, String local, boolean segundaFeira, boolean tercaFeira, boolean quartaFeira,
                 boolean quintaFeira, boolean sextaFeira, Time horaInicio, Time horaFim) {
        this.tema = tema;
        this.local = local;
        this.segundaFeira = segundaFeira;
        this.tercaFeira = tercaFeira;
        this.quartaFeira = quartaFeira;
        this.quintaFeira = quintaFeira;
        this.sextaFeira = sextaFeira;
        this.sabado = false;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        numeroMinimoInscritos = 0;
        numeroMaximoVagas = 10;
    }

}
