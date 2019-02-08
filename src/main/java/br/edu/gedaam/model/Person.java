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
@Table(name="people")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="people_sequence")
    @SequenceGenerator(name="people_sequence", sequenceName="sq_people")
    private long id;

    String name;
    String cpf;

    String registrationNumber;
    String email;
    String phone;
    Integer period;


    @OneToMany(mappedBy="person")
    @JsonIgnore
    private List<Student> students;

    @ManyToOne
    University university;

    public Person(String name, Integer period, University university)  {
        this.name = name;
        this.period = period;
        this.university = university;
    }
}
