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
@Table(name="universities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="universities_sequence")
    @SequenceGenerator(name="universities_sequence", sequenceName="sq_universities")
    private long id;

    private String name;


    public University(String name)   {
        this.name = name;
    }

}
