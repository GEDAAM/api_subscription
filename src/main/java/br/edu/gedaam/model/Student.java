package br.edu.gedaam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="students_sequence")
    @SequenceGenerator(name="students_sequence", sequenceName="sq_students")
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_person", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name="id_group", referencedColumnName = "id")
    @JsonIgnore
    private Group group;

    private boolean frequent;


    public Student(Person p, Group g) {
        this.person = p;
        this.group = g;
        this.frequent = true;
    }
}
