package it.exercise.classi;

import javax.persistence.*;

@Entity
@Table(name= "partecipation")
public class Partecipation {
    @Id
    @GeneratedValue
    private long id;

    private Evento event;
    private ParticipationStatus partecipationStatus;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Partecipation() {
    }

    public Partecipation( Person person, Evento event, ParticipationStatus partecipationStatus) {

        this.person = person;
        this.event = event;
        this.partecipationStatus = partecipationStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Evento getEvent() {
        return event;
    }

    public void setEvent(Evento event) {
        this.event = event;
    }

    public ParticipationStatus getPartecipationStatus() {
        return partecipationStatus;
    }

    public void setPartecipationStatus(ParticipationStatus partecipationStatus) {
        this.partecipationStatus = partecipationStatus;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                ", partecipationStatus=" + partecipationStatus +
                '}';
    }
}
