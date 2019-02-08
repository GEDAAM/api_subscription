package br.edu.gedaam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="faculdades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculdade {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="faculdades_sequence")
    @SequenceGenerator(name="faculdades_sequence", sequenceName="sq_faculdades")
    private long id;

    private String nome;


    public Faculdade(String nome)   {
        this.nome = nome;
    }

}
