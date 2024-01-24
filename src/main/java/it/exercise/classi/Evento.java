package it.exercise.classi;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Events")

public class Evento {
    @Id
    @GeneratedValue

    private long id;

    @Column(name="title")
    private String title;

    @Column(name="event_date")
    private LocalDate event_date;

    @Column(name="description")
    private String description;

    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "max_participants")
    private int maxParticipants;

    @ManyToMany
    @JoinTable(name = "event_person",
    joinColumns = @JoinColumn(name="event_id"),
    inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> personList;

    public Evento(){};

    public Evento(String title, LocalDate event_date, String description, EventType eventType, int maxParticipants) {
        this.title = title;
        this.event_date = event_date;
        this.description = description;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
    }

    public List<Person> getPersonList() {return personList;}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", event_date='" + event_date + '\'' +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxParticipants=" + maxParticipants +
                '}';
    }
}
