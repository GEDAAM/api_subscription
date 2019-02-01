package br.edu.gedaam.model;

import lombok.Data;

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
@Table(name="inscricoes")
@Data
public class Inscricao implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inscricoes_sequence")
    @SequenceGenerator(name="inscricoes_sequence", sequenceName="sq_inscricoes")
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_semestre")
    private SemestreLetivo semestre;

   @OneToOne(fetch= FetchType.LAZY)
   @JoinColumn(name="id_turma_opcao1")
    private Turma opcao1;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_turma_opcao2")
    private Turma opcao2;

}
