package it.exercise.dao;

import it.exercise.classi.Partecipation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipationDAO {
    private EntityManager em;

    public PartecipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipation partecipation) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(partecipation);
        t.commit();
        System.out.println("Attendance to " + partecipation.getEvent() + " for " + partecipation.getPerson().getName() + " has been created");

    }

    public Partecipation findById(long id) {
        return em.find(Partecipation.class, id);
    }

    public void deleteById(long id) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        Partecipation found = em.find(Partecipation.class, id);
        if (found != null) {
            em.remove(found);
            t.commit();
            System.out.println("Participation has been deleted");

        } else {
            System.out.println("No participation has been found");
        }
    }
}
