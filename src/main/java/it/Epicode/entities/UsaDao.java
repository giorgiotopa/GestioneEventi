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
        Persona persona = new Persona();
        persona.setNome("NomePersona");
        persona.setCognome("CognomePersona");
        persona.setEmail("email@example.com");
        persona.setDataDiNascita(LocalDate.of(1990, 1, 1));
        persona.setSesso(Sesso.M);

        // Salva la Persona nel database
        personaDAO.save(persona);

    }
}
