package it.Epicode.dao;

import it.Epicode.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EventoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EventoDAO(){
    emf = Persistence.createEntityManagerFactory("gestione_eventi");
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

}
