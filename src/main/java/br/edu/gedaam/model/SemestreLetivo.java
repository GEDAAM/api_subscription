package br.edu.gedaam.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="semestres_letivos")
@Data
public class SemestreLetivo {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="semestres_sequence")
    @SequenceGenerator(name="semestres_sequence", sequenceName="sq_semestres")
    private long id;


    private boolean ativo;

}
