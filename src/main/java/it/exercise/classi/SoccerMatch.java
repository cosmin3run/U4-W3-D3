package it.exercise.classi;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "matches")
@NamedQuery(name = "get_home_winning_match", query = "SELECT m FROM SoccerMatch m WHERE m.goalsHomeTeam > m.goalsAwayTeam")
@NamedQuery(name = "get_away_winning_match", query = "SELECT m FROM SoccerMatch m WHERE m.goalsHomeTeam < m.goalsAwayTeam")

public class SoccerMatch extends Evento {

    @Column(nullable = false)
    private String homeTeam;

    @Column(nullable = false)
    private String awayTeam;

    private String winningTeam;

    @Column(nullable = false)
    private int goalsHomeTeam;

    @Column(nullable = false)
    private int goalsAwayTeam;


    public SoccerMatch() {
    }

    public SoccerMatch(String title, LocalDate event_date, String description, EventType eventType, int maxParticipants, Location locationEvent, String homeTeam, String awayTeam) {
        super(title, event_date, description, eventType, maxParticipants, locationEvent);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(int goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(int goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    @Override
    public String toString() {
        return "SoccerMatch{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", goalsHomeTeam=" + goalsHomeTeam +
                ", goalsAwayTeam=" + goalsAwayTeam +
                '}';
    }
}
