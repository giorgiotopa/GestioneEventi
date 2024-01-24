package it.Epicode;

import it.Epicode.dao.EventoDAO;
import it.Epicode.entities.Evento;
import it.Epicode.entities.TipoEvento;

import java.time.LocalDate;

public class UsaEventoDAO {
    public static void main(String[] args) {
        EventoDAO dao = new EventoDAO();

        Evento e = new Evento();
        e.setTitolo("Festival");
        e.setDataEvento(LocalDate.of(2024,5,18));
        e.setDescrizione("Musicale");
        e.setTipoEvento(TipoEvento.PUBBLICO);
        e.setNumeroMassimoPartecipanti(2500);

        dao.save(e);
        System.out.println(e);
    }
}
