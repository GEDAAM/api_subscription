package br.edu.gedaam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="semesters")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Semester {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="semesters_sequence")
    @SequenceGenerator(name="semesters_sequence", sequenceName="sq_semesters")
    private long id;


    private int number;
    private int year;

    private boolean active;

}
