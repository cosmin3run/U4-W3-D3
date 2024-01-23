package it.exercise.dao;

import it.exercise.classi.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventsDAO {
    private final EntityManager em;
    public EventsDAO(EntityManager em) {this.em = em;}

    public void save(Evento event){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("Event " + event.getTitle() + " has been added to the DB" );
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void deleteById(long id) {
        Evento idFound = this.getById(id);

        if (idFound != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(idFound);
            transaction.commit();
            System.out.println("Event '" + idFound.getTitle() + "' has been deleted");
        } else System.out.println("no event with Id '" + id + " has been found");
    }
}
