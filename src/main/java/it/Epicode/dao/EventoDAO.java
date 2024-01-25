package it.Epicode.dao;

import it.Epicode.entities.GenereMusica;
import it.Epicode.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class EventoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EventoDAO(){
    emf = Persistence.createEntityManagerFactory("gestioneeventi");
    em = emf.createEntityManager();
    }

    public Evento save(Evento e){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(e);

        et.commit();

        em.refresh(e);

        return e;
    }

    public Evento getById(int id){
        return em.find(Evento.class,id);
    }

    public void delete (int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Evento e = getById(id);
        em.remove(e);

        et.commit();
    }

    public void close(){
        em.close();
    }

    // Metodo per ottenere i concerti in streaming in base al flag (true/false)
    public List getConcertiInStreaming(boolean inStreaming) {
        return em.createQuery(
                        "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming")
                .setParameter("inStreaming", inStreaming)
                .getResultList();
    }

    // Metodo per ottenere i concerti per genere
    public List getConcertiPerGenere(GenereMusica genere) {
        return em.createQuery(
                        "SELECT c FROM Concerto c WHERE c.genere = :genere")
                .setParameter("genere", genere)
                .getResultList();
    }

}
