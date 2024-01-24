package it.Epicode.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "persona_fk")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "evento_fk")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(){}

    public Partecipazione(Long id, Persona persona, Evento evento, Stato stato) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }


    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

//    @Override
//    public String toString() {
//        return "Partecipazione{" +
//                "id=" + id +
//                ", persona=" + persona +
//                ", evento=" + evento +
//                ", stato=" + stato +
//                '}';
//    }
}
