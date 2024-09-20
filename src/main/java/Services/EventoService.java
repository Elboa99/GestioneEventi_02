package Services;

import Repositories.EventoRepository;
import kennyboateng.GestioneEventi_02.Entities.Evento;
import kennyboateng.GestioneEventi_02.Excepitions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;


    public Evento salvaEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> trovaTuttiEventi() {
        return eventoRepository.findAll();
    }

    public Evento trovaEventoById(Long eventoId) {
        return eventoRepository.findById(eventoId)
                .orElseThrow(() -> new NotFoundException("Evento " + eventoId + " non trovato"));
    }

    public void cancellaEventoById(Long eventoId) {
        Evento evento = trovaEventoById(eventoId);
        eventoRepository.delete(evento);
    }
}
