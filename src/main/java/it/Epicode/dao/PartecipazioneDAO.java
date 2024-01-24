package it.Epicode.dao;

import it.Epicode.entities.Evento;
import it.Epicode.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PartecipazioneDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PartecipazioneDAO(){
        emf = Persistence.createEntityManagerFactory("gestione_eventi");
        em = emf.createEntityManager();
    }

    public Partecipazione save(Partecipazione p){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(p);

        et.commit();

        em.refresh(p);

        return p;
    }

    public Partecipazione getById(int id){
        return em.find(Partecipazione.class,id);
    }

    public void delete (int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Partecipazione p = getById(id);
        em.remove(p);

        et.commit();
    }

    public void close(){
        em.close();
    }
}
