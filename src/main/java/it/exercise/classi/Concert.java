package it.exercise.classi;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "concerts")
@NamedQuery(name = "get_streamed_concerts", query = "SELECT c FROM Concert WHERE c.streaming=:streaming")

public class Concert extends Evento {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private boolean streaming;

    //CONSTRUCTORS

    public Concert() {
    }

    public Concert(String title, LocalDate event_date, String description, EventType eventType, int maxParticipants, Location locationEvent, Gender gender, boolean streaming) {
        super(title, event_date, description, eventType, maxParticipants, locationEvent);
        this.gender = gender;
        this.streaming = streaming;
    }

    //GETTERS AND SETTERS


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    //TOSTRING


    @Override
    public String toString() {
        return "Concert{" +
                "gender=" + gender +
                ", streaming=" + streaming +
                '}';
    }
}
