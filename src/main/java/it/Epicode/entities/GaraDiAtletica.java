package it.Epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Set;
@Entity
@Table(name = "gare_atletica")
public class GaraDiAtletica {
    private Set<Persona> atleti;
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(Set<Persona> atleti, Persona vincitore) {
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
