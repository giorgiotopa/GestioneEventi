package it.Epicode.entities;

import it.Epicode.dao.EventoDAO;
import it.Epicode.dao.LocationDAO;
import it.Epicode.dao.PartecipazioneDAO;
import it.Epicode.dao.PersonaDAO;

import java.time.LocalDate;

public class UsaDao {
    public static void main(String[] args) {

        //Inizializza DAO
        PersonaDAO personaDAO = new PersonaDAO();
        LocationDAO locationDAO = new LocationDAO();
        EventoDAO eventoDAO = new EventoDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        // Crea una Persona
        Persona persona1 = new Persona();
        persona1.setNome("Persona1");
        persona1.setCognome("CognomePersona");
        persona1.setEmail("email@example.com");
        persona1.setDataDiNascita(LocalDate.of(1990, 1, 1));
        persona1.setSesso(Sesso.M);

        Persona persona2 = new Persona();
        persona2.setNome("Persona2");
        persona2.setCognome("CognomePersona");
        persona2.setEmail("email@example.com");
        persona2.setDataDiNascita(LocalDate.of(1990, 1, 1));
        persona2.setSesso(Sesso.M);

        // Salva la Persona nel database
        personaDAO.save(persona1);
        personaDAO.save(persona2);

        Location location = new Location();
        location.setCittà("Roma");

        locationDAO.save(location);

        Evento ev1 = new Evento();
        ev1.setDescrizione("concerto");
        ev1.setLocation(location);

        Evento ev2 = new Evento();
        ev2.setDescrizione("corsa");
        ev2.setLocation(location);

        eventoDAO.save(ev1);
        eventoDAO.save(ev2);

        Partecipazione pa1 = new Partecipazione();
        pa1.setPersona(persona1);
        pa1.setEvento(ev1);

        Partecipazione pa2 = new Partecipazione();
        pa1.setPersona(persona1);
        pa1.setEvento(ev2);

        Partecipazione pa3 = new Partecipazione();
        pa1.setPersona(persona2);
        pa1.setEvento(ev1);

        partecipazioneDAO.save(pa1);
        partecipazioneDAO.save(pa2);
        partecipazioneDAO.save(pa3);
    }
}
