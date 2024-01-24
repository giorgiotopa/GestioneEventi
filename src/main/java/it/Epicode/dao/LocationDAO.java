package it.Epicode.dao;

import it.Epicode.entities.Evento;
import it.Epicode.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LocationDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public LocationDAO(){
        emf = Persistence.createEntityManagerFactory("gestione_eventi");
        em = emf.createEntityManager();
    }

    public Location save(Location l){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(l);

        et.commit();

        em.refresh(l);

        return l;
    }

    public Location getById(int id){
        return em.find(Location.class,id);
    }

    public void delete (int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Location l = getById(id);
        em.remove(l);

        et.commit();
    }

    public void close(){
        em.close();
    }
}
