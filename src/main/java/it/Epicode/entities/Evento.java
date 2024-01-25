package it.Epicode.entities;



import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "gestione_eventi")
public class Evento {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String titolo;
        @Column(name = "data_evento")
        private LocalDate dataEvento;
        private String descrizione;

        @Enumerated(EnumType.STRING)
        private TipoEvento tipoEvento;
        @Column(name = "numero_massimo-partecipanti")
        private int numeroMassimoPartecipanti;

        @ManyToOne
        @JoinColumn(name = "location_fk")
        private Location location;
        @OneToMany(mappedBy = "evento",cascade = CascadeType.REMOVE)
        private List<Partecipazione> partecipazioni;

        // Costruttori
        public Evento() {
            // Costruttore vuoto necessario per JPA
        }

        public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
            this.titolo = titolo;
            this.dataEvento = dataEvento;
            this.descrizione = descrizione;
            this.tipoEvento = tipoEvento;
            this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location +
                '}';
    }
}
