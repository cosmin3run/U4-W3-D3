package it.exercise.dao;

import it.exercise.classi.Location;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private EntityManager em;
    public LocationDAO(EntityManager em){this.em = em;}

    public void  save (Location location){
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(location);
        t.commit();
        System.out.println("This location has been added");
    }

    public Location findById(long id) {return em.find(Location.class, id);}

    public void deleteById(long id) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        Location found = em.find(Location.class, id);
        if (found != null){
            em.remove(found);
            t.commit();
            System.out.println("This location has been deleted");
        } else {
            System.out.println("Location not found");}
    }
}
