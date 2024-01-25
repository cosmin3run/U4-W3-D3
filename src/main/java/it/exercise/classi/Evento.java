package it.exercise.classi;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "events")

public abstract class Evento {
    @Id
    @GeneratedValue

    private long id;


    private String title;


    private LocalDate event_date;


    private String description;


    @Enumerated(EnumType.STRING)
    private EventType eventType;


    private int maxParticipants;

    @ManyToOne
    @JoinColumn(name = "event_location_id")
    private Location locationEvent;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
    private List<Partecipation> partecipationList;


    public Evento(){};

    public Evento(String title, LocalDate event_date, String description, EventType eventType, int maxParticipants, Location locationEvent) {
        this.title = title;
        this.event_date = event_date;
        this.description = description;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
        this.locationEvent = locationEvent;
    }



    public List<Partecipation> getPartecipationList(){return partecipationList;}
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
