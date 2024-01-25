package it.exercise.classi;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "athletics_competition")

public class AtlethicsCompetition extends Evento {

    @ManyToMany
    @JoinTable(name = "competiotion_person", joinColumns = @JoinColumn(name = "competition_id"), inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private Set<Person> athlete;

    @ManyToOne
    @JoinColumn(name = "winner")
    private Person winner;

    public AtlethicsCompetition() {
    }

    public AtlethicsCompetition(String title, LocalDate event_date, String description, EventType eventType, int maxParticipants, Location locationEvent) {
        super(title, event_date, description, eventType, maxParticipants, locationEvent);

    }

    public Set<Person> getAthlete() {
        return athlete;
    }

    public void setAthlete(Set<Person> athlete) {
        this.athlete = athlete;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AtlethicsCompetition{" +
                "athlete=" + athlete +
                ", winner=" + winner +
                '}';
    }
}
