package br.edu.gedaam.model;

import br.edu.gedaam.model.enums.GroupStatus;
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
@Table(name="groups")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
public class Group implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="groups_sequence")
    @SequenceGenerator(name="groups_sequence", sequenceName="sq_groups")
    private long id;

    private String theme;
    private String local;
    private GroupStatus status;

    private Date dateBegin;
    private Date dateEnd;
    private Time timeBegin;
    private Time timeEnd;

    // Desnormalizado para melhoria de performance
    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;

    private int maxOfStudents;
    private int minOfStudents;


    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @OneToMany(targetEntity = Person.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> coordinators;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_semester")
    private Semester semester;


    public List<Student> getStudents() {
        if (this.students == null) {
            this.students = new ArrayList<>();
        }
        return students;
    }

    public List<Person> getCoordinators() {
        if (this.coordinators == null) {
            this.coordinators = new ArrayList<>();
        }
        return coordinators;
    }

    public Group addCoodinator(Person person)  {
        getCoordinators().add(person);
        return this;
    }

    public Group(String theme, String local, boolean monday, boolean tuesday, boolean wednesday,
                 boolean thursday, boolean friday, Time timeBegin, Time timeEnd) {
        this.theme = theme;
        this.local = local;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = false;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        minOfStudents = 0;
        maxOfStudents = 10;
    }

}
