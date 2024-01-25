package it.Epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "concerti")
public class Concerto {
    private GenereMusica genere;
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(GenereMusica genere, boolean inStreaming) {
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereMusica getGenere() {
        return genere;
    }

    public void setGenere(GenereMusica genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
