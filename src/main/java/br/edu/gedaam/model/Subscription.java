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
import java.sql.Timestamp;

@Entity
@Table(name="subscriptions")
@Data
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="subscriptions_sequence")
    @SequenceGenerator(name="subscriptions_sequence", sequenceName="sq_subscriptions")
    private long id;

    private Timestamp subscriptionTimeStamp;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_person")
    private Person person;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_semester")
    private Semester semester;

   @OneToOne(fetch= FetchType.LAZY)
   @JoinColumn(name="id_group_option1")
    private Group groupOption1;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_group_option2")
    private Group groupOption2;

}
