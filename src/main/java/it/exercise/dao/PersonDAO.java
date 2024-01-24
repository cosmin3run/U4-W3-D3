package it.exercise.dao;

import it.exercise.classi.Evento;
import it.exercise.classi.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Locale;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em){this.em = em;}

    public void save(Person p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Person have been added");

    }

    public Person findById(long id){
        return em.find(Person.class, id);
    }

    public void deleteById(long id) {
        Person found = em.find(Person.class, id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("The person"+ found + "has been deleted");
        } else {
            System.out.println("The Id is not connected to any person");
        }
    }



}
