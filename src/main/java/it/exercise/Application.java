package it.exercise;

import it.exercise.classi.EventType;
import it.exercise.classi.Evento;
import it.exercise.classi.Gender;
import it.exercise.classi.Person;
import it.exercise.dao.EventsDAO;
import it.exercise.dao.PersonDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        System.out.println("Esercitazione CRUD java-sql");

        EntityManager em = emf.createEntityManager();
        EventsDAO eventsDao = new EventsDAO(em);
        PersonDAO personDAO = new PersonDAO(em);



        LocalDate date = LocalDate.of(2022, 12,25);

        Evento prototypeX = new Evento("Eden Prototype X", LocalDate.of(2023,05,13) , "Il Prototype è il festival internazionale che richiama atleti e atlete da tutta Europa e accoglie sportiv*, neofit* e curios*", EventType.PRIVATE, 150);
        Evento krap = new Evento("Krap Invaders", date, "Una nuova edizione del KRAP INVADERS è alle porte! Il 21-22 Ottobre 2023 il KRAPANNONE vi aspetta per 2 giorni di allenamento e divertimento assieme ad ospiti Nazionali e Internazionali!", EventType.PRIVATE, 90);
        //----------------ADDING A PERSON ------------------
        LocalDate marioDate = LocalDate.of(2022, 12,25)
        Person marioRossi = new Person("Mario", "Rossi", "Mario@gmail.com", marioDate, Gender.M, krap);
        // SAVE
        eventsDao.save(prototypeX);
        eventsDao.save(krap);
         //FIND BY ID
//        long id = 5;
//        Evento firstEvent = eventsDao.getById(id);
//        if (firstEvent != null) {
//            System.out.println(firstEvent);
//        } else {
//            System.out.println("No events with such id found");
//        }
//        //DELETE BY ID
//        eventsDao.deleteById(5);

        em.close();
        emf.close();

    }
}
